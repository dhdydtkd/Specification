package com.example.specification.file.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileVO {
    private Integer no;
    private String fileName;
    private Integer fileSize;
    private String createDt;
}
