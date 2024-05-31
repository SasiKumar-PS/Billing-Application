package dev.sasikumar.billingapplication.repositorys;

import dev.sasikumar.billingapplication.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
