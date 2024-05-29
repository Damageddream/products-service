package com.damageddream.products.service;

import com.damageddream.products.dto.mapper.ProductMapper;
import com.damageddream.products.entity.Product;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.exception.ProductNotFoundException;
import com.damageddream.products.repository.ProductRepository;
import com.damageddream.products.util.TestDataFactory;
import com.damageddream.products.validation.DataValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private DataValidator dataValidator;
    private ProductService productService;
    private ProductMapper productMapper;
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        this.dataValidator = Mockito.mock(DataValidator.class);
        this.productMapper = Mappers.getMapper(ProductMapper.class);
        this.productRepository = Mockito.mock(ProductRepository.class);
        this.productService = new ProductServiceImpl(productRepository, productMapper, dataValidator);
    }

    @Test
    void findById_ProductExists_ProductDTOReturned() {
        //given
        Long id = 1L;
        Product product = TestDataFactory.createProduct(ProductTypes.COMPUTER,"Computer", 1L);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        //when
        var result = productService.findById(id);

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
    void findById_ProductDoesNotExist_ProductNotFoundExceptionThrown() {
        //given
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        //then  //when
        ProductNotFoundException ex = assertThrows(ProductNotFoundException.class,
                () -> productService.findById(id));
    }

    @Test
    void delete_ProductExists_ProductDTOReturned() {
        //given
        Long id = 1L;
        Product product = TestDataFactory.createProduct(ProductTypes.COMPUTER,"Computer", 1L);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        //when
        var result = productService.delete(id);

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
    void delete_ProductDoesNotExist_ProductNotFoundExceptionThrown() {
        //given
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        //then  //when
        ProductNotFoundException ex = assertThrows(ProductNotFoundException.class,
                () -> productService.delete(id));
    }

}
