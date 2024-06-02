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
    private List<ProductDto> products;
    private double amount;

    public void setProducts(List<ProductDto> products) {
        this.products = products;
        this.amount = products.stream().map(ProductDto::getAmount).reduce(0.0, (Double::sum));
    }
}
