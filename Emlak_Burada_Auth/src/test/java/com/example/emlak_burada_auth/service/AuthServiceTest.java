package com.example.emlak_burada_auth.service;


import com.example.emlak_burada_auth.dto.AuthRequest;
import com.example.emlak_burada_auth.dto.AuthResponse;
import com.example.emlak_burada_auth.model.User;
import com.example.emlak_burada_auth.repository.AuthRepository;
import com.example.emlak_burada_auth.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Mock
    private JwtUtil jwtUtil;

    private User prepareMockUser(){
        User user = new User();
        user.setId(1L);
        user.setEmail("ozturkk.halimee@gmail.com");
        user.setPassword("12345");
        user.setCreationDate(ZonedDateTime.now());
        user.setModificationDate(ZonedDateTime.now());
        return user;
    }

    private AuthRequest prepareMockAuthRequest(){
        AuthRequest user = new AuthRequest();
        user.setId(1L);
        user.setEmail("ozturkk.halimee@gmail.com");
        user.setPassword("12345");
        user.setCreationDate(ZonedDateTime.now());
        user.setModificationDate(ZonedDateTime.now());
        return user;
    }

    private AuthResponse prepareMockAuthResponse(){
        AuthResponse user = new AuthResponse();
        user.setToken("CREATEDTOKEN");
        return user;
    }


    @Test
    void getToken() throws Exception {
        Mockito.when(authRepository.findByEmail(any())).thenReturn(prepareMockUser());
        Mockito.when(jwtUtil.generateToken(any())).thenReturn("CREATEDTOKEN");
        AuthResponse authResponse = authService.getToken(prepareMockAuthRequest());
        assertEquals("CREATEDTOKEN",authResponse.getToken());
    }

}
