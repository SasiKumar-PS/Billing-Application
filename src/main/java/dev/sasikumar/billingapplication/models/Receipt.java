package dev.sasikumar.billingapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipt {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    private Customer customer;
    private LocalDate date;
    private double amount;
    private double discount;    // on update the receipt, we shouldn't update the discount
    private double totalAmount = amount + discount;
}
