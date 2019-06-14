package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public interface DaoPelicula {
	public boolean insertar(Pelicula p);
	public List<Pelicula> listar(); 

}
