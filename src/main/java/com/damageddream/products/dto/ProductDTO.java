package com.damageddream.products.dto;

import com.damageddream.products.entity.enums.ProductTypes;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class ProductDTO {
    @Column(unique = true)
    private final String name;
    private final Double price;
    private final ProductTypes productType;
}
