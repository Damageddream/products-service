package com.damageddream.products.dto.mapper;

import com.damageddream.products.dto.SmartphoneDTO;
import com.damageddream.products.entity.Smartphone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SmartphoneMapper {
    SmartphoneDTO toDTO(Smartphone smartphone);

    Smartphone fromDTO(SmartphoneDTO smartphoneDTO);

    void updateSmartphoneFromDTO(SmartphoneDTO dto, @MappingTarget Smartphone smartphone);
}