package com.damageddream.products.validation;

import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.exception.ProductAlreadyExistsException;
import com.damageddream.products.exception.RequiredFieldIsNullException;
import com.damageddream.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataValidator {
    private final ProductRepository productRepository;

    public void validateProductData(ProductDTO productDTO) {
        validateIfNecessaryProductFieldsAreFilled(productDTO);
        validateProductName(productDTO.getName());
    }

    public void validateProductName(String name) {
        if (productRepository.findByName(name).isPresent()) {
            throw new ProductAlreadyExistsException("Product with name " + name + " already exists");
        }
    }

    public void validateIfNecessaryProductFieldsAreFilled(ProductDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getPrice() == null || productDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Product must be completed");
        }
    }
}
