package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import view.Mensagem;

public class Sons {
	
	public static void tocar(String urlSom){
		try {
			File soundFile = new File(urlSom);
	        AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
	        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	        Clip clip = (Clip) AudioSystem.getLine(info);
	        clip.open(sound);
	        clip.start();
		} catch (Exception e) {
			Mensagem.mensagemExibir("Erro no audio");
		}
	}
}
