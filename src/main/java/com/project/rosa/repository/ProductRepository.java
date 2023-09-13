package com.project.rosa.repository;

import com.project.rosa.models.Product;
import com.project.rosa.models.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStatus(ProductStatus productStatus);
}
