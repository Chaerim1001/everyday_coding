package com.everyday_coding.domain.account;

import com.everyday_coding.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "email", length = 65, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 105, nullable = false)
    private String password;

    @Column(length = 1000)
    private String oauthAccessToken;

    @Column(length = 1000)
    private String oauthRefreshToken;

    @Builder
    public Account(String email, String password, String oauthAccessToken, String oauthRefreshToken) {
        this.email = email;
        this.password = password;
        this.oauthAccessToken = oauthAccessToken;
        this.oauthRefreshToken = oauthRefreshToken;
    }
}
