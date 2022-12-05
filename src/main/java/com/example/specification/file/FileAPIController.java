package com.example.specification.file;

import com.example.specification.BaseModel;
import com.example.specification.common.ServerStateEnum;
import com.example.specification.file.dto.FileReq;
import com.example.specification.file.service.FileService;
import com.example.specification.login.dto.LoginReq;
import com.example.specification.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileAPIController {

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST, path = "/fileupload")
    public BaseModel login(HttpServletRequest request, HttpServletResponse response
            //,@RequestParam("body") String id
            , @RequestParam("files") MultipartFile[] multipartFiles
            ) {
        BaseModel baseModel = new BaseModel();
        Boolean result = null;
        result = fileService.uploadFile(multipartFiles);
        if(!result){
            baseModel.setState(ServerStateEnum.FAIL);
        }

        return baseModel;
    }
}
