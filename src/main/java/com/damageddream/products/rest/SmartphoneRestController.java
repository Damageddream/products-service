package com.damageddream.products.rest;

import com.damageddream.products.dto.SmartphoneDTO;
import com.damageddream.products.service.SmartphoneService;
import lombok.RequiredArgsConstructor;
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
    public SmartphoneDTO findById(Long id) {
        return smartphoneService.findById(id);
    }

    @PostMapping
    public SmartphoneDTO save(SmartphoneDTO smartphoneDTO) {
        return smartphoneService.save(smartphoneDTO);
    }

    @PutMapping("/{id}")
    public SmartphoneDTO update(Long id, SmartphoneDTO smartphoneDTO) {
        return smartphoneService.update(id, smartphoneDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        smartphoneService.delete(id);
    }
}
