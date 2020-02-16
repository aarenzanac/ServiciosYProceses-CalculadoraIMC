package calculadoraIMC;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import pideDatos.PideDatos;

public class Principal {
	
	private static final String rutaProyecto = System.getProperty("user.dir");
    private static final String separador = File.separator;
    private static final String directorio = "src" + separador + "calculadoraIMC";
    private static final String rutaActividad = rutaProyecto + separador + directorio + separador;
         
    
    
	public static void main(String[] args) throws IOException {
		String peso = null;
		String altura = null;
		String imcRecepcion;
		String comentarioRecepcion;
		
		
		System.out.println("Calculadora de Índice de Masa Corporal");
		System.out.println("-----------------------------------------");
		
		
		do {//Buffer para entrada de datos por el usuario. Mediante funciones previamente creadas en el package PideDatos
			peso = PideDatos.pideString("Introduzca el peso en Kg.: (Separador decimal .) ");
			altura = PideDatos.pideString("Introduzca la altura en metros: (Separador decimal .)");
			
			 
			if ((!peso.equals("0") && !altura.equals("0"))) {
				
				try {//Inicio la comunicación
					Process comunicacion = new ProcessBuilder("java", "-jar", rutaActividad + "CalculadoraIMC.jar").start();
					//Buffer de recepción de datos del proceso hijo
					BufferedReader br = new BufferedReader(new InputStreamReader(comunicacion.getInputStream()));
					//Stream de salida hacia el proceso hijo
					PrintStream ps = new PrintStream(comunicacion.getOutputStream(), true);
					
					//Envío el peso y la altura al proceso hijo
					ps.println(peso);
					ps.println(altura);
					
					//Recibo la variable imc String desde el hijo.
					imcRecepcion = br.readLine();
					comentarioRecepcion = br.readLine();
					System.out.println("Su imc es: " + imcRecepcion + "\n");
					System.out.println(comentarioRecepcion);
					
					
					
				}catch(IOException e){
					
					System.out.println("Error " + e.getMessage());
				}
			}else {
				
				System.out.println("Ha elegido salir.");
			}
				
			
		}while(!peso.equals("0") && !altura.equals("0"));
		
		
		
	}

}
