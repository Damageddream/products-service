package com.damageddream.products.dto;

import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class ProductDTO {
    private final Long id;
    private final String name;
    private final Double price;
    private final ProductTypes productType;
    private final boolean visibleToSell;
    private final Set<Product> configurations;
    private final Set<Product> possibleConfigurations;
}
