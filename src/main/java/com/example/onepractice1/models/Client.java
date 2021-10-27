package com.example.onepractice1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;
    private String clientName;
    private String surname;
    private String email;
    private Address addressId;
    private List<Post> posts;

    public Client(Long id, String name, String surname, String email) {
        this.id = id;
        this.clientName = name;
        this.surname = surname;
        this.email = email;
    }
}
