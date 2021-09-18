package com.hitit.simpleproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    private String street;

    private int number;

    private String city;

    private int zipcode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
