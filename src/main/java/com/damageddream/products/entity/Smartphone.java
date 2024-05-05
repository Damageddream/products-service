package com.damageddream.products.entity;

import com.damageddream.products.entity.enums.Accessories;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@PrimaryKeyJoinColumn(name = "smartphone_id")
public class Smartphone extends Product {
    private String color;
    private String battery;
    @ElementCollection(targetClass = Accessories.class)
    @Enumerated(EnumType.STRING)
    private List<Accessories> accessories;
}
