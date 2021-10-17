package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.entity.converter.GenderConverter;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String nickname;

    private String profilePath;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boardList = new ArrayList<>();

    public User(ReqCreateUserDto dto, String profilePath) {
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.gender = dto.getGender();
        this.profilePath = profilePath;
        this.changeAt = LocalDateTime.now();
    }

    public void changeUser(String nickname, String profilePath) {
        this.nickname = nickname;
        if (profilePath != null)
        this.profilePath = profilePath;
    }
}
