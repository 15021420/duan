package com.ducanh.duan.dto;

import java.io.Serializable;
import java.util.List;

public class MultiImageUploadDTO implements Serializable {
    private List<String> urlImageStore;

    public MultiImageUploadDTO() {
    }

    public MultiImageUploadDTO(List<String> urlImageStore) {
        this.urlImageStore = urlImageStore;
    }

    public List<String> getUrlImageStore() {
        return urlImageStore;
    }

    public void setUrlImageStore(List<String> urlImageStore) {
        this.urlImageStore = urlImageStore;
    }
}
