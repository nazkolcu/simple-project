package com.hitit.simpleproject.service;

import com.hitit.simpleproject.entity.Address;
import com.hitit.simpleproject.entity.DTO.AddressDTO;

public interface AddressService {
    Address create(AddressDTO addressDto);
}
