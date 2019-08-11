package com.ducanh.duan.service;

import com.ducanh.duan.dto.SingleImageUploadDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ImageService {
    ResponseEntity<Resource> downloadImage(String imageId, HttpServletRequest request) ;

    SingleImageUploadDTO uploadSingleImage(MultipartFile fileToUpload) throws IOException;
}
