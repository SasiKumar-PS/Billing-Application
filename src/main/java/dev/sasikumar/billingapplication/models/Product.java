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
@Embeddable
public class Product {
    private String name;
    private ProductType productType = ProductType.BAG;     //default ProductType
    private double quantity;
    private double weight;
    private double price;
    private double amount = price * weight;  // default value

    public void setPrice(double price) {
        this.price = price;
        amount = (productType.equals(ProductType.BAG)) ?
                quantity * price : weight * price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
        amount = (productType.equals(ProductType.BAG)) ?
                quantity * price : weight * price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        amount = (productType.equals(ProductType.BAG)) ?
                quantity * price : weight * price;
    }

    public void setProductType (ProductType productType) {
        if(productType != null) this.productType = productType;
        // By this way, we won't have null value in productType
    }
}
