package com.example.specification.fcm;

import com.example.specification.BaseModel;
import com.example.specification.common.ServerStateEnum;
import com.example.specification.fcm.dto.NoticationReq;
import com.example.specification.fcm.service.FCMService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/fcm")
public class FCMAPIController {

    @Autowired
    private FCMService fcmService;

    @Autowired
    private FCMInitializer fcmInitializer;

    @RequestMapping(method = RequestMethod.POST, path = "/send")
    public BaseModel login(HttpServletRequest request, HttpServletResponse response
            , @RequestBody NoticationReq noticationReq){
        BaseModel baseModel = new BaseModel();

        try {
            fcmService.sendMessage((int)(Math.random() * 100000),noticationReq);
            baseModel.setBody(null);
        } catch (FirebaseMessagingException e) {
            baseModel.setState(ServerStateEnum.FAIL);
            baseModel.setBody(e.getMessage());
        }
        return baseModel;
    }
}
