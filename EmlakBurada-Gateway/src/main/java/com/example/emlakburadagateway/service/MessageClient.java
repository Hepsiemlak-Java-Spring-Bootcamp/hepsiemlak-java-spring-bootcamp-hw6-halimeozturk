package com.example.emlakburadagateway.service;

import com.example.emlakburadagateway.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "messageClient", url = "http://localhost:8081/messages")
public interface MessageClient {

    @GetMapping
    List<MessageDTO> getAllList();

    @PostMapping
    MessageDTO create(@RequestBody MessageDTO messageDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @PutMapping
    MessageDTO update(@RequestBody MessageDTO messageDTO);

    @GetMapping("/{id}")
    MessageDTO getMessageById(@PathVariable Long id);
}
