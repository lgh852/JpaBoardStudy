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
    @ApiModelProperty(example = "ghlee@dkargo.io")
    private String email;

    @NotEmpty
    @ApiModelProperty(example = "ghlee")
    private String nickname;

    @NotNull
    @ApiModelProperty(example = "Male")
    private Gender gender;

}
