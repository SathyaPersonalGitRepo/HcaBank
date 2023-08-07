package com.hcabank.controller;


import com.hcabank.controller.request.AccountRequest;
import com.hcabank.controller.request.DepositRequest;
import com.hcabank.controller.request.InternalTransferRequest;
import com.hcabank.controller.request.WithdrawalRequest;
import com.hcabank.data.model.Account;
import com.hcabank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankingController {

    @Autowired
    private AccountService accountService;

    /**
     * test endpoint
     * @return
     */
    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Account Management... !!!";
    }

    @PostMapping("/transfer")
    public Boolean transferMoney(@RequestBody InternalTransferRequest transferRequest) {
        return accountService.transfer(transferRequest);

    }
    @PostMapping("/deposit")
    public Boolean deposit(@RequestBody DepositRequest depositRequest) {
        return accountService.deposit(depositRequest);

    }
    @PostMapping("withdraw")
    public Boolean deposit(@RequestBody WithdrawalRequest withdrawalRequest) {
        return accountService.withdraw(withdrawalRequest);

    }

    @PostMapping
    public Boolean createAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.createAccount(accountRequest);

    }

    @PutMapping
    public Boolean updateAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.updateAccount(accountRequest);

    }
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccount(accountNumber);

    }
    @GetMapping()
    public List<Account> getAccounts() {
        return accountService.getAccounts();

    }

    @DeleteMapping
    public Boolean deleteAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.removeAccount(accountRequest);

    }



}
