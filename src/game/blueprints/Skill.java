package game.blueprints;

import java.awt.Color;
import java.awt.Graphics;

public class Skill {
	
	public static final int WIDTH = 200;
	public static final int HEIGHT = 20;
	Skill parent;
	int skillLevel;
	boolean unlocked;
	boolean available;
	String name;
	int xCoor;
	int yCoor;
	
	public Skill(String name, int skillLevel, boolean unlocked, boolean available, Skill parent, int xCoor, int yCoor){
		this.name = name;
		this.skillLevel = skillLevel;
		this.unlocked = unlocked;
		this.available = available;
		this.parent = parent;
		this.xCoor = xCoor;
		this.yCoor = yCoor;
	}
	
	public void draw(Graphics g){
		if(unlocked && available){
			g.setColor(Color.BLACK);
			g.drawString(name, xCoor, yCoor);
			g.setColor(Color.WHITE);
			g.fillRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
			g.setColor(Color.GRAY);
			g.fillRect(xCoor, yCoor + 5, (WIDTH * skillLevel)/100, HEIGHT);
			g.setColor(Color.BLACK);
			g.drawRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
			g.drawString("" + skillLevel, xCoor + WIDTH + 10, yCoor + 20);
		}else if(unlocked && !available){
			g.setColor(Color.GRAY);
			g.drawString(name, xCoor, yCoor);
			g.setColor(Color.WHITE);
			g.fillRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
			g.setColor(Color.GRAY);
			g.fillRect(xCoor, yCoor + 5, (WIDTH * skillLevel)/100, HEIGHT);
			g.setColor(Color.GRAY);
			g.drawRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
			g.drawString("" + skillLevel, xCoor + WIDTH + 10, yCoor + 20);
		}else{
			g.setColor(Color.GRAY);
			g.drawString("????", xCoor, yCoor);
			g.setColor(Color.WHITE);
			g.fillRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
			g.setColor(Color.GRAY);
			g.drawRect(xCoor, yCoor + 5, WIDTH, HEIGHT);
		}
	}
	
	public int getSkillLevel(){
		return skillLevel;
	}
	
	public void setSkillLevel(int s){
		skillLevel = s;
	}
	
	public void train(int increase){
		if(unlocked && available){
			skillLevel = skillLevel + increase;
			if(skillLevel > 100){
				skillLevel = 100;
			}
			if(parent != null){
				if(skillLevel > parent.getSkillLevel()){
					skillLevel = parent.getSkillLevel();
				}
			}
		}
	}
	
	public void unlock(){
		unlocked = true;
	}
	
	public void lock(){
		unlocked = false;
	}
	
	public void setLock(boolean l){
		unlocked = l;
	}
	
	public boolean getLock(){
		return unlocked;
	}
	
	public void setAvailable(boolean a){
		available = a;
	}
	
	public boolean available(){
		return available;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
