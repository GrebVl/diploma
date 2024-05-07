package com.diploma.bookEssays.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Validated
public class TestController {

    @GetMapping
    public String newTest1(){
        return "test 1";
    }

    @PostMapping
    public String newTest2(){
        return "test 2";
    }
}
