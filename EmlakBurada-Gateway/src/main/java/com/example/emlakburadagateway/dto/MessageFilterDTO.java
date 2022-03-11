package com.example.emlakburadagateway.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageFilterDTO extends BaseEntityDTO {
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
}
