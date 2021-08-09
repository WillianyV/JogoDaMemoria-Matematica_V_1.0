package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import view.Mensagem;
import view.TelaPrincipal;

public class Desenhar {


	public static void desenharNaTela(TelaPrincipal tela){

		Font fonte = new Font("MV Boli",Font.BOLD,25);
		Color rosa = new Color(199,21,133);

		Graphics2D g2 = (Graphics2D) tela.getGraphics(); 	
		Graphics g = tela.getBuffer().getGraphics();
		g2.drawImage(tela.getBuffer(), 0, 0, null);

		if(tela.getpMenu().isRodar()){
			/*
			 * PANEL MENU
			 */			
			g.drawImage(tela.getpMenu().getMenuImageIcon().getImage(), 0, 0, null);
			tela.getpMenu().getJogar().repaint();
			tela.getpMenu().getSair().repaint();
		}
		else if(tela.getpJogo().isRodarPJogo()){
			/*
			 * PANEL JOGO
			 */
			g.drawImage(tela.getpJogo().getBackImagem().getImage(),0,0,null);
			
			

			try {
				g.setColor(rosa);
				g.setFont(fonte);
				g.drawString("Jogadas: "+ Jogador.getJogadasJogador1(),100 , 110);
				g.drawString(Jogador.getNomeJogador1(), 100, 70);
				g.setColor(Color.WHITE);
				g.drawString(Integer.toString(Jogador.getAcertosJogador1()), 150, 590);	
				g.drawString(Cronometro.getTempo(), 800, 590);

			} catch (Exception e) {}

			try {

				g.drawImage(tela.getpJogo().getCartasNojogo()[0].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[0].getCartasSprite().aparencia],
						100, 150, null);

				g.drawImage(tela.getpJogo().getCartasNojogo()[1].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[1].getCartasSprite().aparencia],
						310, 150, null);

				g.drawImage(tela.getpJogo().getCartasNojogo()[2].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[2].getCartasSprite().aparencia],
						520, 150, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[3].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[3].getCartasSprite().aparencia],
						730, 150, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[4].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[4].getCartasSprite().aparencia],
						100, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[5].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[5].getCartasSprite().aparencia],
						310, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[6].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[6].getCartasSprite().aparencia],
						520, 350, null);
				g.drawImage(tela.getpJogo().getCartasNojogo()[7].getCartasSprite().sprites[tela.getpJogo().getCartasNojogo()[7].getCartasSprite().aparencia],
						730, 350, null);

			} catch (Exception e) {}	
			

		}
		else if (tela.getpQuestoes().isRodarPQuestoes()){
			/*
			 * PANEL QUESTÕES
			 */
			g.setFont(fonte);
			g.setColor(Color.WHITE);
			g.drawImage(tela.getpQuestoes().getpQuestoesImageIcon().getImage(), 0, 0, null);
			g.drawString("RESPONDA A QUESTÃO ABAIXO:", 250, 90);
			g.drawString(tela.getpQuestoes().getQuestoes().getPergunta(),400, 200);

			for(int i=0;i<4;i++){
				tela.getpQuestoes().getAlternativasButton().get(i).repaint();
			}

		}
	}
}
