package com.hitit.simpleproject.entity.DTO;


import com.hitit.simpleproject.entity.Address;
import com.hitit.simpleproject.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class UserDTO {
    private long id;

    private String name;

    private String email;
    private Address address;

    public User toUser() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .address(this.address)
                .build();
    }
    public UserDTO(long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public UserDTO(String name, String email) {

        this.name = name;
        this.email = email;

    }
}