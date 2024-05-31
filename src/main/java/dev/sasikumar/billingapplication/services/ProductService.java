package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.DTOs.ProductDto;
import dev.sasikumar.billingapplication.models.Product;

public interface ProductService {
    Product createProduct(ProductDto productDto);
    Product getProduct(String name);
    Product updateProduct(String name);
    String deleteProduct(String name);
}
