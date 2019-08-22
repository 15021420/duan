package com.ducanh.duan.repository;

import com.ducanh.duan.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Account, Integer> {

    @Query(value = "SELECT display_name as fullName, birthday as birthDay, tinh as location, url_avatar as avatar FROM account WHERE username = ?1", nativeQuery = true)
    List<Object[]> findBasicInfoUserByUsername(String username);

    @Query(value = "SELECT display_name as fullName, birthday as birthDay, tinh as location, url_avatar as avatar FROM account WHERE account_id = ?1", nativeQuery = true)
    List<Object[]> findBasicInfoUserByAccountId(int accountId);
}
