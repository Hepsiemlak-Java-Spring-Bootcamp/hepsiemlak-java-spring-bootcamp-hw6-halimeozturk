package com.example.emlak_burada.controller;

import com.example.emlak_burada.dto.AdvertDTO;
import com.example.emlak_burada.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adverts")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @GetMapping
    ResponseEntity<List<AdvertDTO>> getAllList(){
        return ResponseEntity.ok(advertService.getAllList());
    }

    @PostMapping
    ResponseEntity<AdvertDTO> create(@RequestBody AdvertDTO advertDTO){
        return ResponseEntity.ok(advertService.create(advertDTO));
    }

    @PutMapping
    ResponseEntity<AdvertDTO> update(@RequestBody AdvertDTO advertDTO){
        return ResponseEntity.ok(advertService.update(advertDTO));
    }

    @GetMapping("/advertNo/{advertNo}")
    ResponseEntity<AdvertDTO> getAdvertByAdvertNo(@PathVariable Long advertNo){
        return ResponseEntity.ok(advertService.getAdvertByAdvertNo(advertNo));
    }

    @GetMapping("/{id}")
    ResponseEntity<AdvertDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(advertService.getById(id));
    }
}
