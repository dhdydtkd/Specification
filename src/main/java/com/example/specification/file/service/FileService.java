package com.example.specification.file.service;

import com.example.specification.dao.FileDAO;
import com.example.specification.file.dto.FileReq;
import com.example.specification.login.dto.LoginReq;
import com.example.specification.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Service("FileService")
public class FileService {

    @Autowired
    private FileDAO fileDAO;

    public Boolean uploadFile(MultipartFile[] multipartFiles) {
        List<FileReq> fileList = new ArrayList<FileReq>();
        for(int i =0 ;i<multipartFiles.length;i++){
            FileReq file = new FileReq();
            file.setFileName(multipartFiles[i].getOriginalFilename());
            file.setFileSize(multipartFiles[i].getSize());

            String fileUrl = "";
            // url로 변경해야함
            // 파일 저장은 따로
            File tempFile = new File(multipartFiles[i].getOriginalFilename());
            try {
                multipartFiles[i].transferTo(tempFile);
            } catch (IOException e) {
                return false;
            }

            file.setFileUrl(fileUrl);
            fileList.add(file);
        }

        Integer result = fileDAO.uploadFile(fileList);
        if(result>0){
            return true;
        }else{
            return false;
        }

    }
}
