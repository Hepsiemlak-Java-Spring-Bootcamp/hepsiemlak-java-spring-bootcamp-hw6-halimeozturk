package com.example.emlak_burada_auth.dto;

import com.example.emlak_burada_auth.model.BaseEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest extends BaseEntity {

	private String email;
	private String password;

}
