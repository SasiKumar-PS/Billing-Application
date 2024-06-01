package dev.sasikumar.billingapplication.converter;

import dev.sasikumar.billingapplication.DTOs.ProductDto;
import dev.sasikumar.billingapplication.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {

    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setProductType(productDto.getProductType());
        product.setQuantity(productDto.getQuantity());
        product.setWeight(productDto.getWeight());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());

        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setName(product.getName());
        productDto.setProductType(product.getProductType());
        productDto.setQuantity(product.getQuantity());
        productDto.setWeight(product.getWeight());
        productDto.setPrice(product.getPrice());
        productDto.setAmount(product.getAmount());

        return productDto;
    }

    public static List<Product> toProductList(List<ProductDto> productDtos) {
        List<Product> products = new ArrayList<>();

        for(ProductDto productDto : productDtos) {
            products.add(toProduct(productDto));
        }

        return products;
    }

    public static List<ProductDto> toProductDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products) {
            productDtos.add(toProductDto(product));
        }

        return productDtos;
    }
}
