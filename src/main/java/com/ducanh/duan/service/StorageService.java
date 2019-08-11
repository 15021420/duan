package com.ducanh.duan.service;

import javax.servlet.http.HttpServletRequest;

import com.ducanh.duan.dto.FileUploadDTO;
import com.ducanh.duan.dto.MultiFileUploadDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface StorageService {
    FileUploadDTO handleUploadFile(MultipartFile fileUpload) throws IOException;
    MultiFileUploadDTO handleUploadMultiFile(MultipartFile[] fileUploads) throws IOException;
    String storeFile(MultipartFile file) throws IOException;
    Resource loadFileAsResource(String fileLocation) throws MalformedURLException;
    ResponseEntity<Resource> downloadFile(String fileLocation, HttpServletRequest request) throws IOException;
}
