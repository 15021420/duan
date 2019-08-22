package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.ChangeAvatarVM;
import com.ducanh.duan.dto.AlbumImageDTO;
import com.ducanh.duan.dto.UserBasicInfo;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.model.Images;
import com.ducanh.duan.model.RequestAddFriend;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.ImagesRepository;
import com.ducanh.duan.repository.RequestAddFriendRepository;
import com.ducanh.duan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private RequestAddFriendRepository requestAddFriendRepository;

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private Object data;

    @Override
    public void initUser(Model model) throws SQLException {
        List<Object[]> dataResult = userRepository.findBasicInfoUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        if (!dataResult.isEmpty()) {
            userBasicInfo.setFullName(String.valueOf(dataResult.get(0)[0]));
            userBasicInfo.setBirthDay(String.valueOf(dataResult.get(0)[1]));
            userBasicInfo.setLocation(String.valueOf(dataResult.get(0)[2]));
            userBasicInfo.setUrlAvatar(String.valueOf(dataResult.get(0)[3]));
        }
        model.addAttribute("userInfo", userBasicInfo);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Object> changeAvatar(ChangeAvatarVM changeAvatarVM) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = accountRepository.findByUserName(username);
        try {
            int imageId = imageService.singleImageUpload(changeAvatarVM.getAvatar());
            if (imageId != 0) {
                String urlAvatar = "/images/get/" + imageId;
                acc.setUrlAvatar(urlAvatar);
                accountRepository.save(acc);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<String> getAllImageOfUser() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = accountRepository.findByUserName(username);

        List<String> listImageIdOfUser = new ArrayList<>();

        List<Object[]> imagesList = imagesRepository.findImageIdByAccountId(acc.getAccountId());

        for(Object[] imageId : imagesList) {
            listImageIdOfUser.add(String.valueOf(imageId[0]));
        }

        return listImageIdOfUser;
    }

    @Override
    public void getNotify(Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = accountRepository.findByUserName(username);

        List<RequestAddFriend> listNotifyNotifyNotCheck = requestAddFriendRepository.findByAccountIdToAndIsCheckedOrderByCreatedAtDesc(acc.getAccountId(), false);

        List<RequestAddFriend> listNotifyNotifyChecked= requestAddFriendRepository.findByAccountIdToAndIsCheckedOrderByCreatedAtDesc(acc.getAccountId(), true);

       int countNotify = requestAddFriendRepository.countByAccountIdTo(acc.getAccountId());

        model.addAttribute("listNotifyChecked", listNotifyNotifyChecked);
        model.addAttribute("listNotifyNotCheck", listNotifyNotifyNotCheck);
        model.addAttribute("countNotify", countNotify);
    }

    @Override
    public ResponseEntity<Object> changeStatusCheckNotify() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Account acc = accountRepository.findByUserName(username);

            requestAddFriendRepository.setAllNotifyChecked(acc.getAccountId());
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

}
