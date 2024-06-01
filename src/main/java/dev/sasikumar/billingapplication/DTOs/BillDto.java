package dev.sasikumar.billingapplication.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BillDto {
    private Integer billId;
    private String businessName;
    private LocalDate date;
    private List<ProductDto> products;     // need to make List<ProductDto>
    private int amount;
}
