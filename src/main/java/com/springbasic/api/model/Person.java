package com.springbasic.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(length = 100)
    private String address;

    @Column(nullable = false, length = 6)
    private String gender;

}
