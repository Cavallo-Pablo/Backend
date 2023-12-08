package com.crud.apiRest.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}

