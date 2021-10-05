package io.dkargo.jpaboard.board.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createAt;

    //@CreatedBy
    private String createBy;

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDate changeAt;

    //@LastModifiedBy
    private String changeBy;


}
