package com.example.emlakburadaemail.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Email extends BaseEntity {
    private String senderEmail;
    private String receiverEmail;

}
