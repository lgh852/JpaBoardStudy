package io.dkargo.jpaboard.board.category.dto.response;

import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import io.dkargo.jpaboard.board.entity.Board;
import io.dkargo.jpaboard.board.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResGetCategoryListDto {

    @ApiModelProperty( value = "현재 페이지 번호" )
    private int page;

    @ApiModelProperty( value = "한페이지 SIZE" )
    private int size;

    @ApiModelProperty( value = "전체 페이지 수" )
    private int totalPage;

    private List<ResGetCategoryDto> list = new ArrayList<>();

    public ResGetCategoryListDto(List<Category> list, int page, int size, int totalPage) {
        this.list = list.stream().map(u -> new ResGetCategoryDto(u)).collect(Collectors.toList());
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }
}
