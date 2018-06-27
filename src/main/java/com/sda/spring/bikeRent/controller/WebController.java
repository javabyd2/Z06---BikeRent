package com.sda.spring.bikeRent.controller;

import com.sda.spring.bikeRent.model.Bike;
import com.sda.spring.bikeRent.model.Rent;
import com.sda.spring.bikeRent.model.User;
import com.sda.spring.bikeRent.service.BikeService;
import com.sda.spring.bikeRent.service.RentService;
import com.sda.spring.bikeRent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private final UserService userService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private RentService rentService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addUser");
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
        modelAndView.addObject("bikesList", bikeService.getBikes());
//        modelAndView.addObject("bikesId", bikeService.getBikeById());
//        modelAndView.addObject("bikesPrice", bikeService.());
        modelAndView.setViewName("search");
        return modelAndView;
    }

    @PostMapping(value = "/addBike")
    public ModelAndView addBike(Bike bike, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addBike");
        } else {
            bikeService.save(bike);
            modelAndView.addObject("successMessage", "Successfully added user");
        }
        modelAndView.setViewName("addBike");
        return modelAndView;
    }

    //
    @GetMapping(value = "/addBike")
    public ModelAndView addBike() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bike", new Bike());
        modelAndView.setViewName("addBike");
        return modelAndView;
    }

    @DeleteMapping(value = "/addBike/{id}")
    public String deleteBike(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        bikeService.deleteBike(id);
        redirectAttributes.addFlashAttribute("successMessage", "Bike deleted");
        return "redirect:/bikes";
    }

    @PostMapping(value = "/addRent")
    public ModelAndView addRent(Rent rent, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addRent");
        } else {
            rentService.save(rent);
            modelAndView.addObject("successMessage", "Successfully added rent");
        }
        modelAndView.setViewName("addRent");
        return modelAndView;
    }

    @GetMapping(value = "/rents")
    public ModelAndView rents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rentsLis",rentService.getRents());
        modelAndView.setViewName("rents");
        return modelAndView;
    }

    @DeleteMapping(value = "/rents{id}")
    public String deleteRent(@PathVariable("id")Long id,RedirectAttributes redirectAttributes){
        rentService.deleteRent(id);
        redirectAttributes.addFlashAttribute("successMessage","Rent deleted");
        return "redirect:/rents";
    }

}