package com.ducanh.duan.controller;

import com.ducanh.duan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getImageResource(@PathVariable(name = "id") int id, HttpServletRequest request) throws IOException {
        return imageService.exportDownload(id, request);
    }
}
