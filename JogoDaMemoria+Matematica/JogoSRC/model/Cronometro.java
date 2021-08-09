package model;

public class Cronometro {
	private static int segInicio;
	private static int segatual ;
	private static int mimatual;
	private static int normalizador;

	public static void iniciar() {
		segInicio = java.time.LocalDateTime.now().getSecond();	
		mimatual = 0;
	}
	public static String getTempo() {
		String retorno = "";
		segatual = java.time.LocalDateTime.now().getSecond();
		normalizador++;

		if(segatual>=segInicio){
			segatual -= segInicio;
		}else{
			segatual += 60-segInicio;
		}	

		if(mimatual<10){
			retorno = "0";
		}
			
		retorno += mimatual+":";
		
		if(segatual<10){
			retorno += "0";
		}
			
		retorno += segatual+"";
		
		if(segatual== 00 && normalizador>20) {
			normalizador = 0;
			mimatual ++;
		}
		
		return retorno;

	}

}

