package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.BancoDeDados;
import model.Cronometro;
import model.Jogador;
import model.Jogo;
import model.Sons;
import model.ThreadDesenhar;
import view.Mensagem;
import view.TelaPrincipal;

public class ControladorDoJogo {

	private TelaPrincipal telaPrincipal;
	private Controlador controlador;

	public ControladorDoJogo(){

		telaPrincipal = new TelaPrincipal();
		telaPrincipal.addKeyListener(controlador);

		controlador = new Controlador();

		ThreadDesenhar tDsenhar = new ThreadDesenhar(telaPrincipal);
		tDsenhar.start();

		telaPrincipal.getpMenu().getSair().addActionListener(controlador);	
		telaPrincipal.getpMenu().getJogar().addActionListener(controlador);
		telaPrincipal.getpJogo().addMouseListener(controlador);

		for(int i=0; i<4;i++){
			telaPrincipal.getpQuestoes().getAlternativasButton().get(i).addActionListener(controlador);
		}

		telaPrincipal.getpMenu().getJogar().addKeyListener(controlador);

	}

	private class Controlador implements ActionListener,KeyListener,MouseListener{

		public void actionPerformed(ActionEvent e) {
			//CONTROLADOR MENU
			if (e.getSource() == telaPrincipal.getpMenu().getSair()){
				System.exit(0);
			}

			if (e.getSource() == telaPrincipal.getpMenu().getJogar()){
				telaPrincipal.getpMenu().setVisible(false);
				telaPrincipal.getpMenu().setRodar(false);

				//CONTROLADOR MENU -> JOGO
				Jogo.setTela(telaPrincipal);				
				Jogo.iniciarJogo();
				Jogador.setNomeJogador1(Mensagem.mensagemNome());

			}
			//CONTROLADOR QUESTOES
			if (e.getSource() == telaPrincipal.getpQuestoes().getAlternativasButton().get(0)){
				Jogo.compararRespostas(telaPrincipal.getpQuestoes().getQuestoes().getIndicePergunta(),
						telaPrincipal.getpQuestoes().getAlternativasButton().get(0).getText());
				telaPrincipal.getpQuestoes().voltarTelaJogo();
			}
			if (e.getSource() == telaPrincipal.getpQuestoes().getAlternativasButton().get(1)){
				Jogo.compararRespostas(telaPrincipal.getpQuestoes().getQuestoes().getIndicePergunta(),
						telaPrincipal.getpQuestoes().getAlternativasButton().get(1).getText());
				telaPrincipal.getpQuestoes().voltarTelaJogo();
			}
			if (e.getSource() == telaPrincipal.getpQuestoes().getAlternativasButton().get(2)){
				Jogo.compararRespostas(telaPrincipal.getpQuestoes().getQuestoes().getIndicePergunta(),
						telaPrincipal.getpQuestoes().getAlternativasButton().get(2).getText());
				telaPrincipal.getpQuestoes().voltarTelaJogo();
			}
			if (e.getSource() == telaPrincipal.getpQuestoes().getAlternativasButton().get(3)){
				Jogo.compararRespostas(telaPrincipal.getpQuestoes().getQuestoes().getIndicePergunta(),
						telaPrincipal.getpQuestoes().getAlternativasButton().get(3).getText());
				telaPrincipal.getpQuestoes().voltarTelaJogo();
			}

		}

		//TECLADO:
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== e.VK_ESCAPE){
				System.exit(0);
			}
		}
		public void keyReleased(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {}

		//CONTROLADOR DO JOGO, MOUSE :
		public void mouseClicked(MouseEvent e) {
			if((e.getX() >= 100 && e.getX() <= 220 ) && (e.getY() >= 150 && e.getY() <= 306 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[0].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[0].virar(0);
				}	
			}

			if((e.getX() >= 310 && e.getX() <= 430 ) && (e.getY() >= 150 && e.getY() <= 306 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[1].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[1].virar(1);	
				}	
			}

			if((e.getX() >= 520 && e.getX() <= 640 ) && (e.getY() >= 150 && e.getY() <= 306 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[2].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[2].virar(2);	
				}	
			}

			if((e.getX() >= 730 && e.getX() <= 850 ) && (e.getY() >= 150 && e.getY() <= 306 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[3].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[3].virar(3);	
				}	
			}

			if((e.getX() >= 100 && e.getX() <= 220 ) && (e.getY() >= 350 && e.getY() <= 506 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[4].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[4].virar(4);	
				}	
			}

			if((e.getX() >= 310 && e.getX() <= 430 ) && (e.getY() >= 350 && e.getY() <= 506 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[5].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[5].virar(5);	
				}	
			}

			if((e.getX() >= 520 && e.getX() <= 640 ) && (e.getY() >= 350 && e.getY() <= 506 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[6].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[6].virar(6);
				}	
			}

			if((e.getX() >= 730 && e.getX() <= 850 ) && (e.getY() >= 350 && e.getY() <= 506 )){
				if(telaPrincipal.getpJogo().getCartasNojogo()[7].getCartasSprite().aparencia == 0){
					telaPrincipal.getpJogo().getCartasNojogo()[7].virar(7);	
				}	
			}
			
			

		}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}



	public TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	public void setTelaPrincipal(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

}
