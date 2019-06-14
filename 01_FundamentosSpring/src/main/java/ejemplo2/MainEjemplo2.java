package ejemplo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEjemplo2 {

		public static ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans2.xml");
		
		public static void main(String[] args) {
			Imprimible i = context.getBean("imprimible", Imprimible.class);
			i.imprimir("Imprimiendo en un programa spring!!!!");
	}
}
