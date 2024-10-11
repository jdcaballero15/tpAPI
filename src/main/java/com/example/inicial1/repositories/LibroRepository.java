package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository  extends BaseRepository<Libro, Long> {
    //Sin paginacion

    List<Libro> findByTituloContaining(String titulo);


    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro%")
    List<Libro> search(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro%", nativeQuery = true)
    List<Libro> searchNativo(@Param("filtro") String filtro);

    //Con paginacion

    Page<Libro> findByTituloContaining(String Titulo, Pageable pageable);

    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro%")
    Page<Libro> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM libro",
            nativeQuery = true)
    Page<Libro> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
