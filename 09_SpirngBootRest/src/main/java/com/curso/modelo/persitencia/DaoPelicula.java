package com.curso.modelo.persitencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.entidades.Pelicula;

//con esto implementamos todos los accesos a base de datos em.merge, en.persit....
//Pelicula seria la entidad a mapear contra la bbdd y integer seria el tipo de la pk
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{
	
	//queremos buscar un titulo
	//jpa data es convencion frente a configuracion e implementacion
	public List<Pelicula> findByTitulo(String titulo);
	public List<Pelicula> findByTituloAndGenero(String titulo, String genero);
	
	public List<Pelicula> findByTituloOrGenero(String titulo, String genero);
	public List<Pelicula> findAllByOrderByTituloAsc();
	
	public List<Pelicula> findByTituloContaining(String titulo);
	public List<Pelicula> findByTituloAndGeneroContaining(String titulo, String genero);
	public List<Pelicula> findByTituloIgnoreCase(String titulo);
	public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
	
	@Query("select p from Pelicula p where p.genero=?1")//JPQL
	public List<Pelicula> findByMovidaDeLaMuerta(String genero);
	
	
}
