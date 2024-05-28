package com.damageddream.products.validation;

import com.damageddream.products.entity.enums.ProductTypes;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class ConfigTypeChecker {
    @Value("${smartphone.configs}")
    private String smartphoneConfigs;

    @Value("${computer.configs}")
    private String computerConfigs;

    private Set<ProductTypes> allowedSmartphoneConfigs;
    private Set<ProductTypes> allowedComputerConfigs;

    @PostConstruct
    public void init() {
        allowedSmartphoneConfigs = initConfigs(smartphoneConfigs);
        allowedComputerConfigs = initConfigs(computerConfigs);
    }

    private Set<ProductTypes> initConfigs(String configs) {
        Set<ProductTypes> allowedConfigs = new HashSet<>();
        Arrays.stream(configs.split(","))
                .map(ProductTypes::valueOf)
                .forEach(allowedConfigs::add);
        return allowedConfigs;
    }

    public boolean isAllowedForSmartphone(ProductTypes productType) {
        return allowedSmartphoneConfigs.contains(productType);
    }

    public boolean isAllowedForComputer(ProductTypes productType) {
        return allowedComputerConfigs.contains(productType);
    }
}
