package com.damageddream.products.service;

import com.damageddream.products.dto.SmartphoneDTO;
import com.damageddream.products.dto.mapper.SmartphoneMapper;
import com.damageddream.products.entity.Smartphone;
import com.damageddream.products.exception.ProductAlreadyExistsException;
import com.damageddream.products.exception.ProductNotFoundException;
import com.damageddream.products.repository.ProductRepository;
import com.damageddream.products.repository.SmartphoneRepository;
import com.damageddream.products.validation.DataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {
    private final SmartphoneMapper smartphoneMapper;
    private final SmartphoneRepository smartphoneRepository;
    private final ProductRepository productRepository;
    private final DataValidator dataValidator;


    @Override
    public List<SmartphoneDTO> findAll() {
        List<Smartphone>smartphones = smartphoneRepository.findAll();
        return smartphones.stream()
                .map(smartphoneMapper::toDTO)
                .toList();
    }

    @Override
    public SmartphoneDTO findById(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Smartphone not found"));
        return smartphoneMapper.toDTO(smartphone);
    }

    @Override
    @Transactional
    public SmartphoneDTO save(SmartphoneDTO smartphoneDTO) {
        var existingSmartphone = productRepository.findByName(smartphoneDTO.getName());
        if (existingSmartphone.isPresent()) {
            throw new ProductAlreadyExistsException("Smartphone with that id already exists");
        }
        Smartphone smartphone = smartphoneMapper.fromDTO(smartphoneDTO);
        smartphoneRepository.save(smartphone);
        return smartphoneMapper.toDTO(smartphone);
    }

    @Override
    @Transactional
    public SmartphoneDTO update(Long id, SmartphoneDTO smartphoneDTO) {
        var smartphoneToEdit = smartphoneRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Smartphone not found"));
        dataValidator.validateSmartphoneData(smartphoneDTO);
        smartphoneMapper.updateSmartphoneFromDTO(smartphoneDTO, smartphoneToEdit);
        smartphoneRepository.save(smartphoneToEdit);
        return smartphoneMapper.toDTO(smartphoneToEdit);
    }

    @Override
    @Transactional
    public SmartphoneDTO delete(Long id) {
        var smartphoneToDelete = smartphoneRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Smartphone not found"));
        smartphoneRepository.delete(smartphoneToDelete);
        return smartphoneMapper.toDTO(smartphoneToDelete);
    }
}
