package dev.sasikumar.billingapplication.DTOs;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReceiptDto {
    private String businessName;
    private LocalDate date;
    private Integer amount;
}
