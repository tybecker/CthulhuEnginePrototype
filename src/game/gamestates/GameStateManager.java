package game.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {
	
	public Stack<GameState> states;

	//Debug lines, comment out when done.
	int x = 0;
	int y = 0;
	
	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MainMenuState(this));
	}
	
	public void tick(){
		states.peek().tick();
	}
	
	public void draw(Graphics g){
		states.peek().draw(g);
		
		//Debug lines, comment out when done.
		g.setColor(Color.RED);
		g.drawString("x: " + x + " y: " + y, 10, 20);
	}
	
	public void keyPressed(int k){
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k){
		states.peek().keyReleased(k);
	}
	
	public void mouseMoved(int x, int y){
		states.peek().mouseMoved(x, y);
		
		//Debug lines, comment out when done.
		this.x = x;
		this.y = y;
	}
	
	public void mouseClicked(int x, int y){
		states.peek().mouseClicked(x, y);
	}
}
