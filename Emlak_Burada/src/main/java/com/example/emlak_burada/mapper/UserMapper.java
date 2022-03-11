package com.example.emlak_burada.mapper;


import com.example.emlak_burada.dto.UserDTO;
import com.example.emlak_burada.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {MessageMapper.class})
public interface UserMapper extends BaseMapper<User, UserDTO>{
}
