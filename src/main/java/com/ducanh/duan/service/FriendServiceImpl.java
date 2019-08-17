package com.ducanh.duan.service;

import com.ducanh.duan.dto.DataSearchFriendDTO;
import com.ducanh.duan.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    private Logger log = LoggerFactory.getLogger(FriendServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<DataSearchFriendDTO> searchFriendByUsername(String paramSearch) {

        List<Object[]> dataSearch = accountRepository.fullTextSSearchAccountByParam(paramSearch);

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
           DataSearchFriendDTO itemDataSearch = new DataSearchFriendDTO(accountId, username, xa, huyen, tinh, school, urlAvatar, favorite, birthDay, displayName);
           dataSearchFriendDTOS.add(itemDataSearch);
        }

        return dataSearchFriendDTOS;
    }
}
