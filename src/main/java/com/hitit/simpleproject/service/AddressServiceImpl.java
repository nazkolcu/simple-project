package com.hitit.simpleproject.service;

import com.hitit.simpleproject.entity.Address;
import com.hitit.simpleproject.entity.dto.AddressDTO;
import com.hitit.simpleproject.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final UserService userService;

    AddressServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public Address create(AddressDTO addressDto) {
        User user = userService.findById(addressDto.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + Long.valueOf(addressDto.getId())));

        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setNumber(addressDto.getNumber());
        address.setStreet(addressDto.getStreet());
        address.setZipcode(addressDto.getZipcode());
        user.setAddress(address);
        user = userService.create(user);
        return user.getAddress();
    }
}
