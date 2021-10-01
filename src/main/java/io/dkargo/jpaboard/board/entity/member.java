package io.dkargo.jpaboard.board.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pwassWord;

    private String name;
    {}
    private String phoneNumber;

    private String address;

    private int zipCode;

    private String addressDetail;

}
