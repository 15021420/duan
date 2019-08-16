package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.LockOrUnlockAccVM;
import com.ducanh.duan.dto.GetListAllAccountDTO;
import com.ducanh.duan.dto.LockOrUnlockAccDTO;
import com.ducanh.duan.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    List<GetListAllAccountDTO> findAllAccount();
    ResponseEntity<LockOrUnlockAccDTO> lockOrUnlockAccount(LockOrUnlockAccVM lockOrUnlockAccVM);
}
