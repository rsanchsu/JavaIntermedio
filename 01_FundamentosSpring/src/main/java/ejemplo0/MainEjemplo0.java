package ejemplo0;

public class MainEjemplo0 {
	public static void main(String[] args) {
		String opcion = args[0];  
		Imprimible ip = null;
		/* esto seria sin el patron de diseno 
		if(opcion.equals("0")) {
		//	ImprimirPantalla ip = new ImprimirPantalla(); // sin tener definida la interface
			ip = new ImprimirPantalla(); // con la interface definida, asi no trabajamos 
		//con referencias concretas
		//para no tener que tocar todos los ficheros donde estan los new, inventaron 
		//el patron fabrica, es una clase que se va a encargar de crar los objetos
			ip.imprimir("Cualquier cosa!!!!!");
			
		}else {
		//	ImprimirFichero ifi = new ImprimirFichero();
			ip = new ImprimirFichero();
			ip.imprimir("Cualquier cosa por fichero!!!!!");
		}*/
		// utilizando el patron de diseno y las interfaces, es mucho mas sencillo 
		//la creacion del objeto viene de FabricaImprimbles
		ip = FabricaImprimibles.fabricar(opcion);//run as, run configurations,  arguments= pantalla 
		 
		//hago cosas.....
		funcion(ip);
	}
	public static void funcion(Imprimible ifi) {
		ifi.imprimir("Otro valor"); 
	}
}
