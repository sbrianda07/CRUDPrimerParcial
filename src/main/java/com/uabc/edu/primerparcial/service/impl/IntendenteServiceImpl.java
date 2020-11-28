package com.uabc.edu.primerparcial.service.impl;

import com.uabc.edu.primerparcial.entity.Intendentes;
import com.uabc.edu.primerparcial.repository.IntendenteRepository;
import com.uabc.edu.primerparcial.service.IntendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IntendenteServiceImpl implements IntendenteService {
    @Autowired
    IntendenteRepository repo;

    @Override
    public boolean guardarIntendente(Intendentes intend) {
        try {
            repo.save(intend);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editarIntendente(Intendentes intend) {
        try {
            repo.save(intend);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarIntendente(Integer id) {
        try{
            repo.deleteById(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Intendentes> obtenerIntendente() {
        //Convertir Iterador a Lista
        Iterable<Intendentes> ite=repo.findAll();
        Iterator<Intendentes> it=ite.iterator();
        List<Intendentes> actualList = new ArrayList<Intendentes>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }
    @Override
    public Intendentes buscarIntendente(Integer id) {
        List<Intendentes> list = obtenerIntendente();
        Intendentes inten = new Intendentes();
        inten = list.get(id-1);

        return inten;
    }
}
