package com.example.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class UploadThread extends Thread {
    @Autowired
    FileService fileService;
    
    public void run(MultipartFile multipartFile) {
        fileService.save(multipartFile);
    }
}
