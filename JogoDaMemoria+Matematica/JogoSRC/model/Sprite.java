package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	BufferedImage spriteSheet;

	public int width, height;
	public int rows, columns;
	public int posX, posY;
	public BufferedImage[] sprites;
	public int aparencia;
	
	
	public Sprite(String urlSprite,int aparencia, int width, int height, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(new File(urlSprite));   
		this.aparencia=aparencia;
		this.width = width;
		this.height = height;

		this.rows = rows;
		this.columns =  columns;
		this.posX=posX;
		this.posY=posY;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
			}
		}
	}
}