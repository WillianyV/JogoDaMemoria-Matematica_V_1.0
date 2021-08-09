package model;

import view.Mensagem;
import view.TelaPrincipal;

public class ThreadDesenhar extends Thread{

	TelaPrincipal tela;

	public ThreadDesenhar(TelaPrincipal tela){
		this.tela = tela;
	}

	public void run(){
		while(true){
			try {
				Thread.sleep(1000/24);
				Desenhar.desenharNaTela(tela);
				
			} catch (InterruptedException e) {
				Mensagem.mensagemExibir("Erro ao iniciar o jogo");
				
			}			
		}

	}
}
