package ejemplo1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEjemplo1 {
	
	public static ApplicationContext context = 
			new ClassPathXmlApplicationContext("beans1.xml");
	
		public static void main(String[] args) { 
			Persona p1 = (Persona)context.getBean("personaSingleton"); 
			Persona p2 = context.getBean("personaPrototype",Persona.class); 
			
			p1.setNombre("Arturo");
			p1.setEdad(45);
			
			p2.setNombre("Ana");
			p2.setEdad(34);
			System.out.println(p2);
			
			List<Persona> listaPersonas = context.getBean("listaPersonas",List.class);
			listaPersonas.add(p2);//creo una referencia para que no se muera, crea un en vacio 
			
			
			metodo();
			System.out.println("hola"); 
			System.out.println(listaPersonas);//nos pinta a ana y despues la que hemos anadido con add en vacio
			Persona p3 = context.getBean("personaSingleton2",Persona.class); 
			System.out.println(p3);
			
			int i = 0245;
			System.out.println(i);
			//p3.getDireccion().set
			p3 = context.getBean("personaSingleton3",Persona.class);
			System.out.println(p3);
			
			p3 = context.getBean("personaSingleton4",Persona.class);
			System.out.println(p3);
		}

		private static void metodo() {
			// como el objeto es unico p1 si que toma los valores
			Persona p1 = (Persona)context.getBean("personaSingleton"); 
			System.out.println(p1);
			Persona p2 = context.getBean("personaPrototype",Persona.class); 
			System.out.println(p2);//nos pinta todo a null y 0, ya que crea otro es una copia, el objeto es nuevo 
			//y cuando salga del metodo el p2 desaparece
			List<Persona> listaPersonas = context.getBean("listaPersonas",List.class);
			listaPersonas.add(p2);//creo una referencia para que no se muera 
			
		}

}
