package com.example.inicial1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.example.inicial1.entities.Persona;
import java.io.Serializable;
import com.example.inicial1.entities.Base;

@NoRepositoryBean
public interface BaseRepository <E extends Base, Id extends Serializable> extends JpaRepository <E, Id> {
}
