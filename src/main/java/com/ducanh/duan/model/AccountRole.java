package com.ducanh.duan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "account_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "role_id")
    private int roleId;
}
