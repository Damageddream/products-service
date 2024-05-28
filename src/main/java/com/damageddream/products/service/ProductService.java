package com.damageddream.products.service;

import com.damageddream.products.dto.GetIdCommand;
import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll(Optional<ProductTypes> productType);
    ProductDTO findById(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    ProductDTO delete(Long id);
    ProductDTO addConfig(Long id, GetIdCommand configId);
    ProductDTO removeConfig(Long id);
    ProductDTO addPossibleConfig(Long id, GetIdCommand configId);
    ProductDTO removePossibleConfig(Long id);
}
