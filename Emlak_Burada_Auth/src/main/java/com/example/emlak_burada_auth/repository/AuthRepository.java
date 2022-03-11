package com.example.emlak_burada_auth.repository;

import com.example.emlak_burada_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
