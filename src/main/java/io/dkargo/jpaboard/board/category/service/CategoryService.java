package io.dkargo.jpaboard.board.category.service;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqDeleteCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqUpdateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryListDto;

public interface CategoryService {

    ResCreateCategoryDto createCategory(ReqCreateCategoryDto reqDto);

    boolean updateCategory(ReqUpdateCategoryDto reqDto);

    boolean deleteCategory(ReqDeleteCategoryDto reqDto);

    ResGetCategoryDto getCategory(Long categoryId);

    ResGetCategoryListDto getCategoryList(int page, int size);
}
