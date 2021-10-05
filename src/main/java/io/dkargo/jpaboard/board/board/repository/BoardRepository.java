package io.dkargo.jpaboard.board.board.repository;

import io.dkargo.jpaboard.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
