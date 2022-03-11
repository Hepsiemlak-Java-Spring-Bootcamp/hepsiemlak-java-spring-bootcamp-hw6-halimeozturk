package com.example.emlakburadaemail.dto;

import com.example.emlakburadaemail.model.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class EmailDTO extends BaseEntity {
    private String senderName;
    private Long senderId;
    private String senderEmail;
    private String receiverName;
    private String receiverId;
    private String receiverEmail;

}
