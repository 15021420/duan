package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.AddFriendVM;
import com.ducanh.duan.controller.vm.RemoveAddFriendVM;
import com.ducanh.duan.controller.vm.RequestAddFriendVM;
import com.ducanh.duan.controller.vm.UnfriendVM;
import com.ducanh.duan.dto.DataSearchFriendDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FriendService {
    List<DataSearchFriendDTO> searchFriendByUsername(String paramSearch);

    ResponseEntity<Object> addRequestAddFriend(RequestAddFriendVM requestAddFriendVM);

    ResponseEntity<Object> removeAddFriendVM(RemoveAddFriendVM removeAddFriendVM);

    ResponseEntity<Object> unFriend(UnfriendVM unfriendVM);

    ResponseEntity<Object> addFriend(AddFriendVM addFriendVM);
}
