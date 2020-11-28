package com.uabc.edu.primerparcial.service;

import com.uabc.edu.primerparcial.entity.Intendentes;

import java.util.List;

public interface IntendenteService {

    public boolean guardarIntendente(Intendentes intend);
    public boolean editarIntendente(Intendentes intend);
    public boolean eliminarIntendente(Integer id);
    public Intendentes buscarIntendente(Integer id);
    public List<Intendentes> obtenerIntendente();
}
