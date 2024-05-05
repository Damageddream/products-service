package com.damageddream.products.repository;

import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Smartphone> findByName(String name);
}
