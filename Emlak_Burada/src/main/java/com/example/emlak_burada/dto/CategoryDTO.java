package com.example.emlak_burada.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends BaseEntityDTO{
    private Long parent_id;
    private String name;
}
