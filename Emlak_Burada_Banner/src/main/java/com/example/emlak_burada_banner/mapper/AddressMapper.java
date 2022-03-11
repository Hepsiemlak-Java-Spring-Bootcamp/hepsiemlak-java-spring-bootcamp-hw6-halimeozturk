package com.example.emlak_burada_banner.mapper;


import com.example.emlak_burada_banner.dto.AddressDTO;
import com.example.emlak_burada_banner.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{
}
