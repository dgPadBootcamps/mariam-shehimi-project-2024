package com.example.demo.controller;

import com.example.demo.model.MyPerfumeList;
import com.example.demo.model.Perfume;
import com.example.demo.service.MyPerfumeService;
import com.example.demo.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @Autowired
    private MyPerfumeService myPerfumeService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/perfume_register")
    public String perfumeRegister(){
        return "perfumeRegister";
    }

    @GetMapping("/available_perfumes")
    public ModelAndView getAllPerfume(){
        List<Perfume> list = perfumeService.getAllPerfume();
       // ModelAndView m= new ModelAndView();
       // m.setViewName("perfumeList");
       // m.addAllObjects("perfume",list);
        return new ModelAndView("perfumeList","perfume",list);
    }

    @PostMapping("/save")
    public String addPerfume(@ModelAttribute Perfume p){
        perfumeService.save(p);
        return "redirect:/available_perfumes";
    }

    @GetMapping("/my_perfume")
    public String getMyPerfumes(Model model){
        List<MyPerfumeList> list = myPerfumeService.getAllMyPerfumes();
        model.addAttribute("perfume",list);
        return  "myPerfumes";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id){
        Perfume p=perfumeService.getPerfumeById(id);
        MyPerfumeList mb = new MyPerfumeList(p.getId(),p.getName(),p.getCompany(),p.getPrice(),p.getImg());
        myPerfumeService.saveMyPerfumes(mb);
        return "redirect:/my_perfume";
    }

    @RequestMapping("/editPerfume/{id}")
    public String editPerfume(@PathVariable("id") int id ,Model model){
        Perfume p=perfumeService.getPerfumeById(id);
        model.addAttribute("perfume",p);
        return "perfumeEdit";
    }

    @RequestMapping("/deletePerfume/{id}")
    public String deletePerfume(@PathVariable("id") int id ){
        perfumeService.deleteById(id);
        return "redirect:/available_perfumes";
    }

    @GetMapping("/AboutUs")
    public String AboutUs(){
        return "AboutUs";
    }

    @GetMapping("/search")
    public String searchPerfumeByName(@RequestParam("keyword") String keyword, Model model) {
        List<Perfume> searchResults = perfumeService.searchByName(keyword);
        model.addAttribute("products", searchResults);
        model.addAttribute("keyword", keyword);  // To show the search term in the view
        return "searchResults";  // Render the results in a separate page or same page depending on your layout
    }
}
