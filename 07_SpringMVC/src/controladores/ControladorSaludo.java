package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.Usuario;

//Spring se base en POJOs plain old java object, es una clase sencilla que no tiene herencia

@Controller
public class ControladorSaludo {
	
	@Autowired
	private Usuario usuarioSession;
	
    //el valor devuelto va a ser procesado por el ViewResolver para buscar la paquina que 
	//queramos 
	@RequestMapping("verFormulario") //las peticiones de verFormulario las redirecciona aqui
	public String verFormularioSaludo() {
		//aqui ya podemos invocar gestores o lo que necesitemos
		return "formularioSaludo";
		
	}
	
	//creamos otro metodo, spring mediante refection y la inyeccion de dependencias 
	//puede identificar los parametros de entrada de nuestro metodo y en funcion 
	//de dichos parametros de entradad inyectar el objeto que necesites, es decir,
	//en procesar saludo parametros de entrada no tengo ninguno pero spring en funcion 
	//de las dependencias lo inyecta
	@RequestMapping(name="saludo",method=RequestMethod.GET)
	public ModelAndView procesarSaludo(HttpServletRequest httpRequest,
					HttpSession httpSession,
					ModelAndView mav,
					@RequestParam("nombre") String nombre) {
		//String nombre1 = HttpRequest.getParameter("nombre");
		System.out.println(nombre);
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEdad(18);
		
		usuarioSession.setNombre(nombre);
		usuarioSession.setEdad(18);
		
		
		mav.setViewName("verSaludo");
		mav.addObject("usuarioObj", usuario); //le manda esto para que el jsp pueda acceder
		mav.addObject("usuarioSession", usuarioSession); //este no hace falta crearlo con el new
		return mav;
		
	}
	
	 // 
		@RequestMapping("verSaludo2") //las peticiones de verFormulario las redirecciona aqui
		public ModelAndView verSaludo2() {
			//aqui ya podemos invocar gestores o lo que necesitemos
			ModelAndView mav = new ModelAndView(); 
			mav.setViewName("verSaludo2");
			mav.addObject("usuarioSession", usuarioSession);
			return mav;
			
		}
}
