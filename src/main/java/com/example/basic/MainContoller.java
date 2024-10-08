package com.example.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainContoller {
    @GetMapping("/basic")
    @ResponseBody
    public String index() {
        return "안녕하세요 index 입니다";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
