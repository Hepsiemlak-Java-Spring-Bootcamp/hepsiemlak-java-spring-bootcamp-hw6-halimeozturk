package com.example.emlakburadagateway.service;


import com.example.emlakburadagateway.dto.AdvertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "advertClient", url = "http://localhost:8081/adverts")
public interface AdvertClient {

    @GetMapping
    List<AdvertDTO> getAllList();

    @PostMapping
    AdvertDTO create(@RequestBody AdvertDTO advertDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @PutMapping
    AdvertDTO update(@RequestBody AdvertDTO advertDTO);

    @GetMapping( "/{advertNo}")
    AdvertDTO getAdvertByAdvertNo(@PathVariable Long advertNo);
}
