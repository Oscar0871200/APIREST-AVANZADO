package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PersonaServices extends BaseService<Persona, Long> {

    List<Persona> search(String filtro) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
