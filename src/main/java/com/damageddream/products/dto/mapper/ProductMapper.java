package com.damageddream.products.dto.mapper;

import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);

    Product fromDTO(ProductDTO productDTO);

    void updateProductFromDTO(ProductDTO dto, @MappingTarget Product product);
}
