package game.gamestates;

import java.awt.Graphics;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		
		init();
	}
	
	public abstract void init();						//Run when the state is created.
	public abstract void tick();						//Run 60 times per second (approximate).
	public abstract void draw(Graphics g);				//Draw the state.
	public abstract void keyPressed(int k);				//What happens when a key is pressed.
	public abstract void keyReleased(int k);			//What happens when a key is released.
	public abstract void mouseMoved(int x, int y);		//What happens when the mouse is moved.
	public abstract void mouseClicked(int x, int y);	//What happens when the mouse is clicked.

}
