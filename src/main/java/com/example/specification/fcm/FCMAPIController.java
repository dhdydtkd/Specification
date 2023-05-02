package com.example.specification.fcm;

import com.example.specification.BaseModel;
import com.example.specification.common.ServerStateEnum;
import com.example.specification.fcm.service.FCMService;
import com.example.specification.file.service.FileService;
import com.example.specification.login.dto.LoginReq;
import com.example.specification.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fcm")
public class FCMAPIController {

    @Autowired
    private FCMService fcmService;


    @RequestMapping(method = RequestMethod.POST, path = "/send")
    public BaseModel login(HttpServletRequest request, HttpServletResponse response
            , @RequestBody LoginReq loginReq) {
        BaseModel baseModel = new BaseModel();

        String userId = "";
        String userPw = "";

        //session.removeAttribute(RSA_WEB_KEY);
        Map<String, Object> result = new HashMap<String,Object>();
        //result.put("userData",userVO);
        baseModel.setBody(null);
        return baseModel;
    }
}
