package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.entidades.Pelicula;

//Pelicula la entidad a mpaear contra la bbdd y Integer seria el tipo de la PK
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{
		
		//jpa data es convencion frente a configuracion e impletancion
		public List<Pelicula> findByTitulo(String titulo);
		public List<Pelicula> findByTituloAndGenero(String titulo, String genero);
		
		public List<Pelicula> findByTituloOrGenero(String titulo, String genero);
		public List<Pelicula> findAllByOrderByTituloAsc();
		
		public List<Pelicula> findByTituloContaining(String titulo);
		public List<Pelicula> findByTituloAndGeneroContaining(String titulo, String genero);
		
		public List<Pelicula> findByTituloIgnoreCase(String tiutlo);
		public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
		
		@Query("select p from Pelicula p where p.genero=?1")//JPQL
		public List<Pelicula> findByMovidaDeLaMuerta(String genero);
}
