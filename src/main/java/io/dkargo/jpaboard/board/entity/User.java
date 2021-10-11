package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.entity.converter.GenderConverter;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
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
        this.setCreateAt(LocalDateTime.now());
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
        this.setChangeAt(LocalDateTime.now());
    }
}
