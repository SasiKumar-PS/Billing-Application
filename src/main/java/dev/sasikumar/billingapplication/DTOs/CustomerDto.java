package dev.sasikumar.billingapplication.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String name;
    private String businessName;
    private String phoneNumber;
    private String address;
    private double balance;
}
