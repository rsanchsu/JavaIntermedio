package ejemplo3;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class MainEjemplo3 {

		public static ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans3.xml");
		
		
	public static void main(String[] arg) {
		List<Persona> listaPersonas = context.getBean("listaPersonas",List.class);
				System.out.println(listaPersonas); 
				
		List<String> listaNombre = context.getBean("listaPersonas",List.class); 
		System.out.println(listaNombre);
		
		HashMap<String, String> mapaCadenas = new HashMap<>();
		mapaCadenas.put("1234", "felix"); 
		mapaCadenas.put("qwerty", "marcos"); 
	 
		System.out.println(mapaCadenas.get("qwerty"));//marcos
		System.out.println(mapaCadenas.get("4321"));//null
		mapaCadenas.put("1234", "ana");//ana
		System.out.println(mapaCadenas.get("1234"));//ahora nos muestra ana 
		
		//obtenemos el mapa 
		HashMap<String, Persona> mapaPersonas = context.getBean("mapaPersonas", HashMap.class);
		System.out.println(mapaPersonas.get("1234"));
		
	}
} 
