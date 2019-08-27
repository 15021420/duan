package com.ducanh.duan.service;

import com.ducanh.duan.dto.MultiImageUploadDTO;
import com.ducanh.duan.dto.SingleImageUploadDTO;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.model.Images;
import com.ducanh.duan.model.PostImages;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.ImagesRepository;
import com.ducanh.duan.repository.PostImagesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private static Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private StorageService storageService;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Integer> multiImageUpload(MultipartFile[] fileToUpload) throws IOException {

        Account acc = accountRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Integer> listImageId = new ArrayList<>();

        for(MultipartFile file : fileToUpload) {
            String locationImage = storageService.storeFile(file);
            log.debug("URL storage image: {}", locationImage);
            Images images = new Images();
            images.setAccountId(acc.getAccountId());
            images.setLocation(locationImage);
            images.setCreatedAt(new Date());
            images.setHidden(false);

            imagesRepository.save(images);

            listImageId.add(images.getImageId());
        }

        return listImageId;
    }

    @Override
    public Integer singleImageUpload(MultipartFile fileToUpload) throws IOException {
        Account acc = accountRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        String locationImage = storageService.storeFile(fileToUpload);
        Images images = new Images();
        images.setAccountId(acc.getAccountId());
        images.setLocation(locationImage);
        images.setCreatedAt(new Date());
        images.setHidden(false);

        imagesRepository.save(images);

        return images.getImageId();
    }

    @Override
    public ResponseEntity<Resource> exportDownload(int id, HttpServletRequest request) throws IOException {
        Images imageStore = imagesRepository.findByImageId(id);
        String locationImage = imageStore.getLocation();

        return storageService.downloadFile(locationImage, request);
    }


}
