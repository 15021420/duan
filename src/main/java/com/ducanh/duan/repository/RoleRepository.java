package com.ducanh.duan.repository;

import com.ducanh.duan.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);

    @Query(value = "SELECT r.role_name FROM role r JOIN account_role ar ON r.role_id = ar.role_id WHERE ar.account_id = ?1", nativeQuery = true)
    List<Object[]> findListRoleByAccountId(int accountId);
}
