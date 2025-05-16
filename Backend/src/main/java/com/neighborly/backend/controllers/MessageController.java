package com.neighborly.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ping")
public class MessageController {

    @GetMapping
    public Map<String, String> ping() {
        HashMap<String, String> map = new HashMap<>();
        map.put("hi", "ping");
        return map;
    }

}
