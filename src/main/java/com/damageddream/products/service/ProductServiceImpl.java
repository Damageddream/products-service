package com.damageddream.products.service;

import com.damageddream.products.dto.GetIdCommand;
import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.dto.mapper.ProductMapper;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.exception.ProductNotFoundException;
import com.damageddream.products.repository.ProductRepository;
import com.damageddream.products.validation.DataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DataValidator dataValidator;

    @Override
    public List<ProductDTO> findAll(Optional<ProductTypes> productType) {
        List<Product> products = productType
                .map(productRepository::findByProductType)
                .orElseGet(productRepository::findAll);
        return products.stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        var existingProduct = productRepository.findByName(productDTO.getName());
        if (existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product with that id already exists");
        }
        dataValidator.validateIfNecessaryProductFieldsAreFilled(productDTO);
        Product product = productMapper.fromDTO(productDTO);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        var productToEdit = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        dataValidator.validateProductData(productDTO);
        productMapper.updateProductFromDTO(productDTO, productToEdit);
        productRepository.save(productToEdit);
        return productMapper.toDTO(productToEdit);
    }

    @Override
    @Transactional
    public ProductDTO delete(Long id) {
        var productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepository.delete(productToDelete);
        return productMapper.toDTO(productToDelete);
    }

    @Override
    @Transactional
    public ProductDTO addConfig(Long id, GetIdCommand configId) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Product config = productRepository.findById(configId.getEntityId())
                .orElseThrow(() -> new ProductNotFoundException("Config not found"));
        dataValidator.validateNewConfig(product, config);
        product.getConfigurations().add(config);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO removeConfig(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setConfigurations(null);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO addPossibleConfig(Long id, GetIdCommand configId) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Product config = productRepository.findById(configId.getEntityId())
                .orElseThrow(() -> new ProductNotFoundException("Config not found"));
        dataValidator.validateNewPossibleConfig(product, config);
        product.getPossibleConfigurations().add(config);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO removePossibleConfig(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setPossibleConfigurations(null);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }
}
