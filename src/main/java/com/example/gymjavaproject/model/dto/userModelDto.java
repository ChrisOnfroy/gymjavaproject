package com.example.gymjavaproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userModelDto {

    private String id;

    private String tipoDocumento;

    private int numeroDocumento;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String direccion;

    private String ciudad;

    private float peso;

    private Boolean mensualidad;

    private String email;


}
