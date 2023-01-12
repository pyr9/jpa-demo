package org.pyr.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/greeting/hello")
    String helloWorld() {
        return "Hello World";
    }
}
