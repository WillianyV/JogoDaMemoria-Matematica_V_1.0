package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import view.Mensagem;


public class BancoDeDados {

	private static ArrayList<Cartas>bancoDeCartas = new ArrayList<>();
	private static ArrayList<Integer>cartasUsadas = new ArrayList<>();
	private static ArrayList<Integer> perguntasFeitas = new ArrayList<>();
	private static Random aleatorio = new Random();

	//METODOS PERSONALIZADOS
	public static void inicializarArrayList(){
		for(int i = 1; i < 9;i++){
			bancoDeCartas.add(new Cartas(leitura(i)));
		}
	}

	public static Cartas[] cartasJogo() {

		int carta;
		Cartas[] cartasNojogo = new Cartas[8];

		int i = 0;
		while(cartasUsadas.size() < 8){

			carta = aleatorio.nextInt(8);
			if(verificar(carta)){
				cartasNojogo[i] = bancoDeCartas.get(carta);
				i++; 
				cartasUsadas.add(carta);
			}
		}

		return cartasNojogo;
	}

	public static String leitura(int nLinha){
		FileReader ler;
		String lido = "";
		int i=0;

		try {
			ler = new FileReader("Resource/ArquivosTxt/Cartas.txt");
			BufferedReader br = new BufferedReader(ler);
			while(i < nLinha){
				try {
					lido = br.readLine();
					i++;
				} catch (IOException e) {
					Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
				}
			}
		} catch (FileNotFoundException e) {	
			Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
		}

		return lido;
	}

	public static boolean verificar(int carta){
		for(int i: cartasUsadas){
			if (i == carta){
				return false;
			}
		}
		return true;
	}

	public static Questoes gerarQuestoes(String tipoQuestao){
		
		String lido;
		int numPergunta = gerarNumeroPergunta(tipoQuestao) ;
		lido = leitor(2,numPergunta);

		return new Questoes(lido, fornecerAlternativas(numPergunta), numPergunta);
	}

	public static String[] fornecerAlternativas(int numQuestao){
		ArrayList<String> alt = new ArrayList<>();		
		String[] alternativas = new String[4];
		int j=0;
		
		int resposta = aleatorio.nextInt(3);
		alternativas[resposta] = leitor(3, numQuestao);
		alt.add(leitor(1, 2*(numQuestao-1)+2));
		alt.add(leitor(1, 2*(numQuestao-1)+3));
		alt.add(leitor(1, 2*(numQuestao-1)+4));
		
		for(int i=0; i<4;i++){
			if(i != resposta){
				alternativas[i] = alt.get(j);
				j++;
			}
		}
		return alternativas;
	}
	
	public static String leitor(int arquivo, int nLinha){
		String endArquivo = "";
		String lido = "";
		int i =0;
		
		switch (arquivo) {
		case 1: 
			endArquivo = "Resource/ArquivosTxt/Alternativas.txt";
			break;
		case 2: 
			endArquivo = "Resource/ArquivosTxt/Perguntas.txt";
			break;
		case 3: 
			endArquivo = "Resource/ArquivosTxt/Respostas.txt";
			break;

		}
		FileReader ler;
		try {
			ler = new FileReader(endArquivo);
			BufferedReader br = new BufferedReader(ler);
			while(i < nLinha){
				lido = br.readLine();
				i++;
			}
		} catch (Exception e1) {
			Mensagem.mensagemExibir("Não foi possivel a leitura do arquivo");
		}		
		
		return lido;
		
	}

	public static int gerarNumeroPergunta(String tipoQuestao){
		int numQuestao = 0;
		int i = 0;
		while (i == 0){
			numQuestao = aleatorio.nextInt(39)+1;

			if( verificarPerguntasFeitas(numQuestao)){

				if(tipoQuestao.equals("/")){
					if(numQuestao >= 31 && numQuestao <= 40){
						i=1;
					}
				}
				if(tipoQuestao.equals("+")){
					if(numQuestao >= 1 && numQuestao <= 10){
						i=1;
					}
				}
				if(tipoQuestao.equals("-")){
					if(numQuestao >= 11 && numQuestao <= 20){
						i=1;
					}
				}
				if(tipoQuestao.equals("x")){
					if(numQuestao >= 21 && numQuestao <= 30){
						i=1;
					}
				}

			}	
		}
		return numQuestao;
	}

	public static boolean verificarPerguntasFeitas(int numQuestao){
		for(int perguntas : perguntasFeitas){
			if(perguntas == numQuestao){
				return false;
			}
		}
		return true;		
	}

	public static ArrayList<Integer> getCartasUsadas() {
		return cartasUsadas;
	}
	

	public static  ArrayList<Cartas>getBancoDeCartas(){
		return bancoDeCartas; 
	}
	
}
