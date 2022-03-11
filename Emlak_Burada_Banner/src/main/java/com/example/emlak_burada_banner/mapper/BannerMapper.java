package com.example.emlak_burada_banner.mapper;


import com.example.emlak_burada_banner.dto.BannerDTO;
import com.example.emlak_burada_banner.model.Address;
import com.example.emlak_burada_banner.model.Banner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {AddressMapper.class})
public interface BannerMapper extends BaseMapper<Banner, BannerDTO>{
}
