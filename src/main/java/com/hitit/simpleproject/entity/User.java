package com.hitit.simpleproject.entity;

import com.hitit.simpleproject.entity.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    private String name;


    private String email;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//!!!! LAZY oldu bilgi gelmedi
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDTO toUserDto() {
        return UserDTO.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .address(this.address)
                .build();
    }

}
