package com.damageddream.products.rest;

import com.damageddream.products.dto.SmartphoneDTO;
import com.damageddream.products.service.SmartphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartphones")
public class SmartphoneRestController {
    private final SmartphoneService smartphoneService;

    @GetMapping
    public List<SmartphoneDTO> findAll() {
        return smartphoneService.findAll();
    }

    @GetMapping("/{id}")
    public SmartphoneDTO findById(@PathVariable Long id) {
        return smartphoneService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SmartphoneDTO save(@RequestBody  SmartphoneDTO smartphoneDTO) {
        return smartphoneService.save(smartphoneDTO);
    }

    @PutMapping("/{id}")
    public SmartphoneDTO update(@PathVariable Long id,@RequestBody SmartphoneDTO smartphoneDTO) {
        return smartphoneService.update(id, smartphoneDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        smartphoneService.delete(id);
    }
}
