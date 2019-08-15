package com.ducanh.duan.repository;

import com.ducanh.duan.dto.UserBasicInfo;
import com.ducanh.duan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String username);

    List<Account> findAll();
}
