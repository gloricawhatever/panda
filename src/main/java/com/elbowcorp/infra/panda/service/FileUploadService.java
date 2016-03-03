package com.elbowcorp.infra.panda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by janghyo on 2016. 3. 3..
 */
@Service
public class FileUploadService {
    public void uploadFile(MultipartFile file, String path) throws IOException {
        byte[] bytes;
        if (file == null) {
            throw new NullPointerException("invalid file");
        } else {
            bytes = file.getBytes();
            if (bytes.length < 1) {
                throw new IOException("file size is zero");
            }
        }

        try {
            file.transferTo(new File(path + "/" + file.getOriginalFilename()));
            //FileUtils.readString(file.getOriginalFilename(), "UTF-8");
            //save file
            //FileUtils.write(bytes, path, file.getOriginalFilename());
        } catch (Exception e) {
            /*
            if (logger.isErrorEnabled()) {
                logger.error("fail to write query file : {}", e.getMessage());
            }
            */
            try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}
