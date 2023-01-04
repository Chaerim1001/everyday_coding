package com.everyday_coding.member.service;

import com.everyday_coding.common.CommonEncoder;
import com.everyday_coding.domain.account.Account;
import com.everyday_coding.domain.account.AccountRepository;
import com.everyday_coding.domain.member.Member;
import com.everyday_coding.domain.member.MemberRepository;
import com.everyday_coding.member.dto.MemberCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final AccountRepository accountRepository;
    private final CommonEncoder passwordEncoder;

    @Transactional
    public MemberCreation.ResponseDto createMember(MemberCreation.RequestDto requestDto) {
        // todo: 이메일 중복 확인
        // todo: 닉네임 중복 확인

        Account account = accountRepository.save(Account.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build());
        Member member = memberRepository.save(Member.builder()
                .account(account)
                .nickname(requestDto.getNickname())
                .build());

        MemberCreation.ResponseDto responseDto = new MemberCreation.ResponseDto();
        responseDto.setEmail(member.getAccount().getEmail());
        responseDto.setId(member.getId());
        return responseDto;
    }
}
