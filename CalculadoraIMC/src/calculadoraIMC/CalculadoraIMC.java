package calculadoraIMC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculadoraIMC {

	public static void main(String[] args) {
		Double peso = null;
		Double altura = null;
		Double imc = null;
		String imcCasteado;
		String comentario;
		 
		 try {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			 try{
				 peso = Double.parseDouble(br.readLine());
				 altura = Double.parseDouble(br.readLine());
				 
			 }catch(NumberFormatException ex) {
				 System.out.println("Formato de números inválido.\n");
				 System.out.println("Introduzca números válidos.\n");
			 }
			 
			 imc = peso / (altura * altura);
			 imcCasteado = imc.toString();
			 
			 
			 
			 System.out.println(imcCasteado);
			 
			 imc = Double.parseDouble(imcCasteado);
				
			if (imc < 18.5) {
				 comentario = "Usted esta con bajo peso.\n";
				 System.out.println(comentario);
			 }else if (imc >= 18.5  && imc < 25) {
				 comentario = "Usted esta en su peso normal.\n";
				 System.out.println(comentario);
			 }else if (imc >= 25 && imc < 30) {
				 comentario = "Usted esta con sobrepeso.\n";
				 System.out.println(comentario);
			 }else if (imc >= 30 && imc < 40) {
				 comentario = "Usted esta con obesidad.\n";
				 System.out.println(comentario);
			 }else {
				 comentario = "Usted esta con obesidad mórbida.\n";
				 System.out.println(comentario);
			 }
					 
			 			 		 
			 
		 }catch(IOException e) {
			 
			 System.out.println("Eror " + e.getMessage());
		 }
	        
	}

}