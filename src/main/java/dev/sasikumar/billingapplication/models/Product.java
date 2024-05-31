package dev.sasikumar.billingapplication.models;

import dev.sasikumar.billingapplication.Enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private ProductType productType;     //Enum (BAG, Weight)
    private int quantity;
    private Integer weight;
    private int price;
    private int amount;
}
