package io.dkargo.jpaboard.board.user.dto.request;

import io.dkargo.jpaboard.board.entity.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqCreateUserDto {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String nickname;

    @NotNull
    private Gender gender;

}
