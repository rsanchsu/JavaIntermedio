package ejemplo4;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class MainEjemplo4 {

		public static ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans4.xml");
		
		
	public static void main(String[] arg) {
		Persona p = context.getBean("persona", Persona.class);
		p.getDireccion().setCiudad("Sevilla");
		System.out.println(p);
		
		Persona p2 = context.getBean("persona2", Persona.class);
		//p2.getDireccion().setCiudad("Oviedo");//si ponemos esto saldria oviedo
		System.out.println(p2);//pone madrid pq es prototype si lo ponemos singelton saldra Sevilla
	}
} 
