package com.uabc.edu.primerparcial.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "INTENDENTES")
@javax.persistence.SequenceGenerator(name = "intendentesSecuencia", sequenceName = "intendentes_sec", allocationSize = 1, initialValue = 1)
public class Intendentes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intendentesSecuencia")
    private Integer id;
    private String nombre, apellido, direccion;
    private Long telefono;

    public Intendentes() {
    }

    public Intendentes(Integer id, String nombre, String apellido, String direccion, Long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
