package com.damageddream.products.service;

import com.damageddream.products.dto.ComputerDTO;
import com.damageddream.products.dto.mapper.ComputerMapper;
import com.damageddream.products.entity.Computer;
import com.damageddream.products.exception.ProductNotFoundException;
import com.damageddream.products.repository.ComputerRepository;
import com.damageddream.products.repository.ProductRepository;
import com.damageddream.products.validation.DataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private final ComputerMapper computerMapper;
    private final ComputerRepository computerRepository;
    private final ProductRepository productRepository;
    private final DataValidator dataValidator;

    @Override
    public List<ComputerDTO> findAll() {
        List<Computer> computers = computerRepository.findAll();
        return computers.stream()
                .map(computerMapper::toDTO)
                .toList();
    }

    @Override
    public ComputerDTO findById(Long id) {
        Computer computer = computerRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Computer not found"));
        return computerMapper.toDTO(computer);
    }

    @Override
    @Transactional
    public ComputerDTO save(ComputerDTO computerDTO) {
        var existingComputer = productRepository.findByName(computerDTO.getName());
        if (existingComputer.isPresent()) {
            throw new ProductNotFoundException("Computer with that id already exists");
        }
        Computer computer = computerMapper.fromDTO(computerDTO);
        computerRepository.save(computer);
        return computerMapper.toDTO(computer);
    }

    @Override
    @Transactional
    public ComputerDTO update(Long id, ComputerDTO computerDTO) {
        var computerToEdit = computerRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Computer not found"));
        dataValidator.validateComputerData(computerDTO);
        computerMapper.updateComputerFromDTO(computerDTO, computerToEdit);
        computerRepository.save(computerToEdit);
        return computerMapper.toDTO(computerToEdit);
    }

    @Override
    @Transactional
    public ComputerDTO delete(Long id) {
        var computerToDelete = computerRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Computer not found"));
        computerRepository.delete(computerToDelete);
        return computerMapper.toDTO(computerToDelete);
    }
}
