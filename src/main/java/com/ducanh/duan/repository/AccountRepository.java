package com.ducanh.duan.repository;

import com.ducanh.duan.dto.UserBasicInfo;
import com.ducanh.duan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String username);

    @Query(value = "SELECT username, role.role_name, account.active, account.created_at FROM account join account_role on account.account_id = account_role.account_id join role on account_role.role_id = role.role_id order by account.active, account.created_at", nativeQuery = true)
    List<Object[]> findAccountOrderByCreatedAtAndActive();
}
