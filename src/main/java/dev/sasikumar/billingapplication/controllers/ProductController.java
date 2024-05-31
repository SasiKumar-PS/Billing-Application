package dev.sasikumar.billingapplication.controllers;

import dev.sasikumar.billingapplication.DTOs.ProductDto;
import dev.sasikumar.billingapplication.models.Product;
import dev.sasikumar.billingapplication.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable("name") String name) {
        return productService.getProduct(name);
    }

    @PutMapping("/{name}")
    public Product updateProduct(@PathVariable("name") String name) {
        return productService.updateProduct(name);
    }

    @DeleteMapping("/{name}")
    public String deleteProduct(@PathVariable("name") String name) {
        return productService.deleteProduct(name);
    }
}
