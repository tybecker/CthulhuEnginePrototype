package game.blueprints;

import game.resources.Images;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Item {
	int itemID;
	String name;
	int imageIndex;
	BufferedImage itemImage;
	
	public Item(int id, String name, int imageIndex){
		itemID = id;
		this.name = name;
		this.imageIndex = imageIndex;
		itemImage = Images.inventory[imageIndex];
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public String getItemName(){
		return name;
	}
	
	public void draw(Graphics g, int x, int y, int width, int height){
		g.drawImage(itemImage, x, y, width, height, null);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
	
	public BufferedImage getItemImage(){
		return itemImage;
	}
}
