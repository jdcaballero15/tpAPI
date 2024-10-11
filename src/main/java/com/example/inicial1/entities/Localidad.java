package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "localidad")
@Audited
public class Localidad extends Base {

    @Column(name = "Denominacion")
    private String denominacion;
}
