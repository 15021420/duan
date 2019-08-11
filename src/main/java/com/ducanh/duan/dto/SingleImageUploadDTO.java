package com.ducanh.duan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleImageUploadDTO {

    @JsonProperty("url_download_image")
    private String urlDownloadImage;
}
