package com.damageddream.products.validation;

import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.exception.ProductAlreadyExistsException;
import com.damageddream.products.exception.RequiredFieldIsNullException;
import com.damageddream.products.exception.WrongProductTypeException;
import com.damageddream.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataValidator {
    private final ProductRepository productRepository;
    private final ConfigTypeChecker configTypeChecker;

    public void validateProductData(ProductDTO productDTO) {
        validateIfNecessaryProductFieldsAreFilled(productDTO);
        validateProductName(productDTO.getName());
    }
    private void validateProductName(String name) {
        if (productRepository.findByName(name).isPresent()) {
            throw new ProductAlreadyExistsException("Product with name " + name + " already exists");
        }
    }
    public void validateIfNecessaryProductFieldsAreFilled(ProductDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getPrice() == null || productDTO.getProductType() == null) {
            throw new RequiredFieldIsNullException("Required fields of Product must be completed");
        }
    }
    public void validateNewPossibleConfig(Product product, Product config){
        if (product.getProductType().equals(ProductTypes.COMPUTER)){
            if(!configTypeChecker.isAllowedForComputer(config.getProductType())){
                throw new WrongProductTypeException("Cannot add this config for COMPUTER");
            }
        }
        if (product.getProductType().equals(ProductTypes.SMARTPHONE)){
            if(!configTypeChecker.isAllowedForSmartphone(config.getProductType())){
                throw new WrongProductTypeException("Cannot add this config for SMARTPHONE");
            }
        }
        if (product.getProductType().equals(ProductTypes.ELECTRONIC)){
            throw new WrongProductTypeException("Cannot add configuration to Electronic");
        }
        if (product.getConfigurations().contains(config)) {
            throw new ProductAlreadyExistsException("This configuration is already in this product");
        }
    }
    public void validateNewConfig(Product product, Product config){
        if(!product.getPossibleConfigurations().contains(config)){
            throw new WrongProductTypeException("This configuration cannot be added to this product");
        }
        if (product.getConfigurations().contains(config)) {
            throw new ProductAlreadyExistsException("This configuration is already in this product");
        }
    }
}
