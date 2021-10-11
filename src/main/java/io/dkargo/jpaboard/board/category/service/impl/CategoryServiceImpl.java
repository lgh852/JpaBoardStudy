package io.dkargo.jpaboard.board.category.service.impl;

import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqDeleteCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqUpdateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryListDto;
import io.dkargo.jpaboard.board.category.repository.CategoryRepository;
import io.dkargo.jpaboard.board.category.service.CategoryService;
import io.dkargo.jpaboard.board.entity.Category;
import io.dkargo.jpaboard.board.entity.PageRequest;
import io.dkargo.jpaboard.board.entity.User;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import io.dkargo.jpaboard.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public ResCreateCategoryDto createCategory(ReqCreateCategoryDto reqDto) {

        User user = userFindById(reqDto.getUserId());
        Category category = reqDto.toCategory();
        category.setUser(user);
        categoryRepository.save(category);
        return new ResCreateCategoryDto(category.getId());
    }

    @Override
    public boolean updateCategory(ReqUpdateCategoryDto reqDto) {

        User user = userFindById(reqDto.getUserId());

        Category category = categoryFindById(reqDto.getCategoryId());
        categoryIsUserMissMatch(category, user);
        category.updateCategory(reqDto);
        categoryRepository.save(category);

        return true;
    }

    @Override
    public boolean deleteCategory(ReqDeleteCategoryDto reqDto) {

        User user = userFindById(reqDto.getUserId());

        Category category = categoryFindById(reqDto.getCategoryId());
        categoryIsUserMissMatch(category, user);
        categoryRepository.deleteById(reqDto.getCategoryId());

        return true;
    }

    @Override
    public ResGetCategoryDto getCategory(Long categoryId) {

        Category category = categoryFindById(categoryId);

        return new ResGetCategoryDto(category);
    }

    @Override
    public ResGetCategoryListDto getCategoryList(int page, int size) {

        PageRequest pr = new PageRequest(page, size, Sort.Direction.DESC);
        List<Category> categorList = categoryRepository.findAll(pr.of()).getContent();

        Long count = categoryRepository.count();
        int totalPage = (int) ((count + size - 1) / size);

        return new ResGetCategoryListDto(categorList, page, size, totalPage);
    }

    public void categoryIsUserMissMatch(Category category,User user){
        if(category.getUser().getId() != user.getId()){
            throw new DkargoException(ErrorCode.CATEGORY_MISS_MATCH_USER);
        }
    }

    public User userFindById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));
    }

    public Category categoryFindById(Long categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DkargoException(ErrorCode.CATEGORY_NOT_FOUND));
    }
}
