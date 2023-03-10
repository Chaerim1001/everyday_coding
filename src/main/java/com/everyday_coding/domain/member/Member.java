package com.everyday_coding.domain.member;

import com.everyday_coding.domain.BaseTimeEntity;
import com.everyday_coding.domain.account.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "nickname", length = 25, unique = true, nullable = false)
    private String nickname;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder
    public Member(String nickname, Account account) {
        this.nickname = nickname;
        this.account = account;
    }
}
