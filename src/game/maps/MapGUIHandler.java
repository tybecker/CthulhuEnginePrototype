package game.maps;

import java.awt.Graphics;

public interface MapGUIHandler {

	public void tick();
	public int mouseMoved(int x, int y);
	public int mouseClicked(int x, int y);
	public void draw(Graphics g);
	
}
