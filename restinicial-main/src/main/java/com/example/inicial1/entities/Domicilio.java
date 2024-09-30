package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Audited
@Table(name = "domicilio")
public class Domicilio extends Base{

    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private int numero;

    @ManyToOne (optional = true)//siempre que creemos un domicilio, debe tener una localidad
    @JoinColumn (name = "fk_localidad")
    private Localidad localidad;

}
