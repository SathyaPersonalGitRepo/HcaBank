package com.hcabank.data.model;

import lombok.*;

import javax.persistence.*;
@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private Long id;
    private String name;
    private int age;
    private String address;
    private String social;
}
