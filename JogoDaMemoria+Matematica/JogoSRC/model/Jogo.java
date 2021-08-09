package model;

import java.util.ArrayList;

import view.Mensagem;
import view.TelaPrincipal;

public class Jogo {

	private static ArrayList<Integer>cartasSelecionadas = new ArrayList<Integer>();

	private static TelaPrincipal tela;


	public static boolean verificarCartas(int pos){

		if(cartasSelecionadas.size() < 2){
			cartasSelecionadas.add(pos);
		}else{
			return false;
		}

		if(cartasSelecionadas.size() == 2){
			if (compararCartas()){
				tela.getpJogo().setVisible(false);
				tela.getpJogo().setRodarPJogo(false);

				tela.getpQuestoes().setQuestoes(BancoDeDados.gerarQuestoes(tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(0)].getTipoDaCarta()));
				tela.getpQuestoes().alternativas();
				tela.getpQuestoes().setVisible(true);
				tela.getpQuestoes().setRodarPQuestoes(true);

			}else{				
				for (int i=0; i<2; i++){
					tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(i)].desvirar();
				}
				cartasSelecionadas.clear();
			}
			Jogador.setJogadasJogador1(Jogador.getJogadasJogador1() + 1);
		}			
		return true;
	}

	public static boolean compararCartas(){
		if (tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(0)].getTipoDaCarta().equals
				(tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(1)].getTipoDaCarta())){
			return true;
		}
		return false;	
	}

	public static boolean compararRespostas(int numQuestao, String respostaJogador){
		if(BancoDeDados.leitor(3, numQuestao).equals(respostaJogador)){
			
			Jogador.setAcertosJogador1(Jogador.getAcertosJogador1() + 1);

			if (Jogador.getAcertosJogador1() == 4){
				//isso
				Mensagem.mensagemEndGame();
				
			}
			cartasSelecionadas.clear();
			return true;
		}else{
			for (int i=0; i<2; i++){
				tela.getpJogo().getCartasNojogo()[cartasSelecionadas.get(i)].desvirar();
			}
		}
		cartasSelecionadas.clear();
		return false;
	}

	public static void iniciarJogo(){

		Jogador.setAcertosJogador1(0);
		Jogador.setJogadasJogador1(0);
		tela.getpJogo().setVisible(true);
		BancoDeDados.inicializarArrayList();
		tela.getpJogo().setCartasNojogo(BancoDeDados.cartasJogo());				
		tela.getpJogo().setRodarPJogo(true);
		Cronometro.iniciar();
	}

	public static void setTela(TelaPrincipal tela) {
		Jogo.tela = tela;
	}

	public static ArrayList<Integer> getCartasSelecionadas() {
		return cartasSelecionadas;
	}


}
