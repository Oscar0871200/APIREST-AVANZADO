package com.example.inicial1.entities;

import com.example.inicial1.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "autor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Audited
@Builder
public class Autor extends Base {

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="briografia", length = 1500)
    private String biografia;
}
