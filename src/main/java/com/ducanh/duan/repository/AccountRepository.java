package com.ducanh.duan.repository;

import com.ducanh.duan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String username);
    List<Account> findAll();

    @Query(value = "select account_id, username, xa, huyen, tinh, school, url_avatar, favorite, birthday, display_name FROM account WHERE username <> ?1 AND MATCH(xa, huyen, tinh, username, display_name) AGAINST(?2 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<Object[]> fullTextSSearchAccountByParam(String username, String paramSearch);

    Account findByAccountId(int accountId);
}
