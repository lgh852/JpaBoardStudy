package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.category.dto.request.ReqUpdateCategoryDto;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
public class Category extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "category")
    private List<BoardCategory> boardCategory;

    public Category(Long id, String title){
        this.id = id;
        this.title = title;
        this.changeAt = LocalDateTime.now();
    }

    public Category(String title) {
        this.title = title;
    }

    public void updateCategory(ReqUpdateCategoryDto reqDto){
        this.title = reqDto.getTitle();
    }
}
