package modelo.negocio;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Pelicula;
import modelo.persintencia.DaoPelicula;

	@Service
public class GestorPelicula {
	@Autowired	
	private DaoPelicula daoPelicula;
	
	@Transactional //cuando entra por este medoto abre una transaccion porque vamos a modificar 
	public int insertar(Pelicula p) {
		return daoPelicula.insertar(p);
		
		
	}
	@Transactional //cuando entra por este medoto abre una transaccion porque vamos a modificar
	public Pelicula modificar(Pelicula p) {
		return daoPelicula.modificar(p);
	}
	@Transactional //cuando entra por este medoto abre una transaccion porque vamos a modificar
	public int borrar(int id) {
		return daoPelicula.borrar(id); 
	}
		
	public Pelicula buscar(int id) {
		return daoPelicula.buscar(id);
		
	}
	public List<Pelicula> listar() {
		return daoPelicula.listar(); 
	}
	
	
}
