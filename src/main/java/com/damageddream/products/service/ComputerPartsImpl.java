package com.damageddream.products.service;

import com.damageddream.products.entity.computerparts.CPU;
import com.damageddream.products.entity.computerparts.GPU;
import com.damageddream.products.entity.computerparts.RAM;
import com.damageddream.products.entity.computerparts.Storage;
import com.damageddream.products.repository.computerparts.CPURepository;
import com.damageddream.products.repository.computerparts.GPURepository;
import com.damageddream.products.repository.computerparts.RAMRepository;
import com.damageddream.products.repository.computerparts.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerPartsImpl implements ComputerPartsService {
    private final CPURepository cpuRepository;
    private final GPURepository gpuRepository;
    private final RAMRepository ramRepository;
    private final StorageRepository storageRepository;

    @Override
    public List<CPU> findAllCpus() {
        return cpuRepository.findAll();
    }

    @Override
    public List<GPU> findAllGpus() {
        return gpuRepository.findAll();
    }

    @Override
    public List<RAM> findAllRams() {
        return ramRepository.findAll();
    }

    @Override
    public List<Storage> findAllStorages() {
        return storageRepository.findAll();
    }
}
