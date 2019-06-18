package com.curso.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidades.Pelicula;
import com.curso.modelo.persitencia.DaoPelicula;

//@Controller
//@ResponseBody // la respuesta la vamos a mandar en el body
@RestController // esta engloba las dos anteriores, controlador que pasa por el super servlet
public class ControladorPeliculas {
	
	//iria el gestor pero como no lo tenemos porque es un ejemplo usamos 
	//directamente el dao
	
	@Autowired 
	private DaoPelicula daoPelicula;
	
	//para hacer un servicio rest tenemos que hacer los 5 pasos: 
	@GetMapping (path="peliculas",produces= {MediaType.APPLICATION_JSON_VALUE})
	//1.-mapeo de recursos a url 2.- verbo 3.- multiples representaciones 
	public ResponseEntity<List<Pelicula>> listarPeliculas() {
		List<Pelicula> lista = daoPelicula.findAll();
		ResponseEntity<List<Pelicula>> re = new ResponseEntity<>(lista,HttpStatus.OK);
		//4.-basado codigos de respuesta, si el recurso exite le devolvemos el ok un 200
		return re;
		//5.-uso de cabeceras
	}
	@PostMapping(path="peliculas",consumes= {MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity<Integer> altaPelicula(@RequestBody Pelicula pelicula){
		Pelicula peliculaCreada = daoPelicula.save(pelicula);
		return new ResponseEntity<>(peliculaCreada.getId(),HttpStatus.CREATED);
		
	}
	
	@GetMapping(path="peliculas/{id}")
	public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable("id")Integer id){
		Optional<Pelicula> oPelicula = daoPelicula.findById(id); //los optinal nacen para evitar los null
		if(oPelicula.isPresent()) {
			Pelicula p = oPelicula.get();
			return new ResponseEntity<Pelicula>(p, HttpStatus.OK);
		}else {
			
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);

	}	
	}
		
		@PutMapping(path="peliculas/{id}") 
		public ResponseEntity<Pelicula> modificarPelicula(@RequestBody Pelicula pelicula, 
											@PathVariable("id") Integer id){
			pelicula.setId(id);
			Pelicula peliculaAux = daoPelicula.save(pelicula);
		
			return new ResponseEntity<Pelicula>(peliculaAux,HttpStatus.OK);
		}

		
		@DeleteMapping(path="peliculas/{id}") 
		public ResponseEntity<Void> metodoVamosAComer(@PathVariable("id") Integer id) {
		daoPelicula.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
}
