package com.example.emlak_burada.mapper;


import com.example.emlak_burada.dto.AdvertDTO;
import com.example.emlak_burada.model.Advert;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {UserMapper.class,AddressMapper.class})
public interface AdvertMapper extends BaseMapper<Advert, AdvertDTO>{
}
