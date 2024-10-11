package com.example.inicial1.repositories;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    //Sin paginacion

    List<Domicilio> findByCalleContaining(String calle);


    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro%")
    List<Domicilio> search(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:filtro%", nativeQuery = true)
    List<Domicilio> searchNativo(@Param("filtro") String filtro);

    //Con paginacion

    Page<Domicilio> findByCalleContaining(String calle, Pageable pageable);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro%")
    Page<Domicilio> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true)
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
