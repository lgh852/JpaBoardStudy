package io.dkargo.jpaboard.board.category.service.impl;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.repository.CategoryRepository;
import io.dkargo.jpaboard.board.category.service.CategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public ResCreateCategoryDto createCatefory(ReqCreateCategoryDto dto) {
        categoryRepository.save("dto")
        return null;
    }
}
