package com.damageddream.products.service;

import com.damageddream.products.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    ProductDTO delete(Long id);
}
