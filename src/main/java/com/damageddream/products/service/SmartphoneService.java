package com.damageddream.products.service;

import com.damageddream.products.dto.SmartphoneDTO;

import java.util.List;

public interface SmartphoneService {
    List<SmartphoneDTO> findAll();
    SmartphoneDTO findById(Long id);
    SmartphoneDTO save(SmartphoneDTO smartphoneDTO);
    SmartphoneDTO update(Long id, SmartphoneDTO smartphoneDTO);
    SmartphoneDTO delete(Long id);
}
