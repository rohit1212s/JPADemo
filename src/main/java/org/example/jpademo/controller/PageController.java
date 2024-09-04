package org.example.jpademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Rohit")
public class PageController {

    @RequestMapping("/about")
    public String about(Model model) {
        System.out.println("This is about page");
        model.addAttribute("name", "Api creation with springboot for testing purposes");
        return "about";

    }

    @GetMapping("/SampleData")
//@ResponseBody
    public Map<String, String> getSampleData(){
        Map<String, String> sampleData = new HashMap<>();
        sampleData.put("name", "Rohit");
        sampleData.put("age", "36");
        sampleData.put("profession", "Automation Testing");
        return sampleData;

    }
}
