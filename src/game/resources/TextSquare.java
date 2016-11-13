package game.resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextSquare {

	public static void drawTextBox(int x, int y, int WIDTH, int HEIGHT, Graphics g, String s){
		
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, WIDTH, HEIGHT);
		
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		
		g.drawString(s, x + 10, y + 25);
	}
	
	public static void drawTextBox(int x, int y, int WIDTH, int HEIGHT, Graphics g, String s, int size, Font font){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public static void drawTextBox(int x, int y, int WIDTH, int HEIGHT, Graphics g, String s, Color fill, Color border, Color text){
		
	}
	
	public static void drawTextBox(int x, int y, int WIDTH, int HEIGHT, Graphics g, String s, Color fill, Color border, Color text, int size, Font f){
		
	}
}
