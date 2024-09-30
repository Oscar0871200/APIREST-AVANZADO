package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.inicial1.entities.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {

    private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Inicial1Application.class, args);
        System.out.println("funcionando");
    }

    @Bean
    @Transactional
    CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository) {
        return args -> {

            Localidad localidad1 = Localidad.builder()
                    .denominacion("Godoy Cruz")
                    .build();

            Localidad localidad2 = Localidad.builder()
                    .denominacion("Luján de Cuyo")
                    .build();

            Localidad localidad3 = Localidad.builder()
                    .denominacion("Ciudad de Mendoza")
                    .build();
            localidadRepository.save(localidad1);
            localidadRepository.save(localidad2);
            localidadRepository.save(localidad3);

            Autor autor1 = Autor.builder()
                    .nombre("Jorge Luis")
                    .apellido("Borges")
                    .biografia("Escritor argentino nacido en Buenos Aires, famoso por sus obras de ficción.")
                    .build();

            Autor autor2 = Autor.builder()
                    .nombre("Julio")
                    .apellido("Cortázar")
                    .biografia("Escritor argentino, autor de 'Rayuela' y otros relatos cortos.")
                    .build();

            Autor autor3 = Autor.builder()
                    .nombre("Adolfo")
                    .apellido("Bioy Casares")
                    .biografia("Escritor y guionista argentino, colaborador frecuente de Borges.")
                    .build();

            autorRepository.save(autor1);
            autorRepository.save(autor2);
            autorRepository.save(autor3);

            Libro libro1 = Libro.builder()
                    .titulo("Ficciones")
                    .fecha(1944)
                    .genero("Cuentos")
                    .paginas(174)
                    .autores(Arrays.asList(autor1)) // Asocio con el autor
                    .build();

            Libro libro2 = Libro.builder()
                    .titulo("Rayuela")
                    .fecha(1963)
                    .genero("Novela")
                    .paginas(600)
                    .autores(Arrays.asList(autor2))
                    .build();

            Libro libro3 = Libro.builder()
                    .titulo("La invención de Morel")
                    .fecha(1940)
                    .genero("Ciencia ficción")
                    .paginas(120)
                    .autores(Arrays.asList(autor3))
                    .build();

            Persona per1 = Persona.builder()
                    .nombre("Alberto")
                    .apellido("Cortez")
                    .dni(123)
                    .libro(new ArrayList<>()) //Para la lista de Libros
                    .build();
            Domicilio dom1 = Domicilio.builder()
                    .calle("Suipacha")
                    .numero(239)
                    .localidad(localidad1)
                    .build();
            per1.setDomicilio(dom1);
            per1.getLibro().add(libro1); // Añado el libro
            personaRepository.save(per1);

            // Persona 2
            Persona per2 = Persona.builder()
                    .nombre("Alicia")
                    .apellido("Calderon")
                    .dni(768)
                    .libro(new ArrayList<>())
                    .build();
            Domicilio dom2 = Domicilio.builder()
                    .calle("Lulunta")
                    .numero(339)
                    .localidad(localidad2)
                    .build();

            per2.setDomicilio(dom2);
            per2.getLibro().add(libro2);

            // Lo grabo a través del repositorio de Spring
            personaRepository.save(per2);

            Persona per3 = Persona.builder()
                    .nombre("Carlos")
                    .apellido("González")
                    .dni(278)
                    .libro(new ArrayList<>())
                    .build();
            Domicilio dom3 = Domicilio.builder()
                    .calle("Rodríguez Peña")
                    .numero(123)
                    .localidad(localidad3)
                    .build();
            per3.setDomicilio(dom3);
            per3.getLibro().add(libro3);
            personaRepository.save(per3);

            // Recupero todas las personas
            List<Persona> recuperadas = personaRepository.findAll();
            System.out.println(recuperadas);
            logger.info("Detalles de las personas: {}", recuperadas);

            // Recupero una persona por ID
            Optional<Persona> recuperada = personaRepository.findById(1L);
            System.out.println(recuperada);
            logger.info("Detalles de la persona recuperada: {}", recuperada);

            // Actualizo el domicilio de la primera persona
            dom1.setCalle("Rodriguezaaaa");
            personaRepository.save(per1);
        };
    }
}