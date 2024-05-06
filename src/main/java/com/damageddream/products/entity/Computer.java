package com.damageddream.products.entity;

import com.damageddream.products.entity.computerparts.CPU;
import com.damageddream.products.entity.computerparts.GPU;
import com.damageddream.products.entity.computerparts.RAM;
import com.damageddream.products.entity.computerparts.Storage;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@PrimaryKeyJoinColumn(name = "computer_id")
public class Computer extends Product{
    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private CPU cpu;
    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private GPU gpu;
    @ManyToOne
    @JoinColumn(name = "ram_id")
    private RAM ram;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
}
