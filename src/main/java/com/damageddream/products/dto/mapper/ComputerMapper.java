package com.damageddream.products.dto.mapper;

import com.damageddream.products.dto.ComputerDTO;
import com.damageddream.products.entity.Computer;
import com.damageddream.products.entity.computerparts.CPU;
import com.damageddream.products.entity.computerparts.GPU;
import com.damageddream.products.entity.computerparts.RAM;
import com.damageddream.products.entity.computerparts.Storage;
import com.damageddream.products.repository.computerparts.CPURepository;
import com.damageddream.products.repository.computerparts.GPURepository;
import com.damageddream.products.repository.computerparts.RAMRepository;
import com.damageddream.products.repository.computerparts.StorageRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ComputerMapper {
    @Autowired
    private CPURepository cpuRepository;
    @Autowired
    private GPURepository gpuRepository;
    @Autowired
    private RAMRepository ramRepository;
    @Autowired
    private StorageRepository storageRepository;

    @Mapping(source = "cpu.id", target = "cpuId")
    @Mapping(source = "gpu.id", target = "gpuId")
    @Mapping(source = "ram.id", target = "ramId")
    @Mapping(source = "storage.id", target = "storageId")
    public abstract ComputerDTO toDTO(Computer computer);

    @Mapping(source = "cpuId", target = "cpu", qualifiedByName = "idToCPU")
    @Mapping(source = "gpuId", target = "gpu", qualifiedByName = "idToGPU")
    @Mapping(source = "ramId", target = "ram", qualifiedByName = "idToRAM")
    @Mapping(source = "storageId", target = "storage", qualifiedByName = "idToStorage")
    public abstract Computer fromDTO(ComputerDTO computerDTO);

    @Mapping(source = "cpuId", target = "cpu", qualifiedByName = "idToCPU")
    @Mapping(source = "gpuId", target = "gpu", qualifiedByName = "idToGPU")
    @Mapping(source = "ramId", target = "ram", qualifiedByName = "idToRAM")
    @Mapping(source = "storageId", target = "storage", qualifiedByName = "idToStorage")
    public abstract void updateComputerFromDTO(ComputerDTO dto, @MappingTarget Computer computer);

    @Named("idToCPU")
    CPU idToCPU(Long id) {
        return id != null ? cpuRepository.findById(id).orElse(null) : null;
    }

    @Named("idToGPU")
    GPU idToGPU(Long id) {
        return id != null ? gpuRepository.findById(id).orElse(null) : null;
    }

    @Named("idToRAM")
    RAM idToRAM(Long id) {
        return id != null ? ramRepository.findById(id).orElse(null) : null;
    }

    @Named("idToStorage")
    Storage idToStorage(Long id) {
        return id != null ? storageRepository.findById(id).orElse(null) : null;
    }
}
