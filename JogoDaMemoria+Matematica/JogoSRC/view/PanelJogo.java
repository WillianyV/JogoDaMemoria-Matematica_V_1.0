package view;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Cartas;


public class PanelJogo extends JPanel {

	private boolean rodarPJogo;
	private ImageIcon backImagem;
	private Cartas[] cartasNojogo;


	public PanelJogo(){
		setLayout(null);
		setIgnoreRepaint(true);
		setVisible(false);
		
		rodarPJogo = false;
		cartasNojogo = new Cartas[8];
		backImagem = new ImageIcon("Resource/Imagens/Interface/JOGOimagem4.png");
		
		
	}

	//METODOS ACESSORES	
	public boolean isRodarPJogo() {
		return rodarPJogo;
	}

	public ImageIcon getBackImagem() {
		return backImagem;
	}

	public void setBackImagem(ImageIcon backImagem) {
		this.backImagem = backImagem;
	}

	public void setRodarPJogo(boolean rodarPJogo) {
		this.rodarPJogo = rodarPJogo;
	}
	
	public Cartas[] getCartasNojogo() {
		return cartasNojogo;
	}

	public void setCartasNojogo(Cartas[] cartasNojogo) {
		this.cartasNojogo = cartasNojogo;
	}	
}
