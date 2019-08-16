package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.LockOrUnlockAccVM;
import com.ducanh.duan.dto.GetListAllAccountDTO;
import com.ducanh.duan.dto.LockOrUnlockAccDTO;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<GetListAllAccountDTO> findAllAccount() {

        List<Account> accountList = accountRepository.findAll();

        List<GetListAllAccountDTO> dataResponse = new ArrayList<>();

        for(Account acc : accountList) {
            int accountId = acc.getAccountId();
            List<Object[]> listDataRole = roleRepository.findListRoleByAccountId(accountId);

            List<String> userRole = new ArrayList<>();

            for(Object[] obj : listDataRole) {
                String roleName = String.valueOf(obj[0]);
                userRole.add(roleName);
            }
            dataResponse.add(new GetListAllAccountDTO(acc.getUserName(), acc.getActive(), acc.getCreatedAt(), userRole));
        }

        return dataResponse;
    }

    @Override
    public ResponseEntity<LockOrUnlockAccDTO> lockOrUnlockAccount(LockOrUnlockAccVM lockOrUnlockAccVM) {
        try {
            Account acc = accountRepository.findByUserName(lockOrUnlockAccVM.getUsername());
            acc.setActive(lockOrUnlockAccVM.isStatus());
            log.debug("status: {}", lockOrUnlockAccVM.isStatus());
            accountRepository.save(acc);
            log.debug("acc: {}", acc);
            return new ResponseEntity<>(new LockOrUnlockAccDTO("success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new LockOrUnlockAccDTO("failed"), HttpStatus.BAD_REQUEST);
        }
    }


}
