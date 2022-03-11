package com.example.emlak_burada.mapper;


import com.example.emlak_burada.dto.CategoryDTO;
import com.example.emlak_burada.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO>{
}
