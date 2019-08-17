package com.ducanh.duan.service;

import com.ducanh.duan.dto.DataSearchFriendDTO;

import java.util.List;

public interface FriendService {
    List<DataSearchFriendDTO> searchFriendByUsername(String paramSearch);
}
