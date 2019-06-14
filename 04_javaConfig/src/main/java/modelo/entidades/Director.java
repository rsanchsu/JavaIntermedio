package modelo.entidades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//en spring existen 4 estereotipos basicos de anotaciones para la creacion de objetos:
//@component, con esta anotacion estamos diciendo que esta clase sea gestionada por 
//spring, creara un objeto y le podremos dar un alcance
//y de esta heredan los otros 3  
//@Controller, igual que la padre pero representa un objeto controlador en el MVC
//@Service, igual que la padre pero representa un objeto de tipo de negocio, gestor, servicio
//@Repository, igual que la padre pero representa un objeto de acceso a datos o DAO

//esta anotacion es equivalente a lo siguiente
//<bean id="director" class="modelo.entidades.Director" scope="sigleton"/>


public class Director {
	private String nombre;
	
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString() {
		return "Director [nombre=" + nombre + ", edad=" + edad + "]";
	}
	

}
