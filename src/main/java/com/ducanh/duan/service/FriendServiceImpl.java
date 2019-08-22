package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.AddFriendVM;
import com.ducanh.duan.controller.vm.RemoveAddFriendVM;
import com.ducanh.duan.controller.vm.RequestAddFriendVM;
import com.ducanh.duan.controller.vm.UnfriendVM;
import com.ducanh.duan.dto.DataSearchFriendDTO;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.model.Friend;
import com.ducanh.duan.model.RequestAddFriend;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.FriendRepository;
import com.ducanh.duan.repository.RequestAddFriendRepository;
import com.ducanh.duan.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    private Logger log = LoggerFactory.getLogger(FriendServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RequestAddFriendRepository requestAddFriendRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public List<DataSearchFriendDTO> searchFriendByUsername(String paramSearch) {

        String usernameQuery = SecurityContextHolder.getContext().getAuthentication().getName();

        Account myAccount = accountRepository.findByUserName(usernameQuery);

        List<Object[]> dataSearch = accountRepository.fullTextSSearchAccountByParam(usernameQuery, paramSearch);

        List<DataSearchFriendDTO> dataSearchFriendDTOS = new ArrayList<>();

        for(Object[] dataItem : dataSearch) {
            String accountId = String.valueOf(dataItem[0]);
            String username = String.valueOf(dataItem[1]);
            String xa = String.valueOf(dataItem[2]);
            String huyen = String.valueOf(dataItem[3]);
            String tinh = String.valueOf(dataItem[4]);
            String school = String.valueOf(dataItem[5]);
            String urlAvatar = String.valueOf(dataItem[6]);
            String favorite = String.valueOf(dataItem[7]);
            String birthDay = String.valueOf(dataItem[8]);
            String displayName = String.valueOf(dataItem[9]);

            Friend checkFriend = friendRepository.findByAccountId1AndAccountId2(myAccount.getAccountId(), Integer.parseInt(accountId));

            int statusFriend = 0;

            if (checkFriend != null) {
                statusFriend = Constants.isFriend;
            } else {
             RequestAddFriend checkRequestAddFriend =  requestAddFriendRepository.findByAccountIdFromAndAccountIdToOrderByCreatedAtDesc(myAccount.getAccountId(), Integer.parseInt(accountId));
              if (checkRequestAddFriend != null) {
                  statusFriend = Constants.sentRequestFriend;
              } else {
                  statusFriend = Constants.notAFriendAndNotSentRequest;
              }
            }

           DataSearchFriendDTO itemDataSearch = new DataSearchFriendDTO(accountId, username, xa, huyen, tinh, school, urlAvatar, favorite, birthDay, displayName, statusFriend);
           dataSearchFriendDTOS.add(itemDataSearch);
        }

        return dataSearchFriendDTOS;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Object> addRequestAddFriend(RequestAddFriendVM requestAddFriendVM) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            Account acc = accountRepository.findByUserName(username);

            RequestAddFriend requestAddFriend = new RequestAddFriend();
            requestAddFriend.setAccountIdFrom(acc.getAccountId());
            requestAddFriend.setAccountIdTo(requestAddFriendVM.getAccountIdRequest());
            requestAddFriend.setCreatedAt(new Date());
            requestAddFriend.setAccountDisplayNameFrom(acc.getDisplayName());
            requestAddFriendRepository.save(requestAddFriend);

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> removeAddFriendVM(RemoveAddFriendVM removeAddFriendVM) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            Account acc = accountRepository.findByUserName(username);

            RequestAddFriend  requestAddFriend = requestAddFriendRepository.findByAccountIdFromAndAccountIdToOrderByCreatedAtDesc(acc.getAccountId(), removeAddFriendVM.getAccountIdRequest());

            if (requestAddFriend != null) {
                requestAddFriendRepository.delete(requestAddFriend);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> unFriend(UnfriendVM unfriendVM) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            Account acc = accountRepository.findByUserName(username);
            Friend relation1 = friendRepository.findByAccountId1AndAccountId2(acc.getAccountId(), unfriendVM.getAccountIdRequest());
            Friend relation2 = friendRepository.findByAccountId1AndAccountId2(unfriendVM.getAccountIdRequest(), acc.getAccountId());

            if (relation1 != null && relation2 != null) {
                friendRepository.delete(relation1);
                friendRepository.delete(relation2);
            }return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> addFriend(AddFriendVM addFriendVM) {

        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            Account acc = accountRepository.findByUserName(username);

            RequestAddFriend requestAddFriend = requestAddFriendRepository.findByAccountIdFromAndAccountIdToOrderByCreatedAtDesc(addFriendVM.getAccountIdFrom(), acc.getAccountId());

            if (requestAddFriend != null) requestAddFriendRepository.delete(requestAddFriend);

            RequestAddFriend requestAddFriendReverse = requestAddFriendRepository.findByAccountIdFromAndAccountIdToOrderByCreatedAtDesc(acc.getAccountId(), addFriendVM.getAccountIdFrom());

            if (requestAddFriendReverse != null) requestAddFriendRepository.delete(requestAddFriendReverse);

            friendRepository.save(new Friend(acc.getAccountId(), addFriendVM.getAccountIdFrom(), new Date()));
            friendRepository.save(new Friend(addFriendVM.getAccountIdFrom(), acc.getAccountId(), new Date()));

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
}
