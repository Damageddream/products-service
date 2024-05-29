package com.damageddream.products.mapper;

import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.dto.mapper.ProductMapper;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.util.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        this.productMapper = Mappers.getMapper(ProductMapper.class);
    }

    @Test
    void fromProduct_ValidProduct_ProductDTOReturned() {
        //given
        Product product = TestDataFactory.createProduct(ProductTypes.COMPUTER,"Computer", 1L);

        //when
        var result = productMapper.toDTO(product);

        //then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Computer", result.getName());
        assertEquals(1000.00, result.getPrice());
        assertEquals(ProductTypes.COMPUTER, result.getProductType());
        assertEquals(true, result.isVisibleToSell());
        assertEquals(null, result.getConfigurations());
        assertEquals(null, result.getPossibleConfigurations());
    }

    @Test
    void toProductDTO_ValidProductDTO_ProductReturned() {
        //given
        ProductDTO productDTO = TestDataFactory.createProductDTO(ProductTypes.COMPUTER,"Computer", 1L);

        //when
        var result = productMapper.fromDTO(productDTO);

        //then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Computer", result.getName());
        assertEquals(1000.00, result.getPrice());
        assertEquals(ProductTypes.COMPUTER, result.getProductType());
        assertEquals(true, result.isVisibleToSell());
        assertEquals(null, result.getConfigurations());
        assertEquals(null, result.getPossibleConfigurations());
    }
}
