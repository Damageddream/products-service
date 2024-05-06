package com.damageddream.products.repository;

import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.Smartphone;
import com.damageddream.products.entity.enums.ProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Smartphone> findByName(String name);
    List<Product> findByProductType(ProductTypes productType);
}
