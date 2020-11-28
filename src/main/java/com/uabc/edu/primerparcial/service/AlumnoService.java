package com.uabc.edu.primerparcial.service;

import com.uabc.edu.primerparcial.entity.Alumnos;

import java.util.List;

public interface AlumnoService {
    public boolean guardarAlumno(Alumnos al);
    public boolean editarAlumno(Alumnos al);
    public boolean eliminarAlumno(Integer id);
    public Alumnos buscarAlumno(Integer id);
    public List<Alumnos> obtenerAlumno();
}
