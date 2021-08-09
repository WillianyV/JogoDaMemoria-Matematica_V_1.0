package model;

public class Questoes {
	private String pergunta;
	private String[] alternativas = new String[4];
	private int indicePergunta;
	
	public Questoes(String pergunta, String[] alternativas,int indicePergunta) {
		this.pergunta = pergunta;
		this.alternativas = alternativas;
		this.indicePergunta = indicePergunta;
	}
	

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String[] getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(String[] alternativas) {
		this.alternativas = alternativas;
	}


	public int getIndicePergunta() {
		return indicePergunta;
	}


	public void setIndicePergunta(int indicePergunta) {
		this.indicePergunta = indicePergunta;
	}

}
