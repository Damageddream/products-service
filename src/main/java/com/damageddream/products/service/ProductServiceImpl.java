package com.damageddream.products.service;

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

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DataValidator dataValidator;

    @Override
    public List<ProductDTO> findAll(String productType) {
        List<Product> products = productRepository.findAll();
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
}
