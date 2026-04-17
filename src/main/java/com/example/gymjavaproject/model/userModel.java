package com.example.gymjavaproject.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "usuario")
public class userModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(updatable = false, nullable = false, length = 150, unique = true)
    private String id;

    @Column(updatable = false, nullable = false, length = 2)
    private String tipoDocumento;

    @Column(updatable = false, nullable = false, length = 10)
    private int numeroDocumento;

    @Column ( nullable = false, length = 150)
    private String primerNombre;

    @Column(nullable = false, length = 150)
    private String segundoNombre;

    @Column ( nullable = false, length = 150)
    private String primerApellido;

    @Column(nullable = false, length = 150)
    private String segundoApellido;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false, length = 150)
    private String ciudad;

    @Column (nullable = false, length = 100)
    private float peso;

    @Column(nullable = false)
    private Boolean mensualidad;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
    private rolesModel rol;

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();


}
