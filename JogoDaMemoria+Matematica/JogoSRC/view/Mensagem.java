package view;

import javax.swing.JOptionPane;

import model.Cronometro;
import model.Jogador;
import model.Jogo;

public class Mensagem {
	public static void mensagemExibir(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static String mensagemNome(){
		return JOptionPane.showInputDialog("DIGITE O SEU NOME: ");
	}
	
	public static void mensagemEndGame(){
		int resposta = JOptionPane.showConfirmDialog(null, "***** Parabéns *****\n\n" 
													+"Jogador: "+ Jogador.getNomeJogador1() 
													+"\nAcertos: " + Jogador.getAcertosJogador1() 
													+ "\nJogadas: " + Jogador.getJogadasJogador1() 
													+"\nDuração do Jogo: " + Cronometro.getTempo() 
													+ "\n\nDeseja jogar novamente?\n\n", 
													"Fim de Jogo",  
													JOptionPane.INFORMATION_MESSAGE);
		
		if (resposta ==JOptionPane.YES_OPTION){
			Jogo.iniciarJogo();
		}else{
			System.exit(0);
		} 
		
	}
}
