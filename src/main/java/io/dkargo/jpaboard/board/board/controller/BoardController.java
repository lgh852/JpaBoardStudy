package io.dkargo.jpaboard.board.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @GetMapping("/")
    public String BoardList() throws Exception {

        throw new NumberFormatException();

//        return "200";
    }
}
