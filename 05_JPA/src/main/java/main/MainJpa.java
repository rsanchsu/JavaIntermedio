package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainJpa {
	
	public static ApplicationContext context = 
			new AnnotationConfigApplicationContext(Configuracion.class);
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("La guerra de las galaxias");
		p.setDirector("George Lucas");
		p.setGenero("sci-fi");
		p.setYear(1979);
				
		GestorPelicula gp = context.getBean("gestorPelicula", GestorPelicula.class);
		int id =gp.insertar(p); //insertamos 
		System.out.println("id creado:" + id);

		p.setTitulo("El imperio contrapaca");
		gp.modificar(p);
		System.out.println("-----1");
				
		System.out.println(gp.listar());
		
		
		/* asi nos modifica y como no hemos leido ni informado el resto de campos no lo deja a null
		Pelicula p2 =new Pelicula(); 
		p2.setId(1); 
		p2.setTitulo("El retorno del jedi"); */
		
		Pelicula p2 = gp.buscar(1); 
		System.out.println(p2);
		p2.setTitulo("El retorno del jedi"); //creamos uno nuevo, solo informamos un campo el resto va con os
		System.out.println("-----2");
		gp.modificar(p2);
		
		System.out.println(gp.listar());
	}

}
