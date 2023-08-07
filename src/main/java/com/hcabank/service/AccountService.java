package com.hcabank.service;

import com.hcabank.controller.request.AccountRequest;
import com.hcabank.controller.request.DepositRequest;
import com.hcabank.controller.request.InternalTransferRequest;
import com.hcabank.controller.request.WithdrawalRequest;
import com.hcabank.data.model.Account;
import com.hcabank.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Boolean createAccount(AccountRequest accountRequest){
        Account account = Account.builder()
        .accountNumber(accountRequest.getAccountNumber())
                .currentBalance(accountRequest.getAmount()).build();
        accountRepository.save(account);
        return Boolean.TRUE;
    }

    public Boolean updateAccount(AccountRequest accountRequest){
        Account account = accountRepository.
                findByAccountNumber(accountRequest.getAccountNumber());
        account.setCurrentBalance(accountRequest.getAmount());
        accountRepository.save(account);
        return Boolean.TRUE;
    }


    public Account getAccount(String accountNumber){
        Account account = accountRepository.
                findByAccountNumber(accountNumber);

        return  account;
    }

    public List<Account> getAccounts(){
        List<Account> accounts = accountRepository.
                findAll();

        return  accounts;
    }


    public Boolean removeAccount(AccountRequest accountRequest){
        Account account = accountRepository.findByAccountNumber(accountRequest.getAccountNumber());
        accountRepository.delete(account);
        return  Boolean.TRUE;
    }


    public Boolean transfer(InternalTransferRequest transferRequest) {
        String fromAccountNo = transferRequest.getFromAccountNumber();
        String toAccountNo = transferRequest.getToAccountNumber();
        BigDecimal transferAmount = transferRequest.getAmount();

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNo);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNo);
        if(fromAccount.getCurrentBalance().compareTo(BigDecimal.ZERO) > 0
                && fromAccount.getCurrentBalance().compareTo(transferAmount) >= 0
        ) {
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(transferAmount));
            accountRepository.save(fromAccount);
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(transferAmount));
            accountRepository.save(toAccount);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public Boolean deposit(DepositRequest depositRequest) {
        Account depositTo = accountRepository.findByAccountNumber(depositRequest.getToAccountNumber());
        depositTo.setCurrentBalance(depositTo.getCurrentBalance().add(depositRequest.getAmount()));
        accountRepository.save(depositTo);
        return Boolean.TRUE;

    }

    public Boolean withdraw(WithdrawalRequest withdrawalRequest) {
        Account withdrawableAccount = accountRepository.findByAccountNumber(withdrawalRequest.getFromAccountNumber());
        if (withdrawableAccount.getCurrentBalance().compareTo(withdrawalRequest.getAmount()) > 0) {
            withdrawableAccount.setCurrentBalance(withdrawableAccount.getCurrentBalance().subtract(withdrawalRequest.getAmount()));
            accountRepository.save(withdrawableAccount);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /*public synchronized boolean transferAmount(BaseAccount from, BaseAccount to, BigDecimal amount) {
        BigDecimal balance = BigDecimal.ZERO;
        if (from instanceof Savings) {
            Savings savings = (Savings) from;
            //check to see if we have sufficient balance before transferring.
            if (savings.getAmount().compareTo(amount) > 0) {
                if (to instanceof Account) {
                    Account account = (Account)to;
                    BigDecimal checkingBalanceAfterTransfer = account.getAmount().add(amount);
                    BigDecimal savingsBalanceAfterTransfer = savings.getAmount().subtract(amount);
                    account.setAmount(checkingBalanceAfterTransfer);
                    savings.setAmount(savingsBalanceAfterTransfer);
                    checkingAccountRepository.save(account);
                    savingsAccountRepository.save(savings);
                    return true;

                }

            }
            return false;

        }
        return false;

    }*/
}
