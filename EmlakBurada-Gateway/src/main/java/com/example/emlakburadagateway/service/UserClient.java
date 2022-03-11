package com.example.emlakburadagateway.service;

import com.example.emlakburadagateway.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "userClient", url = "http://localhost:8081/users")
public interface UserClient {

    @GetMapping
    List<UserDTO> getAllList();

    @PostMapping
    UserDTO create(@RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @PutMapping
    UserDTO update(@RequestBody UserDTO userDTO);

    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
