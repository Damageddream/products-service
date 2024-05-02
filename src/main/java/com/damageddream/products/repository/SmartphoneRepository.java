package com.damageddream.products.repository;

import com.damageddream.products.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long>{
}
