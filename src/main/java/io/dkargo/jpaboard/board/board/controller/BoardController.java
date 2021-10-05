package io.dkargo.jpaboard.board.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String BoardList() throws Exception {

        /*throw new NumberFormatException();*/

        return "200";
    }
}
