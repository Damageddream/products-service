package com.damageddream.products.service;

import com.damageddream.products.dto.ComputerDTO;

import java.util.List;

public interface ComputerService {
    List<ComputerDTO> findAll();
    ComputerDTO findById(Long id);
    ComputerDTO save(ComputerDTO computerDTO);
    ComputerDTO update(Long id, ComputerDTO computerDTO);
    ComputerDTO delete(Long id);
}
