package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.DaoPelicula;


public class GestorPelicula {
	
	
	private DaoPelicula daoPelicula; //lo hacemos por interface
	
	public boolean insertar(Pelicula p) {
	//	return daoPelicula.insertar(p); inseta sin reglas 
		if("".equals(p.getTitulo())) {
			return false;
		}
			return daoPelicula.insertar(p);
	}
	
	public List<Pelicula> listar(){
			return daoPelicula.listar();
	}

	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}

}
