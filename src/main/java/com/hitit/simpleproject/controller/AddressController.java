package com.hitit.simpleproject.controller;


import com.hitit.simpleproject.entity.DTO.AddressDTO;
import com.hitit.simpleproject.service.AddressService;
import com.hitit.simpleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AddressController {

    private final AddressService addressService;
    private UserService userService;

    @Autowired
    AddressController(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;

    }

    @GetMapping("/address")
    public String showAddressForm(Model model) {
        model.addAttribute("users", userService.findAll());
        return "add-address";
    }

    @PostMapping("/addaddress")
    public String addAddressToUser(@RequestBody AddressDTO addressDto, BindingResult result) {

        addressService.create(addressDto);

        if (result.hasErrors()) {
            return "add-address";
        }
        return "redirect:/add-address";
    }
}