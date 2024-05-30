package dev.sasikumar.billingapplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private Integer Id;
    private Customer customer;
    private LocalDate date;
    private List<Product> products;
    private Integer amount;
}
