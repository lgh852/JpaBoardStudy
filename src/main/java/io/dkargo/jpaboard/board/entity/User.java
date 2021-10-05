package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.entity.converter.GenderConverter;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    private String email;

    private String nickname;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    public User(ReqCreateUserDto dto) {
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.gender = dto.getGender();
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }
}
