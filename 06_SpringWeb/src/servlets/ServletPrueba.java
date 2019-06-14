package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

//Jersey implementacion por defecto oficial de java de rest
@WebServlet("/ServletPrueba") //etiqueta jee porque es del paquete javax., etiqueta Ioc
//de jee, el contenedor del servidor de aplicaciones lleva el cilco de vida de este 
//objeto que sera singleton, solo podemos tener uno 
//la url para acceder seria http://localhost:8080/06_SpringWeb/ServletPrueba
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L; //esta es la version de la clase
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//verbos que soporta son el get, post, put, delete, html solo soporta get(Solicitar recuero) y post (para el resto)
		System.out.println("Entrando por el doGet");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nombre = request.getParameter("nombre");
		System.out.println("hola " + nombre);
		
		if(nombre != null)
			//para crear una sesion 
			request.getSession().setAttribute("nombreSession", nombre);

			
		//aqui irian las posibles llamadas al gestor 
		RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
	
		//mandamos datos, por un lado tenemo parametros (que son string) y por otro atributos (pueden ser cualquier tipo lista, objeto) 
		request.setAttribute("atributoNombre", nombre); 
		rd.forward(request, response); //vete a un jsp que se llame principal 
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando por el doPost");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doGet(request, response);
	}

}
