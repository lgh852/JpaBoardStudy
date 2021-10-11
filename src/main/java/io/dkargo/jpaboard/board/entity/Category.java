package io.dkargo.jpaboard.board.entity;

import com.fasterxml.classmate.AnnotationOverrides;
import io.dkargo.jpaboard.board.category.dto.request.ReqCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.request.ReqUpdateCategoryDto;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void updateCategory(ReqUpdateCategoryDto reqDto){
        this.title = reqDto.getTitle();
        this.setChangeAt(LocalDateTime.now());
    }
}
