package com.example.emlak_burada.service;

import com.example.emlak_burada.activeMq.service.ActiveMqService;
import com.example.emlak_burada.client.BannerClient;
import com.example.emlak_burada.client.dto.BannerDTO;
import com.example.emlak_burada.dto.AdvertDTO;
import com.example.emlak_burada.dto.UserDTO;
import com.example.emlak_burada.mapper.AdvertMapper;
import com.example.emlak_burada.mapper.BannerMapper;
import com.example.emlak_burada.model.Advert;
import com.example.emlak_burada.model.User;
import com.example.emlak_burada.repository.AdvertRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AdvertServiceTest {

    @InjectMocks
    private AdvertService advertService;
    @Mock
    private AdvertMapper advertMapper;
    @Mock
    private BannerClient bannerClient;
    @Mock
    private BannerMapper bannerMapper;
    @Mock
    private ActiveMqService activeMqService;
    @Mock
    private AdvertRepository advertRepository;

    @BeforeEach
    void setup(){
        Mockito
                .when(advertRepository.findAll())
                .thenReturn(prepareMockAdvertList());
        Mockito
                .when(advertMapper.toDTOList(any()))
                .thenReturn(prepareMockAdvertDTOList());
        Mockito
                .when(advertMapper.toDTO(any()))
                .thenReturn(prepareMockAdvertDTO());
        Mockito
                .when(advertMapper.toEntity(any())).
                thenReturn(prepareMockAdvert());

    }

    private List<Advert> prepareMockAdvertList(){
        List<Advert> adverts = new ArrayList<>();
        adverts.add(prepareMockAdvert());
        return adverts;
    }

    private Advert prepareMockAdvert(){
        Advert advert = new Advert();
        User user = new User();
        advert.setId(1L);
        advert.setAdvertNo(1984L);
        advert.setActive(true);
        advert.setAge(0);
        advert.setBathRoom(2);
        advert.setOwner(user);
        return advert;
    }

    private List<AdvertDTO> prepareMockAdvertDTOList(){
        List<AdvertDTO> advertDTOS = new ArrayList<>();
        advertDTOS.add(prepareMockAdvertDTO());
        return advertDTOS;
    }

    private AdvertDTO prepareMockAdvertDTO(){
        AdvertDTO advertDTO = new AdvertDTO();
        UserDTO userDTO = new UserDTO();
        advertDTO.setId(1L);
        advertDTO.setAdvertNo(1984L);
        advertDTO.setActive(true);
        advertDTO.setAge(0);
        advertDTO.setBathRoom(2);
        advertDTO.setOwner(userDTO);
        return advertDTO;
    }

    private BannerDTO prepareMockBannerDTO(){
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setAdvertNo(1984L);
        bannerDTO.setTotal(3);
        return bannerDTO;
    }

    @Test
    void create(){
        AdvertDTO advertDTO = prepareMockAdvertDTO();
        Mockito
                .when(bannerClient.save(prepareMockBannerDTO()))
                .thenReturn(new ResponseEntity<BannerDTO>(new BannerDTO(), HttpStatus.OK));
        Mockito
                .when(advertRepository.save(any()))
                .thenReturn(prepareMockAdvert());
        Mockito
                .when(bannerMapper.toDTO(any())).
                thenReturn(prepareMockBannerDTO());

        AdvertDTO advert = advertService.create(advertDTO);
        assertEquals(1984L,advert.getAdvertNo());
        verify(activeMqService).sendMessage(any());
        verify(bannerClient).save(any());
    }

    @Test
    void createBanner(){
        Mockito
                .when(bannerMapper.toDTO(any()))
                .thenReturn(prepareMockBannerDTO());
        Mockito
                .when(bannerClient.save(prepareMockBannerDTO()))
                .thenReturn(new ResponseEntity<BannerDTO>(new BannerDTO(), HttpStatus.OK));

        ResponseEntity<BannerDTO> bannerDTOResponseEntity = bannerClient.save(prepareMockBannerDTO());
        assertEquals(200,bannerDTOResponseEntity.getStatusCode().value());
    }

    @Test
    void getAllAdvertTest() {
        List<AdvertDTO> allAdvert = advertService.getAllList();
        assertNotNull(allAdvert);
        assertThat(allAdvert.size()).isNotZero();
    }

    @Test
    void getAdvertById(){
        Mockito.when(advertRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockAdvert()));
        AdvertDTO advertDTO = advertService.getById(any());
        assertEquals(advertDTO.getId(),1L);
    }

    @Test
    void getAdvertByAdvertNo(){
        Mockito.when(advertRepository.findByAdvertNo(any())).thenReturn(java.util.Optional.of(prepareMockAdvert()));
        AdvertDTO advertDTO = advertService.getAdvertByAdvertNo(any());
        assertEquals(advertDTO.getAdvertNo(),1984L);
    }

    @Test
    void update(){
        Mockito.when(advertRepository.save(any())).thenReturn(prepareMockAdvert());
        Mockito.when(advertRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockAdvert()));
        AdvertDTO advert = advertService.update(prepareMockAdvertDTO());
        assertEquals(advert.getId(), 1L);
    }
}
