package dev.sasikumar.billingapplication.models;

import jakarta.persistence.*;
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
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    private Customer customer;
    private LocalDate date;
    private double amount;

    @ElementCollection
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
        this.amount = products.stream().map(Product::getAmount).reduce(0.0, (Double::sum));
    }
}
