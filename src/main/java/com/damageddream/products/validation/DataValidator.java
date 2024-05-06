package com.damageddream.products.validation;

import com.damageddream.products.dto.ComputerDTO;
import com.damageddream.products.dto.ProductDTO;
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

    public void validateComputerData(ComputerDTO computerDTO) {
        validateIfNecessaryComputerFieldsAreFilled(computerDTO);
        validateProductName(computerDTO.getName());
    }

    public void validateProductData(ProductDTO productDTO) {
        validateIfNecessaryProductFieldsAreFilled(productDTO);
        validateProductName(productDTO.getName());
    }

    public void validateProductName(String name) {
        if (productRepository.findByName(name).isPresent()) {
            throw new ProductAlreadyExistsException("Product with name " + name + " already exists");
        }
    }

    public void validateIfNecessarySmartphoneFieldsAreFilled(SmartphoneDTO smartphoneDTO) {
        if (smartphoneDTO.getName() == null || smartphoneDTO.getPrice() == null || smartphoneDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Smartphone must be completed");
        }
    }

    public void validateIfNecessaryComputerFieldsAreFilled(ComputerDTO computerDTO) {
        if (computerDTO.getName() == null || computerDTO.getPrice() == null || computerDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Computer must be completed");
        }
    }

    public void validateIfNecessaryProductFieldsAreFilled(ProductDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getPrice() == null || productDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Product must be completed");
        }
    }
}
