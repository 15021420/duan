package com.ducanh.duan.service;

import com.ducanh.duan.dto.GetListAllAccountDTO;

import java.util.List;

public interface AdminService {
    List<GetListAllAccountDTO> findAllAccount();
}
