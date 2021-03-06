package com.example.emlak_burada.model;

import com.example.emlak_burada.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {
    private UserType userType;
    private String name;
    private String surname;
    private String email;
    private String path;
    private String phoneNumber;
    private String officePhone;
    private String vkn;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Advert> favorite;
}
