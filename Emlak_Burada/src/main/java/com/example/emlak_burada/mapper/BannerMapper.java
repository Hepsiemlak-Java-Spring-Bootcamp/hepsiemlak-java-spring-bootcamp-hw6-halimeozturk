package com.example.emlak_burada.mapper;


import com.example.emlak_burada.client.dto.BannerDTO;
import com.example.emlak_burada.model.Advert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BannerMapper{
    @Named("toDTO")
    @Mapping(target="advertNo", source="advertNo")
    @Mapping(target="address", source="address")
    @Mapping(target="phone", source="owner.phoneNumber")
    BannerDTO toDTO(Advert entity);
}
