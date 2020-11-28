package com.uabc.edu.primerparcial.service;

import com.uabc.edu.primerparcial.entity.Profesores;

import java.util.List;

public interface ProfesorService {
    public boolean guardarProfesor(Profesores prof);
    public boolean editarProfesor(Profesores prof);
    public boolean eliminarProfesor(Integer id);
    public List<Profesores> obtenerProfesor();
    public Profesores buscarProfesor(Integer id);
}
