package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.curso.modelo.entidades.Pelicula;
import com.curso.modelo.persitencia.DaoPelicula;

/*
 * Esta anotacion engloba tres anotaciones spring
 * @Configuration con esta anotacion decimos que en esta clase puede haber metodos 
 * anotados con @Bean
 * @ComponentScan, buscamos anotaciones spring,automaticamente un proyecto spring bott 
 * va a buscar anotociones spring dentro de este paquete y subpaquetes.
 * @EnableAutoConfiguration, decimos a spring que queremos arrancar la aplicacion 
 * anadiendo al contexto de spring todoso los beans que crea oportunos para que nuestra 
 * aplicacion funcione y que esten tambien las clases en nuestro classpath.
 */
@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		DaoPelicula daoPelicula = context.getBean("daoPelicula",DaoPelicula.class);
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		
		p.setDirector("Bruce Willys");
		p.setTitulo("La jungla de cristal2");
		p.setGenero("accion");
		p.setYear(1990);
		
		//daoPelicula.save(p);
		
		System.out.println(daoPelicula.findById(1)); 
		System.out.println(daoPelicula.findAll());
		System.out.println("----------");
		System.out.println(daoPelicula.findByTituloContainingIgnoreCase("la jungla"));
		
		System.out.println("-------------------------------");
		Pelicula p2 = context.getBean("peliculaBean", Pelicula.class);
		
	}

}
