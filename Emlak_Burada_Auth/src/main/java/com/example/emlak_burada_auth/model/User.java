package com.example.emlak_burada_auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.emlak_burada_auth.enums.UserType;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {
    private UserType userType;
    private String email;
    private String password;
}
