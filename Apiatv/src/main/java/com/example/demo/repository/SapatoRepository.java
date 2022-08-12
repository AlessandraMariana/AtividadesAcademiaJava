package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Sapato;


@Repository
public interface SapatoRepository  extends CrudRepository<Sapato,Long>{

}
