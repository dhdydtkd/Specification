package com.example.specification.fcm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticationReq {
    private String title;
    private String body;
    private String token;
}
