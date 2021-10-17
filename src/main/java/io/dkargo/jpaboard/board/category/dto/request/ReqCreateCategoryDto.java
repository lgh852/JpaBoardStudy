package io.dkargo.jpaboard.board.category.dto.request;

import io.dkargo.jpaboard.board.entity.Category;
import io.dkargo.jpaboard.board.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqCreateCategoryDto {

    @NotBlank
    @ApiModelProperty( value = "카테고리 제목", required = true )
    private String title;

    public Category toCategory(){
        return new Category(this.title);
    }

}
