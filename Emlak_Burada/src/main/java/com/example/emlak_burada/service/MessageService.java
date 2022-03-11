package com.example.emlak_burada.service;



import com.example.emlak_burada.dto.MessageDTO;
import com.example.emlak_burada.exception.GenericServiceException;
import com.example.emlak_burada.mapper.MessageMapper;
import com.example.emlak_burada.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    public List<MessageDTO> getAllList() {
        return messageMapper.toDTOList(messageRepository.findAll());
    }

    @Transactional
    public MessageDTO create(MessageDTO messageDTO) {
        return messageMapper.toDTO(messageRepository.save(messageMapper.toEntity(messageDTO)));
    }

    public MessageDTO getMessageById(Long id){
        return messageMapper.toDTO(messageRepository.findById(id).
                orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Message not found")));
    }

    @Transactional
    public MessageDTO update(MessageDTO messageDTO) {
        getMessageById(messageDTO.getId());
        return messageMapper.toDTO(messageRepository.save(messageMapper.toEntity(messageDTO)));
    }

}
