package io.dkargo.jpaboard.board.category.repository;

import io.dkargo.jpaboard.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByIdIn(List<Long> categoryId);
}
