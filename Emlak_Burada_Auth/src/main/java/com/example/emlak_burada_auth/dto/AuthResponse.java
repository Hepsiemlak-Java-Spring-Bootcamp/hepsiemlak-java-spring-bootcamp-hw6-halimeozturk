package com.example.emlak_burada_auth.dto;

import com.example.emlak_burada_auth.model.BaseEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse extends BaseEntity {

	private String token;

}
