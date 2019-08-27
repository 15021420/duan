package com.ducanh.duan.service;

import com.ducanh.duan.dto.FileUploadDTO;
import com.ducanh.duan.dto.MultiFileUploadDTO;
import com.ducanh.duan.utils.DateUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.http.MediaType;

@Service
public class StorageServiceImpl implements StorageService {

    private Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Value("${fileUploadDir}")
    private String fileUploadDir;

    @Override
    public FileUploadDTO handleUploadFile(MultipartFile fileUpload) throws IOException {
        String urlLocation = storeFile(fileUpload);
        return FileUploadDTO.builder().urlLocation(urlLocation).build();
    }

    @Override
    public MultiFileUploadDTO handleUploadMultiFile(MultipartFile[] fileUploads) throws IOException {
        List<String> arrUrls = new ArrayList<>();
        for (MultipartFile fileUpload : fileUploads) {
            arrUrls.add(storeFile(fileUpload));
        }

        return MultiFileUploadDTO.builder().listUrlDownload(arrUrls).build();
    }

    @Override
    public String storeFile(MultipartFile file) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        StringBuilder fileStorageUrl = new StringBuilder("");

        fileStorageUrl.append(File.separator);
        fileStorageUrl.append(fileUploadDir);
        fileStorageUrl.append( File.separator);
        fileStorageUrl.append(DateUtils.getStringDateOS());
        fileStorageUrl.append(File.separator);
        fileStorageUrl.append(username);
        fileStorageUrl.append(File.separator);
        fileStorageUrl.append(Calendar.getInstance().getTimeInMillis());

        Path fileStorageLocation = Paths.get(fileStorageUrl.toString()).toAbsolutePath().normalize();

        Files.createDirectories(fileStorageLocation);

        String fileName = FilenameUtils.getName(file.getOriginalFilename());

        Path targetLocation = fileStorageLocation.resolve(fileName);

        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileStorageLocation.toAbsolutePath().toString() + File.separator + fileName;
    }

    @Override
    public Resource loadFileAsResource(String fileLocation) throws MalformedURLException {

            Path filePath = Paths.get(fileLocation).toAbsolutePath().normalize();
            return new UrlResource(filePath.toUri());
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String fileLocation, HttpServletRequest request) throws IOException {
        Resource resourceFile = loadFileAsResource(fileLocation);
        String contentType = null;

        contentType = request.getServletContext().getMimeType(resourceFile.getFile().getAbsolutePath());

        if (null == contentType) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceFile.getFilename() + "\"")
                .body(resourceFile);
    }
}
