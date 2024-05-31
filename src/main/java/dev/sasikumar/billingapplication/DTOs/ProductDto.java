package dev.sasikumar.billingapplication.DTOs;

import dev.sasikumar.billingapplication.Enums.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private ProductType productType;
    private int quantity;
    private Integer weight;
    private int price;
}
