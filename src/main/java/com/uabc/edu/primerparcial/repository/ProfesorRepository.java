package com.uabc.edu.primerparcial.repository;

import com.uabc.edu.primerparcial.entity.Profesores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesores,Integer>  {
}
