package com.example.gymjavaproject.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class rolesModelDto {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(updatable = false, nullable = false, length = 150, unique = true)
    private String id;

    @Column(nullable = false, length = 150)
    private String nombreRol;   

}
