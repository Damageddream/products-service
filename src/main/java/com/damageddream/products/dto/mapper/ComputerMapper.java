package com.damageddream.products.dto.mapper;

import com.damageddream.products.dto.ComputerDTO;
import com.damageddream.products.entity.Computer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComputerMapper {
    ComputerDTO toDTO(Computer computer);
    Computer fromDTO(ComputerDTO computerDTO);
}
