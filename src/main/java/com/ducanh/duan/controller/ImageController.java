package com.ducanh.duan.controller;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    @ResponseBody
    public String uploadImageFunc() {
        return "upload image";
    }
}
