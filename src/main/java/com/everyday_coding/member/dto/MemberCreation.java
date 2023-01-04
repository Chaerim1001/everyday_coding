package com.everyday_coding.member.dto;

import lombok.Data;

public interface MemberCreation {

    @Data
    class RequestDto {
        private String email;
        private String nickname;
        private String password;
    }

    @Data
    class ResponseDto {
        private Long id;
        private String email;
    }
}
