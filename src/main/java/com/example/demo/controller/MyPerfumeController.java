package com.example.demo.controller;

import com.example.demo.service.MyPerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPerfumeController {

    @Autowired
    private MyPerfumeService myPerfumeService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myPerfumeService.deleteById(id);
        return "redirect:/my_perfume";
    }
}
