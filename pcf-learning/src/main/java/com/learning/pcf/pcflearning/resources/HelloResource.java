package com.learning.pcf.pcflearning.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping(path = "/hello/{name}")
    public String hello(@PathVariable("name") final String name) {
        return "Hello " + name;
    }

}
