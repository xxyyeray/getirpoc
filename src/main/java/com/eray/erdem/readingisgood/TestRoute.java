package com.eray.erdem.readingisgood;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class TestRoute {

    @GetMapping
    public String test() {
        return "World";
    }
}
