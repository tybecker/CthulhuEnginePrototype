package game.cutscenes;

import java.awt.Graphics;

public interface Cutscene {

	
	public int tick();
	public int mouseClicked(int x, int y);
	public int mouseMoved(int x, int y);
	public void draw(Graphics g);
	public int endScene();
	
}
