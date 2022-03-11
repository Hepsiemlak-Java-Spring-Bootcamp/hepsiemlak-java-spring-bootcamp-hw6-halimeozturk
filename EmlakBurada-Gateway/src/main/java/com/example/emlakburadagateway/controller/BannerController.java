package com.example.emlakburadagateway.controller;

import com.example.emlakburadagateway.dto.BannerDTO;
import com.example.emlakburadagateway.service.BannerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banners")
public class BannerController {

    @Autowired
    private BannerClient bannerClient;

    @GetMapping
    List<BannerDTO> getAllList(){
        return bannerClient.getAllList();
    }

    @PostMapping
    BannerDTO create(@RequestBody BannerDTO bannerDTO){
        return bannerClient.create(bannerDTO);
    }

    @GetMapping("/{id}")
    BannerDTO getById(@PathVariable Long id){
        return bannerClient.getById(id);
    }

    @PutMapping
    BannerDTO update(@RequestBody BannerDTO bannerDTO){
        return bannerClient.update(bannerDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        bannerClient.delete(id);
    }
}
