package com.example.emlak_burada_banner.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BannerDTO extends BaseEntityDTO {
    private Long advertNo;
    private String phone;
    private int total;
    private AddressDTO address;
}
