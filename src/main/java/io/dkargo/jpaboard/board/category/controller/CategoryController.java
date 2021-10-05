package io.dkargo.jpaboard.board.category.controller;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController(value = "/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResCreateCategoryDto createCategory (@Valid @RequestBody ReqCreateCategoryDto dto){
        return categoryService.createCatefory(dto);
    }

}
