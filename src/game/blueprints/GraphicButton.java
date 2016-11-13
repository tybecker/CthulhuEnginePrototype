package game.blueprints;

import java.awt.Graphics;

public interface GraphicButton {
	
	public void draw(Graphics g);
	public int mouseMoved(int x, int y);
	public int mouseClicked(int x, int y);
	public int getXCoordinate();
	public int getYCoordinate();
	public int getWidth();
	public int getHeight();
	public boolean withinBounds(int x, int y);
	public boolean buttonActive();
	public void setButtonActive(boolean activate);
}
