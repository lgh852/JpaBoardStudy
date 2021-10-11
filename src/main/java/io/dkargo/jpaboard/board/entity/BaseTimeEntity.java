package io.dkargo.jpaboard.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();

//    private LocalDateTime createBy;

    @LastModifiedDate
    @Column(updatable = true)
    private LocalDateTime changeAt;

    //@LastModifiedBy
//    private String changeBy;


}
