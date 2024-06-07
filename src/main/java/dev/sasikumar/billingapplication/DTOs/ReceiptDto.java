package dev.sasikumar.billingapplication.DTOs;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReceiptDto {
    private Integer id;
    private String businessName;
    private LocalDate date;
    private double amount;
    private double discount;
    private double totalAmount = amount + discount;
}
