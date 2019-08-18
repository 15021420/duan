package com.ducanh.duan.dto;

import java.util.List;

public class AlbumImageDTO {
    private List<String> listImageResource;

    public AlbumImageDTO() {
    }

    public AlbumImageDTO(List<String> listImageResource) {
        this.listImageResource = listImageResource;
    }

    public List<String> getListImageResource() {
        return listImageResource;
    }

    public void setListImageResource(List<String> listImageResource) {
        this.listImageResource = listImageResource;
    }
}
