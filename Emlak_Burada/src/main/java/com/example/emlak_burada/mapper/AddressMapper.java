package com.example.emlak_burada.mapper;


import com.example.emlak_burada.dto.AddressDTO;
import com.example.emlak_burada.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{
}
