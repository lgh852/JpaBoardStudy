package io.dkargo.jpaboard.board.user.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqUpdateUserDto {

    @Length(min = 8 , max = 20)
    @NotEmpty
    @ApiModelProperty(value = "사용자 번호", required = true)
    private long userId;

    @ApiModelProperty(value = "작성자")
    private String nickname;

}
