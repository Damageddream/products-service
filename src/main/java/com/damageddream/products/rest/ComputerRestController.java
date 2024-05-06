package com.damageddream.products.rest;

import com.damageddream.products.dto.ComputerDTO;
import com.damageddream.products.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computers")
public class ComputerRestController {
    private final ComputerService computerService;

    @GetMapping
    public List<ComputerDTO> findAll() {
        return computerService.findAll();
    }

    @GetMapping("/{id}")
    public ComputerDTO findById(@PathVariable Long id) {
        return computerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerDTO save(@RequestBody ComputerDTO computerDTO) {
        return computerService.save(computerDTO);
    }

    @PutMapping("/{id}")
    public ComputerDTO update(@PathVariable Long id, @RequestBody ComputerDTO computerDTO) {
        return computerService.update(id, computerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        computerService.delete(id);
    }
}
