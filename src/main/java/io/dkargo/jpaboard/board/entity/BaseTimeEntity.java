package io.dkargo.jpaboard.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Getter
@Setter
public class BaseTimeEntity {

    @CreatedDate
    private LocalDate createAt;

    //@CreatedBy
    private String createBy;

    @LastModifiedDate
    private LocalDate changeAt;

    //@LastModifiedBy
    private String changeBy;


}
