package com.example.emlak_burada_auth.service;


import com.example.emlak_burada_auth.dto.AuthRequest;
import com.example.emlak_burada_auth.dto.AuthResponse;
import com.example.emlak_burada_auth.model.User;
import com.example.emlak_burada_auth.repository.AuthRepository;
import com.example.emlak_burada_auth.util.JwtUtil;
import com.example.emlak_burada_auth.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

	private final AuthRepository authRepository;

	private final JwtUtil jwtUtil;

	public AuthResponse getToken(AuthRequest request) throws Exception {
		User user = authRepository.findByEmail(request.getEmail());

		if (user == null) {
			log.error("User not found with email " + request.getEmail());
			throw new Exception("User not found");
		}

		if (!UserUtil.isValidPassword(user.getPassword(), request.getPassword())) {
			log.error("User's password not valid " + request.getEmail());
			throw new Exception("User's password not valid");
		}

		return new AuthResponse(jwtUtil.generateToken(user));
	}

}
