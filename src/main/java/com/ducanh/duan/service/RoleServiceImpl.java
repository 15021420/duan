package com.ducanh.duan.service;

import com.ducanh.duan.model.Role;
import com.ducanh.duan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(String roleName) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }
}
