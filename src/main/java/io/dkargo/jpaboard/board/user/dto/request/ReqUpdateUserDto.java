package io.dkargo.jpaboard.board.user.dto.request;

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
    private long userId;

    private String nickname;

}
