package io.dkargo.jpaboard.board.category.controller;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqDeleteCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqUpdateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryListDto;
import io.dkargo.jpaboard.board.category.dto.response.ResUpdateCategoryDto;
import io.dkargo.jpaboard.board.category.service.CategoryService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;


    @ApiOperation(
            value = "카테고리 등록",
            notes = "카테고리를 등록한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "생성된 카테고리 ID", response = ResCreateCategoryDto.class)
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResCreateCategoryDto createCategory (@Valid @RequestBody ReqCreateCategoryDto reqDto){
        return categoryService.createCategory(reqDto);
    }

    @ApiOperation(
            value = "카테고리 내용 변경",
            notes = "카테고리 내용을 변경한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "변경시 true", response = ResUpdateCategoryDto.class)
    })
    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateCategory (@Valid @RequestBody ReqUpdateCategoryDto reqDto){
        return categoryService.updateCategory(reqDto);
    }


    @ApiOperation(
            value = "단건 카테고리 삭제",
            notes = "단건의 카테고리를 삭제한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "삭제시 true", response = Boolean.class)
    })
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteCategory (@Valid @RequestBody ReqDeleteCategoryDto reqDto){
        return categoryService.deleteCategory(reqDto);
    }

    @ApiOperation(
            value = "카테고리 상세 조회",
            notes = "카테고리 상세 정보를 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "케테고리 ID", required = true, dataType = "long", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "카테고리 상세 정보", response = ResGetCategoryDto.class)
    })
    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetCategoryDto getCategory(@PathVariable(value = "categoryId", required = true) Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @ApiOperation(
            value = "카테고리 목록 조회",
            notes = "케테고리 목록을 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", required = false, defaultValue = "1", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "페이지 사이즈", required = false, defaultValue = "10", dataType = "string", paramType = "query"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "카테고리 목록", response = ResGetCategoryListDto.class)
    })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResGetCategoryListDto getCategoryList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "1") int size){
        return categoryService.getCategoryList(page, size);
    }


}
