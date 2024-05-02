package com.damageddream.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@PrimaryKeyJoinColumn(name = "computer_id")
public class Computer extends Product{
    private String cpu;
    private String gpu;
    private String ram;
    private String storage;
}
