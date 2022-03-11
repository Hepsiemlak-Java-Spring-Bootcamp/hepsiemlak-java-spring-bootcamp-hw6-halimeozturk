package com.example.emlak_burada.client;

import com.example.emlak_burada.client.dto.BannerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bannerClient", url = "http://localhost:8082/banners")
public interface BannerClient {

    @PostMapping
    ResponseEntity<BannerDTO> save(@RequestBody BannerDTO dto);
}
