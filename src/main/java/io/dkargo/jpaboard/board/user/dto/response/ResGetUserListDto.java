package io.dkargo.jpaboard.board.user.dto.response;

import io.dkargo.jpaboard.board.entity.Gender;
import io.dkargo.jpaboard.board.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResGetUserListDto {

    @ApiModelProperty( value = "현재 페이지 번호" )
    private int page;

    @ApiModelProperty( value = "한페이지 SIZE" )
    private int size;

    @ApiModelProperty( value = "전체 페이지 수" )
    private int totalPage;

    private List<GetUser> list = new ArrayList<>();

    public ResGetUserListDto(List<User> list, int page, int size, int totalPage) {
        this.list = list.stream().map(u -> new GetUser(u)).collect(Collectors.toList());
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetUser {

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

        public GetUser(User user) {
            this.email = user.getEmail();
            this.nickname = user.getNickname();
            this.gender = user.getGender();
            this.profilePath = user.getProfilePath();
            this.createdAt = user.getCreateAt();
            this.changeAt = user.getChangeAt();
        }
    }
}
