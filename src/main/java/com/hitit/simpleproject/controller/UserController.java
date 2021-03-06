package com.hitit.simpleproject.controller;


import com.hitit.simpleproject.entity.dto.UserDTO;
import com.hitit.simpleproject.entity.User;
import com.hitit.simpleproject.exception.UserNotFoundException;
import com.hitit.simpleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user.toUserDto();
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.create(user.toUser());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        model.addAttribute("user", user.toUserDto());

        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute UserDTO user, BindingResult result, Model model) {
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
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userService.delete(user);

    }
}

