package com.example.emlakburadagateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO extends BaseEntityDTO {
    private Long advertNo;
    private String phone;
    private int total;
    private AddressDTO address;
}
