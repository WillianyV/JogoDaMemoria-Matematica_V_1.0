package model;


public class Jogador {
	private static String nomeJogador1;
	private static int jogadasJogador1;
	private static int acertosJogador1;
	
	//METODOS ACESSORES
	public static String getNomeJogador1() {
		return nomeJogador1;
	}

	public static void setNomeJogador1(String nomeJogador1) {
		Jogador.nomeJogador1 = nomeJogador1;
	}

	public static int getJogadasJogador1() {
		return jogadasJogador1;
	}

	public static void setJogadasJogador1(int jogadasJogador1) {
		Jogador.jogadasJogador1 = jogadasJogador1;
	}

	public static int getAcertosJogador1() {
		return acertosJogador1;
	}

	public static void setAcertosJogador1(int acertosJogador1) {
		Jogador.acertosJogador1 = acertosJogador1;
	}

	
}
