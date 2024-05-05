package com.damageddream.products.validation;

import com.damageddream.products.dto.SmartphoneDTO;
import com.damageddream.products.exception.ProductAlreadyExistsException;
import com.damageddream.products.exception.RequiredFieldIsNullException;
import com.damageddream.products.repository.ProductRepository;
import com.damageddream.products.repository.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataValidator {
    private final SmartphoneRepository smartphoneRepository;
    private final ProductRepository productRepository;

    public void validateSmartphoneData(SmartphoneDTO smartphoneDTO) {
        validateIfNecessarySmartphoneFieldsAreFilled(smartphoneDTO);
        validateProductName(smartphoneDTO.getName());
    }

    public void validateProductName(String name) {
        if (productRepository.findByName(name).isPresent()) {
            throw new ProductAlreadyExistsException("Smartphone with name " + name + " already exists");
        }
    }

    public void validateIfNecessarySmartphoneFieldsAreFilled(SmartphoneDTO smartphoneDTO) {
        if (smartphoneDTO.getName() == null || smartphoneDTO.getPrice() == null || smartphoneDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Smartphone must be completed");
        }
    }
}
