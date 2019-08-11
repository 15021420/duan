package com.ducanh.duan.service;

import com.ducanh.duan.model.Role;

public interface RoleService {
    Role findRoleByRoleName(String roleName);
    Role saveRole(Role role);
}
