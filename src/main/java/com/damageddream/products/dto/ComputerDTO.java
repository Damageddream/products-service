package com.damageddream.products.dto;

import com.damageddream.products.entity.enums.ProductTypes;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ComputerDTO extends ProductDTO {
    private final String cpu;
    private final String gpu;
    private final String ram;
    private final String storage;

    public ComputerDTO(String name, Double price, ProductTypes productType, String cpu,
                       String gpu, String ram, String storage) {
        super(name, price, productType);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
    }

}
