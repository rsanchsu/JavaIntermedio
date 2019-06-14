package ejemplo2;

import java.io.File;
import java.io.PrintWriter;

public class ImprimirFichero implements Imprimible{
	
	public void imprimir(String cadena) {
		File file = new File("fichero.txt"); 
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file); 
			pw.append(cadena);
		}catch(Exception e) {
			e.printStackTrace();//muestra la excepcion por pantalla
		}finally {
			//este bloque siempre se va a ejecutar, no importa si ha habido 
			//excepcion o no
			pw.close();
		}
		
	}
}
