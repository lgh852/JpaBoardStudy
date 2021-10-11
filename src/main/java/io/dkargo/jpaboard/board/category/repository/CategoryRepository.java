package io.dkargo.jpaboard.board.category.repository;

import io.dkargo.jpaboard.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
