package io.dkargo.jpaboard.board.user.dto.response;

import io.dkargo.jpaboard.board.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResUpdateUserDto {

    @ApiModelProperty(value = "성공 (true)")
    private boolean isSuccess;

    @ApiModelProperty(value = "작성자")
    private String nickname;

    @ApiModelProperty(value = "프로필 경로")
    private String profilePath;

    public ResUpdateUserDto(User user) {
        this.isSuccess = true;
        this.nickname = user.getNickname();
        this.profilePath = user.getProfilePath();
    }
}
