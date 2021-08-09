package model;

import java.io.IOException;

import view.Mensagem;


public class Cartas {

	private String tipoDaCarta;
	private Sprite cartasSprite;


	public Cartas(String enderecoDaCarta) {
		tipoDaCarta = tipo(enderecoDaCarta);		
		try {
			cartasSprite = new Sprite(enderecoDaCarta, 0, 120, 156, 4, 1, 100, 0);
		} catch (IOException e) {
			Mensagem.mensagemExibir("Erro ao inserir o sprite");
		}
	}

	//METODOS PERSONALIZADOS
	public String tipo(String enderecoDaCarta){
		String tipo = null;
		if(BancoDeDados.leitura(1).equals(enderecoDaCarta)){
			tipo = "/";
		}else if(BancoDeDados.leitura(3).equals(enderecoDaCarta)){
			tipo = "x";
		}else if(BancoDeDados.leitura(5).equals(enderecoDaCarta)){
			tipo = "+";
		}else if(BancoDeDados.leitura(7).equals(enderecoDaCarta)){
			tipo = "-";
		}
		return tipo;		
	}
	
	public void virar(int posicao){
		Sons.tocar("Resource/Audios/Cartas.wav");
			for(int i = 0; i < 3; i++){				
				try {
					Thread.sleep(130);
					cartasSprite.aparencia++;
				} catch (InterruptedException e) {
					Mensagem.mensagemExibir("Não foi possivel exibir o sprite");
				}
			}
			try {
				Thread.sleep(500);
				if(Jogo.getCartasSelecionadas().size() <= 2){
					Jogo.verificarCartas(posicao);	
				}				
			} catch (InterruptedException e) {
				Mensagem.mensagemExibir("Erro ao verificar cartas");
				
			}
			
	}
	
	public  void desvirar(){
		Sons.tocar("Resource/Audios/Cartas.wav");
		for(int i = 0; i < 3; i++){				
			try {
				Thread.sleep(130);
				cartasSprite.aparencia--;
			} catch (InterruptedException e) {
				Mensagem.mensagemExibir("Não foi possivel exibir o sprite");
			}			
		}
	}

	//METODOS ACESSORES	
	public String getTipoDaCarta() {
		return tipoDaCarta;
	}

	public void setTipoDaCarta(String tipoDaCarta) {
		this.tipoDaCarta = tipoDaCarta;
	}

	public Sprite getCartasSprite() {
		return cartasSprite;
	}

	public void setCartasSprite(Sprite cartasSprite) {
		this.cartasSprite = cartasSprite;
	}

}
