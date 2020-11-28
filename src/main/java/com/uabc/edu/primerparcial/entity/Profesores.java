package com.uabc.edu.primerparcial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PROFESORES")
@javax.persistence.SequenceGenerator(name = "profesoresSecuencia", sequenceName = "profesor_sec", allocationSize = 1, initialValue = 1)
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesoresSecuencia")
    private Integer id;
    private String nombre, apellido, direccion, correo;
    private Long telefono;

    public Profesores() {
    }

    public Profesores(Integer id, String nombre, String apellido, String direccion, String correo, Long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
}
