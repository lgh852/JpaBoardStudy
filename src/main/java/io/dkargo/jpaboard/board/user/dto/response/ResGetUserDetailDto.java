package io.dkargo.jpaboard.board.user.dto.response;

import io.dkargo.jpaboard.board.entity.Gender;
import io.dkargo.jpaboard.board.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResGetUserDetailDto {

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "별명")
    private String nickname;

    @ApiModelProperty(value = "성별")
    private Gender gender;

    @ApiModelProperty(value = "등록일")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "변경")
    private LocalDateTime changeAt;

    @ApiModelProperty(value = "프로필 사진 경로")
    private String profilePath;

    public ResGetUserDetailDto(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.gender = user.getGender();
        this.profilePath = user.getProfilePath();
        this.createdAt = user.getCreateAt();
        this.changeAt = user.getChangeAt();
    }
}
