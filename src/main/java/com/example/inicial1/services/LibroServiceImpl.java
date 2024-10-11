package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Libro> search(String filtro) throws Exception {
        try {
            // List<Libro> libros = libroRepository.findByTituloContaining(filtro);
            List<Libro> libros = libroRepository.search(filtro);
            // List<Libro> libros = libroRepository.searchNativo(filtro);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Libro> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Page<Libro> libros = libroRepository.findByTituloContaining(filtro, pageable);
            Page<Libro> libros = libroRepository.search(filtro, pageable);
            // Page<Libro> libros = libroRepository.searchNativo(filtro, pageable);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
