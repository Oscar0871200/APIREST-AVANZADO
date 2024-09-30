package com.example.inicial1.services;
import com.example.inicial1.entities.Persona;

import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicesImpl extends BaseServiceImpl<Persona, Long> implements PersonaServices{

    @Autowired//Acceder a metodos
    private PersonaRepository personaRepository;

    public PersonaServicesImpl(BaseRepository <Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {

            //Codigo manual dificil de mantener
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //Query JPA
            //List<Persona> personas = personaRepository.search(filtro);

            //SQL
            List<Persona> personas = personaRepository.searchNativo(filtro);

            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {

            //Codigo manual dificil de mantener
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);

            //Query JPA
            //Page<Persona> personas = personaRepository.search(filtro, pageable);

            //SQL
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
