package com.uabc.edu.primerparcial.repository;

import com.uabc.edu.primerparcial.entity.Intendentes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntendenteRepository extends CrudRepository<Intendentes,Integer> {
}
