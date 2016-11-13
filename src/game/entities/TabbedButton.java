package game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.blueprints.GraphicButton;
import game.resources.Images;

public class TabbedButton implements GraphicButton{

	//The booleans dealing with the button's state:
	boolean buttonEnabled;
	boolean buttonSelected;
	boolean buttonHovered;
	
	//Other Necessary Info
	int xCoor;
	int yCoor;
	int width;
	int height;
	int buttonCode;
	int idle;
	int hovered;
	int selected;
	int disabled;
	int clickedReturnCode;
	int hoveredReturnCode;
	BufferedImage idleImage;
	BufferedImage hoveredImage;
	BufferedImage selectedImage;
	BufferedImage disabledImage;
	
	public TabbedButton(int x, int y, int w, int h, int code, int idle, int hovered, int selected, int disabled, boolean buttonEnabled, boolean buttonSelected, boolean buttonHovered, int crc, int hrc){
		xCoor = x;
		yCoor = y;
		width = w;
		height = h;
		buttonCode = code;
		this.idle = idle;
		this.hovered = hovered;
		this.selected = selected;
		this.disabled = disabled;
		clickedReturnCode = crc;
		hoveredReturnCode = hrc;
		this.buttonEnabled = buttonEnabled;
		this.buttonHovered = buttonHovered;
		this.buttonSelected = buttonSelected;
		
		idleImage = Images.buttons[buttonCode][idle];
		hoveredImage = Images.buttons[buttonCode][hovered];
		selectedImage = Images.buttons[buttonCode][selected];
		disabledImage = Images.buttons[buttonCode][disabled];
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(buttonEnabled){
			if(buttonSelected){
				g.drawImage(selectedImage, xCoor, yCoor, width, height, null);
			}else{
				if(buttonHovered){
					g.drawImage(hoveredImage, xCoor, yCoor, width, height, null);
				}else{
					g.drawImage(idleImage, xCoor, yCoor, width, height, null);
				}
			}
		}else{
			g.drawImage(disabledImage, xCoor, yCoor, width, height, null);
		}
	}

	@Override
	public int mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
			buttonHovered = true;
			return hoveredReturnCode;
		}
		
		buttonHovered = false;
		return 0;
	}

	@Override
	public int mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
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
		return buttonEnabled;
	}

	@Override
	public void setButtonActive(boolean activate) {
		// TODO Auto-generated method stub
		buttonEnabled = activate;
	}
	
	public boolean buttonSelected(){
		return buttonSelected;
	}
	
	public void setButtonSelected(boolean selected){
		buttonSelected = selected;
	}
}
