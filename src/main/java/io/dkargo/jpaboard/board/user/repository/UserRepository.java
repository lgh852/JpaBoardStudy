package io.dkargo.jpaboard.board.user.repository;

import io.dkargo.jpaboard.board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
