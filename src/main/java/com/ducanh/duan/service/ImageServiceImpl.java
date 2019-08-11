package com.ducanh.duan.service;

import com.ducanh.duan.dto.SingleImageUploadDTO;
import com.ducanh.duan.model.Images;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class ImageServiceImpl implements ImageService {

    private static Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private StorageService storageService;


    @Override
    public ResponseEntity<Resource> downloadImage(String imageId, HttpServletRequest request)  {
        return null;
    }

    @Override
    public SingleImageUploadDTO uploadSingleImage(MultipartFile fileToUpload) throws IOException {
        return null;
    }


}
