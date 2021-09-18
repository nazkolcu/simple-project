package com.hitit.simpleproject.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private long id;

    private String street;
    private int number;
    private String city;
    private int zipcode;
}
