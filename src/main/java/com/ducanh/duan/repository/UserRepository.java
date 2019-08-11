package com.ducanh.duan.repository;

import com.ducanh.duan.dto.UserBasicInfo;
import com.ducanh.duan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.ResultSet;
import java.util.List;

public interface UserRepository extends CrudRepository<Account, Integer> {

    @Query(value = "SELECT display_name as fullName, birthday as birthDay, tinh as location FROM account WHERE username = ?1", nativeQuery = true)
    List<Object[]> findBasicInfoUserByUsername(String username);
}
