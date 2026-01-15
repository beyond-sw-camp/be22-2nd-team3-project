package com.ohgiraffers.userservice.user.query.dto.response;

import com.ohgiraffers.userservice.user.command.domain.aggregate.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
public class UserDTO {

    private Long userNo;
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String phoneNum;
    private String birthdate;
    private Date registeredAt;
    private String isNoticeActive;
    private UserRole role;

}
