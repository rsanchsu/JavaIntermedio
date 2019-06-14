package cfg;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;
import modelo.persistencia.DaoPeliculaArray;

//Esta clase es la que va a llever la configuracion de spring,
//podemos dar de atla aqui los objetos que vamas a utilizar en nuestra aplicacion
//o tambien podemos decir que busque anotaciones spring en nuestra aplicacion,
//dicho de otro modo esta clase busca sustituir el xml

@Configurable  
public class ConfiguracionSpring {
	

	//los objestos se van a dar de alta mediante metodos y etiquetas
	@Bean("directorBean") //esta seria la etiqueta, podemos dar un id especifico  
	@Scope ("prototype")
	public Director director() {  // esto seria el alta del metodo, por defecto el id es el nombre del metodo 
		Director director = new Director();
		director.setEdad(18);
		return director;
	}
	
	@Bean 
	@Scope ("prototype")
	//como autowire si existen mas de uno daria error, pero podriamos usar la etiqueta
	//@qualifier
	public Pelicula pelicula(@Qualifier("directorBean") Director director) {
		Pelicula p = new Pelicula();
		p.setDirector(director); 
//		p.setDirector(new Director()); // seria singelton ya que solo lo llama una vez 
//		p.setDirector(director());
		p.setTitulo("");
		return p;
	}

	@Bean
	public DaoPelicula daoPelicula() {
		DaoPeliculaArray daoPelicula = new DaoPeliculaArray();
		daoPelicula.setListaPelicula(new ArrayList<>());
		return daoPelicula;
	}
	@Bean
	public GestorPelicula gestorPelicula(DaoPelicula daoPelicula) {
		GestorPelicula gp =new GestorPelicula();
		gp.setDaoPelicula(daoPelicula);
		return gp;
	}
}
