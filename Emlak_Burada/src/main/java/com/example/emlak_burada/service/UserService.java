package com.example.emlak_burada.service;


import com.example.emlak_burada.dto.UserDTO;
import com.example.emlak_burada.exception.GenericServiceException;
import com.example.emlak_burada.mapper.UserMapper;
import com.example.emlak_burada.model.User;
import com.example.emlak_burada.repository.UserRepository;
import com.example.emlak_burada.repository.UserRepositoryJDBC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public List<UserDTO> getAllList() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Transactional
    public UserDTO create(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDTO(userRepository.findById(id).
                orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"User not found")));
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        getUserById(userDTO.getId());
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

}
