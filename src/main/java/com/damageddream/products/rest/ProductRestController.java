package com.damageddream.products.rest;

import com.damageddream.products.dto.GetIdCommand;
import com.damageddream.products.dto.ProductDTO;
import com.damageddream.products.entity.enums.ProductTypes;
import com.damageddream.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found products",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))})})

    @GetMapping
    public List<ProductDTO> findAll(@RequestParam(required = false) Optional<ProductTypes> productType) {
        return productService.findAll(productType);
    }

    @Operation(summary = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found product",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)})
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Operation(summary = "Save product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Product with that id already exists"),
            @ApiResponse(responseCode = "400", description = "Necessary product field is null", content = @Content)})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @Operation(summary = "Update product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Necessary product field is null", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product with that id already exists", content = @Content)
    })
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.update(id, productDTO);
    }

    @Operation(summary = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @Operation(summary = "Add config to product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Config added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Config not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Config already exists", content = @Content)
    })
    @PutMapping("/{id}/config")
    public ProductDTO addConfig(@PathVariable Long id, @RequestBody GetIdCommand entityId) {
        return productService.addConfig(id, entityId);
    }

    @Operation(summary = "Delete config from product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Config deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @DeleteMapping("/{id}/config")
    public ProductDTO deleteConfig(@PathVariable Long id) {
        return productService.removeConfig(id);
    }

    @Operation(summary = "Add possible config to product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Possible config added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Config not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Config already exists", content = @Content)
    })

    @PutMapping("/{id}/possible-config")
    public ProductDTO addPossibleConfig(@PathVariable Long id, @RequestBody GetIdCommand entityId) {
        return productService.addPossibleConfig(id, entityId);
    }

    @Operation(summary = "Delete possible config from product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Possible config deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    @DeleteMapping("/{id}/possible-config")
    public ProductDTO deletePossibleConfig(@PathVariable Long id) {
        return productService.removePossibleConfig(id);
    }
}
