package io.dkargo.jpaboard.board.user.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResCreateUserDto {

    @ApiModelProperty(value = "사용자 ID")
    private Long userId;
}
