package com.example.emlakburadagateway.service;

import com.example.emlakburadagateway.dto.BannerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bannerClient", url = "http://localhost:8082/banners")
public interface BannerClient {

    @GetMapping
    List<BannerDTO> getAllList();

    @PostMapping
    BannerDTO create(@RequestBody BannerDTO bannerDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @PutMapping
    BannerDTO update(@RequestBody BannerDTO bannerDTO);

    @GetMapping("/{id}")
    BannerDTO getById(@PathVariable Long id);
}
