package com.damageddream.products.util;

import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;

public class TestDataFactory {
    public static ProductDTO createProductDTO(ProductTypes productType, String name,
                                              Long id) {
        return ProductDTO.builder()
                .id(id)
                .name(name)
                .price(1000.00)
                .productType(productType)
                .visibleToSell(true)
                .configurations(null)
                .possibleConfigurations(null)
                .build();
    }

    public static Product createProduct(ProductTypes productType, String name,
                                        Long id) {
        return Product.builder()
                .id(id)
                .name(name)
                .price(1000.00)
                .productType(productType)
                .visibleToSell(true)
                .configurations(null)
                .possibleConfigurations(null)
                .build();
    }
}
