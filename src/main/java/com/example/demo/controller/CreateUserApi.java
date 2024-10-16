package com.example.demo.controller;

import com.example.demo.config.UserInfoDetails;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateUserApi {
    @Autowired
    private UserService userService;



    @GetMapping(value = "/create-user")
    public String createUser(@RequestParam String username, @RequestParam String password){
        userService.createUser(username,password);
        return "user created!!";
    }

    @GetMapping(value = "/create-admin")
    public String createAdmin(@RequestParam String username, @RequestParam String password){
        userService.createAdmin(username,password);
        return "Admin created!!";
    }



    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }



    //@GetMapping(value = "/add-to-cart")
   // @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    //public UserCart addToCart(@RequestParam String pid) throws Exception {
      //  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // UserInfoDetails userInfoDetails = (UserInfoDetails) authentication.getPrincipal();
       // UserCart userCart = userCartService.addToCart(userInfoDetails.getUsername(),pid);
       // return userCart;
   // }

}
