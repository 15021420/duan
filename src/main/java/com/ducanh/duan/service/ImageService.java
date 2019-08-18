package com.ducanh.duan.service;

import com.ducanh.duan.dto.MultiImageUploadDTO;
import com.ducanh.duan.dto.SingleImageUploadDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface ImageService {
    List<Integer> multiImageUpload(MultipartFile[] fileToUpload) throws IOException;

    Integer singleImageUpload(MultipartFile fileToUpload) throws IOException;

    ResponseEntity<Resource> exportDownload(int id, HttpServletRequest request) throws IOException;
}
