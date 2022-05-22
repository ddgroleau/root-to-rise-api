package com.rtr.api.application.repository.abstraction;

import com.rtr.api.application.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}