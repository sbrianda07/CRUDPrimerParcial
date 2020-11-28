package com.uabc.edu.primerparcial.repository;

import com.uabc.edu.primerparcial.entity.Alumnos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumnos,Integer> {
}
