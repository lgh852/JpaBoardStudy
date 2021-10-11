package io.dkargo.jpaboard.board.user.dto.request;

import io.dkargo.jpaboard.board.entity.Gender;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "ghlee@dkargo.io", value = "이메일", required = true)
    private String email;

    @NotEmpty
    @ApiModelProperty(example = "ghlee", value = "별명", required = true )
    private String nickname;

    @NotNull
    @ApiModelProperty(example = "Male", value = "성별")
    private Gender gender;

}
