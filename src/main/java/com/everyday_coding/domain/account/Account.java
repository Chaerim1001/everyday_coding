package com.everyday_coding.domain.account;

import com.everyday_coding.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "email", length = 65, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 105, nullable = false)
    private String password;
}
