package com.example.emlak_burada.service;



import com.example.emlak_burada.activeMq.service.ActiveMqService;
import com.example.emlak_burada.client.BannerClient;
import com.example.emlak_burada.client.dto.BannerDTO;
import com.example.emlak_burada.dto.AdvertDTO;
import com.example.emlak_burada.exception.GenericServiceException;
import com.example.emlak_burada.mapper.AdvertMapper;
import com.example.emlak_burada.mapper.BannerMapper;
import com.example.emlak_burada.model.Advert;
import com.example.emlak_burada.repository.AdvertRepository;
import com.example.emlak_burada.repository.AdvertRepositoryJDBC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertService {
    private final AdvertMapper advertMapper;
    private final BannerClient bannerClient;
    private final BannerMapper bannerMapper;
    private final ActiveMqService activeMqService;
    private final AdvertRepository advertRepository;

    public List<AdvertDTO> getAllList() {
        return advertMapper.toDTOList(advertRepository.findAll());
    }

    @Transactional
    public AdvertDTO create(AdvertDTO advertDTO) {
        advertDTO.setAdvertNo((long) (1 + new Random().nextInt(900000000)));
        Advert advert = advertRepository.save(advertMapper.toEntity(advertDTO));
        createBanner(advertDTO);
        activeMqService.sendMessage(advertDTO.getOwner().getEmail());
        return advertMapper.toDTO(advert);
    }

    public void createBanner(AdvertDTO advertDTO){
        BannerDTO bannerDTO = bannerMapper.toDTO(advertMapper.toEntity(advertDTO));
        bannerDTO.setTotal(1);
        bannerDTO.setPhone(advertDTO.getOwner().getPhoneNumber());
        bannerDTO.setAdvertNo(advertDTO.getAdvertNo());
        bannerDTO.setAddress(advertDTO.getAddress());
        bannerClient.save(bannerDTO);
    }

    @Transactional
    public AdvertDTO update(AdvertDTO advertDTO) {
        getById(advertDTO.getId());
        return advertMapper.toDTO(advertRepository.save(advertMapper.toEntity(advertDTO)));
    }

    public AdvertDTO getAdvertByAdvertNo(Long advertNo){
        return advertMapper.toDTO(advertRepository.findByAdvertNo(advertNo).orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Advert not found")));
    }

    public AdvertDTO getById(Long id){
        return advertMapper.toDTO(advertRepository.findById(id).orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Advert not found")));
    }


}
