package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{
    List<Domicilio> search(String filtro) throws Exception;
    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
