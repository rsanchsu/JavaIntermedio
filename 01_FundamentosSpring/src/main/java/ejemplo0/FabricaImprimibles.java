package ejemplo0;

public class FabricaImprimibles {
	//patron de diseno, estamos reduciendo las dependencias, asi solo tendre que tocar la fabrica
	//fa
	public static Imprimible fabricar(String tipo) {
		switch (tipo) {
		case "fichero":
			return new ImprimirFichero();
		case "pantalla":
			return new ImprimirPantalla(); 
		default:
			return null;
		}
	}

}
