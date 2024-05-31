package dev.sasikumar.billingapplication.DTOs;

import dev.sasikumar.billingapplication.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BillDto {
    private Integer id;
    private String businessName;
    private LocalDate date;
    private List<Product> products;
    private int amount;
}
