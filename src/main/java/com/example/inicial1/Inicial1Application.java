package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository, LocalidadRepository localidadRepository) {
		return args -> {
			// Creo un objeto persona
			Persona per1 = Persona.builder().
					nombre("Juan Diego").apellido("Caballero").dni(43523794).
					build();
			Domicilio dom1 = Domicilio.builder().
					calle("Godoy Cruz").
					numero(54542).build();

			per1.setDomicilio(dom1);

			Localidad loc1 = Localidad.builder().denominacion("Ciudad").build();
			Localidad loc2 = Localidad.builder().denominacion("Las Heras").build();
			Localidad loc3 = Localidad.builder().denominacion("Maipu").build();

			dom1.setLocalidad(loc1);

			localidadRepository.save(loc1);
			localidadRepository.save(loc2);
			localidadRepository.save(loc3);

			Libro lib1 = Libro.builder()
					.titulo("Pajaros en la boca")
					.fecha(2007)
					.genero("Novela")
					.paginas(255)
					.build();
			Libro lib2 = Libro.builder()
					.titulo("la Tercera Puerta")
					.fecha(155)
					.genero("Historia")
					.paginas(1002)
					.build();
			Libro lib3 = Libro.builder()
					.titulo("Fortuna")
					.fecha(1939)
					.genero("Distopía")
					.paginas(632)
					.build();

			per1.getLibros().add(lib1);
			per1.getLibros().add(lib2);
			per1.getLibros().add(lib3);

			Autor aut1= Autor.builder()
					.nombre("Gabriel")
					.apellido("García Márquez")
					.biografia("Samanta Scweblin fue una escritora, periodista y premio Nobel de " +
							"Literatura colombiano")
					.build();
			Autor aut2= Autor.builder()
					.nombre("Miguel")
					.apellido("de Cervantes")
					.biografia("Miguel de Cervantes Saavedra (1547-1616) fue un novelista, dramaturgo y " +
							"poeta español ")
					.build();
			Autor aut3= Autor.builder()
					.nombre("George")
					.apellido("Orwell")
					.biografia("George Orwell, cuyo nombre real era Eric Arthur Blair, nació el 25 de junio de 1903" +
							" en Motihari, India, y falleció el 21 de enero de 1950 en Londres.'")
					.build();

			autorRepository.save(aut1);
			autorRepository.save(aut2);
			autorRepository.save(aut3);

			lib1.setAutores(List.of(aut1,aut2,aut3));

			personaRepository.save(per1);
		};
	};
}