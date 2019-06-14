package modelo.persistencia;

import java.util.List;


import modelo.entidades.Pelicula;

public class DaoPeliculaArray  implements DaoPelicula{
//	private List<Pelicula> listaPelicula = new ArrayList<>(); 
	private List<Pelicula> listaPelicula; //con la interface da versatilidad asi puedo usar para 
	//lo que quiera, segun la implementacion, asi podemos cambiar 

@Override
public boolean insertar(Pelicula p) {
	// TODO Auto-generated method stub
	return listaPelicula.add(p);//vamos guardando peliculas 
}

@Override
public List<Pelicula> listar() {
	// TODO Auto-generated method stub
	return listaPelicula;//listamos
}

public List<Pelicula> getListaPelicula() {
	return listaPelicula;
}

public void setListaPelicula(List<Pelicula> listaPelicula) {
	this.listaPelicula = listaPelicula;
}


}
