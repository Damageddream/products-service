package com.damageddream.products.dto;

import com.damageddream.products.entity.enums.ProductTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ComputerDTO extends ProductDTO {
    private final Long cpuId;
    private final Long gpuId;
    private final Long ramId;
    private final Long storageId;
}
