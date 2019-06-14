package modelo.persintencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository 
public class DaoPeliculaJpa  implements DaoPelicula{

	@PersistenceContext //necesitamos una etiqueta de autoinyectado para este contexto de persisntencia
	private EntityManager em; //necesitamos el entity manager para que lance las queries 
	 
	@Override
	public int insertar(Pelicula p) {
		System.out.println(p.getId());
		em.persist(p); //el objeto que le pasamos tiene que tener la anotacion de entity
		System.out.println(p.getId());//como el id ya tiene valor, la cache lo sincroniza
		return p.getId();
	}

	@Override
	public Pelicula modificar(Pelicula p) {
		//merge se encarga de sincronizar la bbdd con el objeto, tb se puede usar para dar de alta, si no existe lo crea
		Pelicula p2 = em.merge(p);
		return p2;
	}

	@Override
	public Pelicula buscar(int id) {
		// si buscamos varias veces, el objeto se va a quedar cacheado y busca en la cache hasta
		// que se cierra el entity manager em 
		Pelicula p = em.find(Pelicula.class, id);
		return p;
	}

	@Override
	public int borrar(int id) {
		// con hibernate puro podemos borrar directamente el objeto de pasado a la base de datos 
		//pero jpa solo trabaja con objetos que esten dentro del contexto jpa
		//por lo que tenemos que meter el objeto que queremos borrar primero en la cache
		//primero lo buscamos para meterlo en la cache y despues ya lo podemos borrar
		Pelicula p = buscar(id); // al buscarlo lo estoy metiendo en la cache
		em.remove(p); // el objeto se queda en la cache asi que cuidado de no hacer despues un merge pq la darias de alta
		//el tiempo de vida de la cache es el ciclo de vida del entity manager
		return p.getId();
	}
	
	@Override
	public List<Pelicula> listar() {
		//para buscar una lista de peliculas tenemos que utilizar un lenguaje que se 
		//llama JPQL que es un mezcla de POO y SQL
		return em.createQuery("select p from Pelicula p").getResultList(); //no podemo poner peliculas ya em trabaja con objetos no con tablas
		
	}
	

}
