package dev.sasikumar.billingapplication.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {
    private String name;
    private String businessName;
    private String phoneNumber;
    private String address;
    private Integer balance;
}
