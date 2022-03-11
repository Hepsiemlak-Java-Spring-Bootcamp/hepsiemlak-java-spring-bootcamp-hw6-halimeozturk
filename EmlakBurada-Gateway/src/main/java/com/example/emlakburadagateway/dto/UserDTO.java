package com.example.emlakburadagateway.dto;

import com.example.emlakburadagateway.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseEntityDTO {
    private UserType userType;
    private String name;
    private String surname;
    private String email;
    private String path;
    private String phoneNumber;
    private String officePhone;
    private String vkn;

    private Set<AdvertDTO> favorite;
}
