package com.damageddream.products.dto;

import com.damageddream.products.entity.enums.Accessories;
import com.damageddream.products.entity.enums.ProductTypes;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SmartphoneDTO extends ProductDTO {
    private final String color;
    private final String battery;
    private final List<Accessories> accessories;

    public SmartphoneDTO(String name, Double price, ProductTypes productType,
                         String color, String battery, List<Accessories> accessories) {
        super(name, price, productType);
        this.color = color;
        this.battery = battery;
        this.accessories = accessories;
    }
}
