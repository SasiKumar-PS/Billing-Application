package dev.sasikumar.billingapplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private Integer Id;
    private Customer customer;
    private LocalDate date;
    private Integer amount;
}
