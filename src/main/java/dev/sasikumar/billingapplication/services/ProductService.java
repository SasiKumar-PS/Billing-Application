package dev.sasikumar.billingapplication.services;

import dev.sasikumar.billingapplication.models.Product;

public interface ProductService {
    Product createProduct();
    Product getProduct();
    Product updateProduct();
    String deleteProduct();
}
