package com.example.emlak_burada_banner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Banner extends BaseEntity {
    private int advertNo;
    private String phone;
    private int total;
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;
}
