package com.example.emlak_burada_banner.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressDTO extends BaseEntityDTO {
    private String province;
    private String district;
    private String fullAddress;
}
