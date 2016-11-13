package game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.blueprints.GraphicButton;
import game.resources.Images;

public class RectangleButton implements GraphicButton{

	boolean buttonActive;
	boolean buttonHovered;
	int xCoor;
	int yCoor;
	int width;
	int height;
	int buttonCode;
	int idle;
	int hovered;
	int inactive;
	int clickedReturnCode;
	int hoveredReturnCode;
	BufferedImage idleImage;
	BufferedImage hoveredImage;
	BufferedImage inactiveImage;
	
	//public RectangleButton(int x, int y, int width, int height, String idle, String hovered, String inactive, boolean active, boolean bHovered, int crc, int hrc){
	public RectangleButton(int x, int y, int width, int height, int code, int idle, int hovered, int inactive, boolean active, boolean bHovered, int crc, int hrc){
		buttonActive = active;
		buttonHovered = bHovered;
		xCoor = x;
		yCoor = y;
		this.width = width;
		this.height = height;
		buttonCode = code;
		this.idle = idle;
		this.hovered = hovered;
		this.inactive = inactive;
		clickedReturnCode = crc;
		hoveredReturnCode = hrc;
		
		/*System.out.println("" + idle + " " + hovered + " " + inactive);
		
		if(getClass().getResourceAsStream(idle) == null){
			System.out.println("This is what's null.  And shouldn't be.");
		}*/
		/*try{
			idleImage = ImageIO.read(getClass().getResourceAsStream(idle));
			hoveredImage = ImageIO.read(getClass().getResourceAsStream(hovered));
			inactiveImage = ImageIO.read(getClass().getResourceAsStream(inactive));
		}catch(IOException e){
			e.printStackTrace();
		}*/
		
		idleImage = Images.buttons[buttonCode][idle];
		hoveredImage = Images.buttons[buttonCode][hovered];
		inactiveImage = Images.buttons[buttonCode][inactive];
	}
	
	@Override
	public void draw(Graphics g) {
		if(buttonActive){
			if(buttonHovered){
				g.drawImage(hoveredImage, xCoor, yCoor, width, height, null);
			}else{
				g.drawImage(idleImage, xCoor, yCoor, width, height, null);
			}
		}else{
			g.drawImage(inactiveImage, xCoor, yCoor, width, height, null);
		}
	}

	@Override
	public int mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && y > yCoor && x < xCoor + width && y < yCoor + height){
			buttonHovered = true;
			return hoveredReturnCode;
		}
		buttonHovered = false;
		return 0;
	}

	@Override
	public int mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && y > yCoor && x < xCoor + width && y < yCoor + height){
			return clickedReturnCode;
		}
		return 0;
	}

	@Override
	public int getXCoordinate() {
		// TODO Auto-generated method stub
		return xCoor;
	}

	@Override
	public int getYCoordinate() {
		// TODO Auto-generated method stub
		return yCoor;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean withinBounds(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && y > yCoor && x < xCoor + width && y < yCoor + height){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean buttonActive() {
		// TODO Auto-generated method stub
		return buttonActive;
	}

	@Override
	public void setButtonActive(boolean activate) {
		// TODO Auto-generated method stub
		buttonActive = activate;
	}

}
