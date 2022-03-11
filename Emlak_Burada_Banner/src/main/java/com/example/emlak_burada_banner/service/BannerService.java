package com.example.emlak_burada_banner.service;


import com.example.emlak_burada_banner.dto.BannerDTO;
import com.example.emlak_burada_banner.exception.GenericServiceException;
import com.example.emlak_burada_banner.mapper.BannerMapper;
import com.example.emlak_burada_banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    public List<BannerDTO> getAllList() {
        return bannerMapper.toDTOList(bannerRepository.findAll());
    }

    @Transactional
    public BannerDTO create(BannerDTO bannerDTO) {
        return bannerMapper.toDTO(bannerRepository.save(bannerMapper.toEntity(bannerDTO)));
    }

    public BannerDTO getById(Long id){
        return bannerMapper.toDTO(bannerRepository.findById(id).
                orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Banner not found")));
    }

    @Transactional
    public BannerDTO update(BannerDTO bannerDTO) {
        getById(bannerDTO.getId());
        return bannerMapper.toDTO(bannerRepository.save(bannerMapper.toEntity(bannerDTO)));
    }

    public void delete(Long id){
        bannerMapper.toDTO(bannerRepository.findById(id).orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Banner not found")));
        bannerRepository.deleteById(id);
    }
}
