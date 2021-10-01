package io.dkargo.jpaboard.board.member.controller;

import io.dkargo.jpaboard.board.member.service.impl.MemberService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/member")
@NoArgsConstructor
public class MemberController {

    private MemberService memberSerivce;

    @PostMapping("/")
    public String createMember(){


        return "200";
    }
}
