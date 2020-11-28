package com.uabc.edu.primerparcial.service.impl;

import com.uabc.edu.primerparcial.entity.Alumnos;
import com.uabc.edu.primerparcial.repository.AlumnoRepository;
import com.uabc.edu.primerparcial.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository repo;

    @Override
    public boolean guardarAlumno(Alumnos al) {
        try {
            repo.save(al);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editarAlumno(Alumnos al) {
        try {
            repo.save(al);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarAlumno(Integer id) {
        try{
            repo.deleteById(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Alumnos> obtenerAlumno() {
        //Convertir Iterador a Lista
        Iterable<Alumnos> ite=repo.findAll();
        Iterator<Alumnos> it=ite.iterator();
        List<Alumnos> actualList = new ArrayList<Alumnos>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }

    @Override
    public Alumnos buscarAlumno(Integer rfc) {
        List<Alumnos> list = obtenerAlumno();
        Alumnos alu = new Alumnos();
        alu = list.get(rfc-1);

        return alu;
    }
}
