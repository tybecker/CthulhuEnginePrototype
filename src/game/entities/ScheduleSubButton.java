package game.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.blueprints.GraphicButton;

public class ScheduleSubButton implements GraphicButton{

	boolean buttonHovered;
	boolean buttonActive;
	int xCoor;
	int yCoor;
	String name;
	int width;
	int height;
	int clickReturnCode;
	int hoverReturnCode;
	
	public ScheduleSubButton(String name, int x, int y, int w, int h, int crc, int hrc, boolean a){
		this.name = name;
		xCoor = x;
		yCoor = y;
		width = w;
		height = h;
		clickReturnCode = crc;
		hoverReturnCode = hrc;
		buttonHovered = false;
		buttonActive = a;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(buttonHovered){
			g.setColor(Color.GRAY);
		}else{
			g.setColor(Color.WHITE);
		}
		g.fillRect(xCoor, yCoor, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xCoor, yCoor, width, height);
		g.drawString(name, xCoor + 5, yCoor + height - 5);
	}
	
	public void draw(Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		if(buttonHovered){
			g.setColor(Color.GRAY);
		}else{
			g.setColor(Color.WHITE);
		}
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		g.drawString(name, x + 5, y + height - 5);
		//xCoor = x;
		//yCoor = y;
		//this.width = width;
		//this.height = height;
	}

	@Override
	public int mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
			buttonHovered = true;
			return hoverReturnCode;
		}else{
			buttonHovered = false;
			return 0;
		}
	}

	@Override
	public int mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
			return clickReturnCode;
		}else{
			return 0;
		}
	}

	@Override
	public int getXCoordinate() {
		// TODO Auto-generated method stub
		return xCoor;
	}
	
	public void setXCoordinate(int x){
		xCoor = x;
	}

	@Override
	public int getYCoordinate() {
		// TODO Auto-generated method stub
		return yCoor;
	}
	
	public void setYCoordinate(int y){
		yCoor = y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
	
	public void setWidth(int w){
		width = w;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public void setHeight(int h){
		height = h;
	}

	@Override
	public boolean withinBounds(int x, int y) {
		// TODO Auto-generated method stub
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
			return true;
		}
		return false;
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
