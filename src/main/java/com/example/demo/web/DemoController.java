package com.example.demo.web;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String getName() {
        return "hello";
    }

    @GetMapping("/students")
    private JSONObject getStudents(@RequestParam String id) {
        JSONObject obj = new JSONObject();
        obj.put("age", id);
        return obj;
    }

    @GetMapping("/userName/{id}")
    private String getUserName(@PathVariable int id) {
        return "my name " + id;

    }
}
