package io.dkargo.jpaboard.board.board.repository;

import io.dkargo.jpaboard.board.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

}
