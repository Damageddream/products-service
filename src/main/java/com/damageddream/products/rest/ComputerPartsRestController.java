package com.damageddream.products.rest;

import com.damageddream.products.entity.computerparts.CPU;
import com.damageddream.products.entity.computerparts.GPU;
import com.damageddream.products.entity.computerparts.RAM;
import com.damageddream.products.entity.computerparts.Storage;
import com.damageddream.products.service.ComputerPartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computers")
public class ComputerPartsRestController {
    private final ComputerPartsService computerPartsService;

    @GetMapping("/cpus")
    public List<CPU> findAllCpus() {
        return computerPartsService.findAllCpus();
    }

    @GetMapping("/gpus")
    public List<GPU> findAllGpus() {
        return computerPartsService.findAllGpus();
    }

    @GetMapping("/rams")
    public List<RAM> findAllRams() {
        return computerPartsService.findAllRams();
    }

    @GetMapping("/storages")
    public List<Storage> findAllStorages() {
        return computerPartsService.findAllStorages();
    }
}
