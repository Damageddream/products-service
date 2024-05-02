package com.damageddream.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@PrimaryKeyJoinColumn(name = "smartphone_id")
public class Smartphone extends Product {
    private String color;
    private String battery;
    @ElementCollection(targetClass = Accessories.class)
    @Enumerated(EnumType.STRING)
    private List<Accessories> accessories;
}
