package com.sda.spring.bikeRent.controller;

import com.sda.spring.bikeRent.model.User;
import com.sda.spring.bikeRent.service.BikeService;
import com.sda.spring.bikeRent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private final UserService userService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "addUser")
    public ModelAndView saveUser(User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Successfully added user");
        }
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bikesList", bikeService.getBike());
//        modelAndView.addObject("bikesId", bikeService.getBikeById());
//        modelAndView.addObject("bikesPrice", bikeService.());
        modelAndView.setViewName("search");
        return modelAndView;
    }
}