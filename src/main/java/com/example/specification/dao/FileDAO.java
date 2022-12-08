package com.example.specification.dao;

import com.example.specification.file.dto.FileReq;
import com.example.specification.file.vo.FileVO;
import com.example.specification.login.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDAO {
    public Integer uploadFile(List<FileReq> fileList);

    public List<FileVO> getFileList();

    public Integer fileDelete(Integer fileNo);
    public FileReq fileFind(Integer fileNo);


}
