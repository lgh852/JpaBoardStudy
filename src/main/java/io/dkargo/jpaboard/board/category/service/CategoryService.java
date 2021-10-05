package io.dkargo.jpaboard.board.category.service;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;

public interface CategoryService {

    public ResCreateCategoryDto createCatefory(ReqCreateCategoryDto dto);
}
