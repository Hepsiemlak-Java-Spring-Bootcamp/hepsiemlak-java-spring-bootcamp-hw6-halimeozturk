package com.example.emlak_burada.mapper;


import com.example.emlak_burada.dto.MessageDTO;
import com.example.emlak_burada.model.Message;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface MessageMapper extends BaseMapper<Message, MessageDTO>{
}
