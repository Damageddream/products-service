package com.damageddream.products.entity;

import com.damageddream.products.entity.enums.ProductTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ProductTypes productType;
    private boolean visibleToSell;
    @ManyToMany
    private Set<Product> configurations;
    @ManyToMany
    private Set<Product> possibleConfigurations;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product other)) return false;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
