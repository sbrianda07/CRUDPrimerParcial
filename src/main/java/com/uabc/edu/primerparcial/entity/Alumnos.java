package com.uabc.edu.primerparcial.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ALUMNOS")
@javax.persistence.SequenceGenerator(name = "alumnosSecuencia", sequenceName = "alumnos_sec", allocationSize = 1, initialValue = 1)
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumnosSecuencia")
    private Integer id;
    private String nombre, apellido, direccion, correo;
    private Long telefono;

    public Alumnos() {
    }

    public Alumnos(Integer id, String nombre, String apellido, String direccion, String correo, Long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
}
