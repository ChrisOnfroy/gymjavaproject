package com.example.gymjavaproject.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class rolesModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(updatable = false, nullable = false, length = 150, unique = true)
    private String id;

    @Column(nullable = false, length = 150)
    private String nombreRol;

    @Column(length = 250)
    private String despcripcion;

    @OneToMany(mappedBy = "rol")
    private List<userModel> user;

}
