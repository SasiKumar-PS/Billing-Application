package dev.sasikumar.billingapplication.models;

import dev.sasikumar.billingapplication.Enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String name;
    private ProductType productType;     //Enum (BAG, Weight)
    private int quantity;
    private Integer weight;
    private int price;
    private int amount;
}
