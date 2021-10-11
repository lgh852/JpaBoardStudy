package io.dkargo.jpaboard.board.category.dto.request;

import io.dkargo.jpaboard.board.entity.Category;
import io.dkargo.jpaboard.board.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqCreateCategoryDto {

    @NotNull
    @ApiModelProperty( value = "화원 번호", required = true )
    private long userId;

    @NotEmpty
    @ApiModelProperty( value = "카테고리 제목", required = true )
    private String title;

    public Category toCategory(){
        return Category.builder()
                .title(this.title)
                .build();
    }

}
