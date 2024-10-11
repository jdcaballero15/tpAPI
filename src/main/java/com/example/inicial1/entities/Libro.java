package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "libro")
@Audited

public class Libro extends Base {

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha;

    @Column(name = "gemero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;



    @ManyToMany(cascade = {CascadeType.REFRESH})
    private List<Autor> autores = new ArrayList<>();
}
