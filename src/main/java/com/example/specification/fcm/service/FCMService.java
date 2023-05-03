package com.example.specification.fcm.service;

import com.example.specification.config.retrofit.RestInterface;
import com.example.specification.config.retrofit.RetrofitAPI;
import com.example.specification.fcm.dto.NoticationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import retrofit2.Call;

@Service("FCMService")
public class FCMService {

    @Value("${fcm.rest.api.key}")
    private String FCM_REST_API_KEY; // 개인키 session key
    @Value("${fcm.rest.api.url}")
    private String FCM_REST_API_URL; // 개인키 session key

    @Autowired
    private RestInterface restService;
    public void sendFCM(NoticationReq noticationReq) throws JSONException {
        RestInterface apiInterface = RetrofitAPI.getApiClient(FCM_REST_API_URL).create(RestInterface.class);

        JSONObject json = new JSONObject();
        JSONObject notification = new JSONObject();
        JSONObject webpush = new JSONObject();
        JSONObject fcmOptions = new JSONObject();

        fcmOptions.put("link","http://localhost:8080/fcm");
        webpush.put("fcmOptions", fcmOptions);
        notification.put("title", noticationReq.getTitle());
        notification.put("body", noticationReq.getBody());

        json.put("notification", notification);
        json.put("to", noticationReq.getToken());
        json.put("priority", "high");
        json.put("webpush", "high");

        String sendMsg = json.toString();

        System.out.println(sendMsg);

//        Call<Object> call = apiInterface.sendFCM(
//                FCM_REST_API_KEY,
//                "application/json",
//                origin,
//                destination
//        );
    }

}
