package com.example.emlak_burada.mapper;



import com.example.emlak_burada.dto.ImageDTO;
import com.example.emlak_burada.model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper<Image, ImageDTO>{
}
