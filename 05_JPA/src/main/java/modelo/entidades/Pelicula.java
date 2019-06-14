package modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//anotaciones para poder usar los jpa, para que la gestione como una entidad, 
//espera tener una entidad pelicula con los atributos titulo director genero
@Entity
@Table(name="peliculas")
@Component
@Scope("prototype")
public class Pelicula {
	@Id//con esto idenfificamos el primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="title",unique=true)//cambiamos el nombre del atributo 
	private String titulo;
	private String director;
	private String genero;
	private int year;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", year="
				+ year + "]";
	}
	


}
