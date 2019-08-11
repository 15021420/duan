package com.ducanh.duan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultiFileUploadDTO {

    @JsonProperty("list_url_download")
    private List<String> listUrlDownload;
}
