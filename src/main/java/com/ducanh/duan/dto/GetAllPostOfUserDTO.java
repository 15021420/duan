package com.ducanh.duan.dto;

import java.util.List;

public class GetAllPostOfUserDTO {

    private List<SinglePostOfUserDTO> postOfUserDTOList;

    public GetAllPostOfUserDTO() {
    }

    public GetAllPostOfUserDTO(List<SinglePostOfUserDTO> postOfUserDTOList) {
        this.postOfUserDTOList = postOfUserDTOList;
    }

    public List<SinglePostOfUserDTO> getPostOfUserDTOList() {
        return postOfUserDTOList;
    }

    public void setPostOfUserDTOList(List<SinglePostOfUserDTO> postOfUserDTOList) {
        this.postOfUserDTOList = postOfUserDTOList;
    }
}
