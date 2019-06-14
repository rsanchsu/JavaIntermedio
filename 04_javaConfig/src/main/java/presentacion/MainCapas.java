package presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cfg.ConfiguracionSpring;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainCapas {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
	
	public static void main(String[] args) {
		// ejemplo por xml
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("La guerra de las galaxias");
		p.getDirector().setNombre("George Lucas");
		p.setGenero("sci-fi");
		p.setYear(1979);
				
				
		GestorPelicula gp = context.getBean("gestorPelicula",GestorPelicula.class);
		gp.insertar(p);//estamos anadiendo peliculas 
			
		System.out.println(gp.listar());
	}
	
	

}
