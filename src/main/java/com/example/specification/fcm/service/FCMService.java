package com.example.specification.fcm.service;

import com.example.specification.config.retrofit.RestInterface;
import com.example.specification.fcm.dto.NoticationReq;
import com.google.firebase.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.firebase.messaging.Notification;

@Service("FCMService")
public class FCMService {

    @Autowired
    private RestInterface restService;

    public String sendMessage(int requestId, NoticationReq noticationReq) throws FirebaseMessagingException {
        Notification notification = Notification.builder()
                .setTitle(noticationReq.getTitle())
                .setBody(noticationReq.getBody())
                .build();
        Message message = Message.builder()
                .putData("requestId", Integer.toString(requestId))
                .setNotification(notification)
                .setToken(noticationReq.getToken())
                .build();
        String response = FirebaseMessaging.getInstance().send(message);

        return response;
    }

}
