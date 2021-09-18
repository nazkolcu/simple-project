package com.hitit.simpleproject.controller;


import com.hitit.simpleproject.entity.DTO.UserDTO;
import com.hitit.simpleproject.entity.User;
import com.hitit.simpleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public UserDTO getById(@PathVariable("id") long id) {

        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        return user.toUserDto();
    }

    @GetMapping("/signup")
    public String showSignUpForm(@ModelAttribute User user)//User user @ModelAttribute UserDto user
    {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute UserDTO user, BindingResult result, Model model) //User user
    {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.create(user.toUser());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user.toUserDto());

        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid @ModelAttribute UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userService.create(user.toUser());

        return "redirect:/index";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user);

    }
}

