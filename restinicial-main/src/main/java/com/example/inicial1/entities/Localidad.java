package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Audited
@Builder
@Table(name = "localidad")
public class Localidad extends Base{

    @Column(name="denominacion")
    private String denominacion;
}
