package com.damageddream.products.rest;

import com.damageddream.products.dto.GetIdCommand;
import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll(@RequestParam(required = false) Optional<ProductTypes> productType) {
        return productService.findAll(productType);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}/config")
    public ProductDTO addConfig(@PathVariable Long id, @RequestBody GetIdCommand entityId) {
        return productService.addConfig(id, entityId);
    }

    @DeleteMapping("/{id}/config")
    public ProductDTO deleteConfig(@PathVariable Long id) {
        return productService.removeConfig(id);
    }

    @PutMapping("/{id}/possible-config")
    public ProductDTO addPossibleConfig(@PathVariable Long id, @RequestBody GetIdCommand entityId) {
        return productService.addPossibleConfig(id, entityId);
    }

    @DeleteMapping("/{id}/possible-config")
    public ProductDTO deletePossibleConfig(@PathVariable Long id) {
        return productService.removePossibleConfig(id);
    }
}
