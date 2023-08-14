package com.example.Firstapi.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter //Sustituye a los setters (Usando Lombok)
@Getter
@Entity
@Table(name="users")
public class CUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;

    public CUser() {
    }

    public CUser(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

}
