package com.uabc.edu.primerparcial.service.impl;

import com.uabc.edu.primerparcial.entity.Profesores;
import com.uabc.edu.primerparcial.repository.ProfesorRepository;
import com.uabc.edu.primerparcial.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repo;

    @Override
    public boolean guardarProfesor(Profesores prof) {
        try {
            repo.save(prof);
        } catch (Exception e){
            return false;
        }
        return true;
    }


    @Override
    public boolean editarProfesor(Profesores prof) {
        try {
            repo.save(prof);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarProfesor(Integer id) {
        try{
            repo.deleteById(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Profesores> obtenerProfesor() {
        //Convertir Iterador a Lista
        Iterable<Profesores> ite=repo.findAll();
        Iterator<Profesores> it=ite.iterator();
        List<Profesores> actualList = new ArrayList<Profesores>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }
    @Override
    public Profesores buscarProfesor(Integer id) {
        List<Profesores> list = obtenerProfesor();
        Profesores pro = new Profesores();
        pro = list.get(id-1);

        return pro;
    }
}
