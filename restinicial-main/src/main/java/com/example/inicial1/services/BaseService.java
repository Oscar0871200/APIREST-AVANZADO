package com.example.inicial1.services;
import com.example.inicial1.entities.Base;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, Id extends Serializable> {
    public List<E> findAll() throws Exception;
    //Nos trae una lista de las personas

    public Page<E> findAll(Pageable pageable) throws Exception;
    //Devuele los datos paginados, un page en vez de List

    public E findById(Id id) throws Exception;
    //Obtenien una persona según su ID

    public E save(E entity) throws Exception;
    //Guarda una entidad que enviamos

    public E update(Id id, E entity) throws Exception;
    //Actualiza la persona del Id

    public boolean delete (Id id) throws Exception;
    //Borra según el Id de la BD

}
