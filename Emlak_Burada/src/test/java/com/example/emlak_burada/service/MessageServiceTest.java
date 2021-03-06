package com.example.emlak_burada.service;

import com.example.emlak_burada.dto.MessageDTO;
import com.example.emlak_burada.dto.UserDTO;
import com.example.emlak_burada.mapper.MessageMapper;
import com.example.emlak_burada.model.Message;
import com.example.emlak_burada.model.User;
import com.example.emlak_burada.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class MessageServiceTest {
    @InjectMocks
    private MessageService messageService;
    @Mock
    private MessageMapper messageMapper;
    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    void setup(){
        Mockito
                .when(messageMapper.toDTO(any()))
                .thenReturn(prepareMessageDTO());
        Mockito
                .when(messageMapper.toEntity(any()))
                .thenReturn(prepareMessage());
        Mockito
                .when(messageMapper.toDTOList(any()))
                .thenReturn(prepareMessageDTOList());
        Mockito
                .when(messageMapper.toEntityList(any()))
                .thenReturn(prepareMessageList());

    }

    private List<Message> prepareMessageList(){
        List<Message> messageList = new ArrayList<>();
        messageList.add(prepareMessage());
        return messageList;
    }

    private Message prepareMessage(){
        Message message = new Message();
        User sender = new User();
        User receiver = new User();
        sender.setEmail("halime@mailinator.com");
        receiver.setEmail("test@mailinator.com");
        message.setId(1L);
        message.setContent("test");
        message.setSender(sender);
        message.setReceiver(receiver);
        return message;
    }

    private List<MessageDTO> prepareMessageDTOList(){
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messageDTOS.add(prepareMessageDTO());
        return messageDTOS;
    }

    private MessageDTO prepareMessageDTO(){
        MessageDTO message = new MessageDTO();
        UserDTO sender = new UserDTO();
        UserDTO receiver = new UserDTO();
        sender.setEmail("halime@mailinator.com");
        receiver.setEmail("test@mailinator.com");
        message.setId(1L);
        message.setContent("test");
        message.setSender(sender);
        message.setReceiver(receiver);
        return message;
    }

    @Test
    void getAllMessageTest() {
        List<MessageDTO> allMessage = messageService.getAllList();
        assertNotNull(allMessage);
        assertThat(allMessage.size()).isNotZero();
    }

    @Test
    void create(){
        Mockito.when(messageRepository.save(any())).thenReturn(prepareMessage());
        MessageDTO messageDTO = messageService.create(prepareMessageDTO());
        assertEquals(messageDTO.getId(), 1L);
    }

    @Test
    void getUserById(){
        Mockito.when(messageRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMessage()));
        MessageDTO messageDTO = messageService.getMessageById(any());
        assertEquals(messageDTO.getId(),1L);
    }

    @Test
    void update(){
        Mockito.when(messageRepository.save(any())).thenReturn(prepareMessage());
        Mockito.when(messageRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMessage()));
        MessageDTO messageDTO = messageService.update(prepareMessageDTO());
        assertEquals(messageDTO.getId(), 1L);
    }


}
