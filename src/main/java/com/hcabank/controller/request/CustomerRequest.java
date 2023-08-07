package com.hcabank.controller.request;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerRequest {
    //private String id;
    private String name;
    private int age;
    private String address;
    private String social;
}
