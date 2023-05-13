package com.mohammedismaiel.fxspringboot.app.resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Test {
    @GetMapping(value = "/test")
    public String getMethodName(@RequestParam(defaultValue = "write a param") String param) {
        return "hello from server\n" + param;
    }

}
