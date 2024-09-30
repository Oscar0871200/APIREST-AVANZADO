package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Audited
@Table(name = "libro")
public class Libro extends Base{

    @Column(name="titulo")
    private String titulo;

    @Column(name="feha")
    private int fecha;

    @Column(name="genero")
    private String genero;

    @Column(name="paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)//Si modifico un autor, el autor será modificado en libro tambien
    private List<Autor> autores;
}
