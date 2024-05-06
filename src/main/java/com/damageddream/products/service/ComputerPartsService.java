package com.damageddream.products.service;

import com.damageddream.products.entity.computerparts.CPU;
import com.damageddream.products.entity.computerparts.GPU;
import com.damageddream.products.entity.computerparts.RAM;
import com.damageddream.products.entity.computerparts.Storage;

import java.util.List;

public interface ComputerPartsService {
    List<CPU> findAllCpus();
    List<GPU> findAllGpus();
    List<RAM> findAllRams();
    List<Storage> findAllStorages();
}
