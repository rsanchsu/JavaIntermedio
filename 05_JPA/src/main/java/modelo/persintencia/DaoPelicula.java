package modelo.persintencia;

import java.util.List;

import modelo.entidades.Pelicula;

public interface DaoPelicula {
	/**
	 * Documentacion del metodo 
	 * metodo que persiste un pelicula
	 * @param p la pelicula que vamos a persistir 
	 * @return el id de la pelicula que hemos dado de alta 
	 *
	 */
	public int insertar(Pelicula p);
	
	/**
	 * 
	 * @param p la pelicula que queremos modificar 
	 * @return la pelicula modificada
	 */
	public Pelicula modificar(Pelicula p);
	
	public Pelicula buscar(int id);
	
	public int borrar(int id);
	
	public List<Pelicula> listar();

}
