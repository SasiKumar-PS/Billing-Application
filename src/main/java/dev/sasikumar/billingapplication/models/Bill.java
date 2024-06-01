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
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer Id;

    @ManyToOne
    private Customer customer;
    private LocalDate date;
    private Integer amount;

    @ElementCollection
    private List<Product> products;
}
