package game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.blueprints.GraphicButton;
import game.blueprints.Map;
import game.blueprints.Player;
import game.blueprints.ScheduleElement;
import game.blueprints.Skill;
import game.gus.GUS;

public class ScheduleButton implements GraphicButton{

	BufferedImage currentImage;
	
	public int buttonState;
	final int IDLE = 0;
	final int MENU = 1;
	final int SUB_MENU = 2;
	
	public int subMenu;
	final int NONE = 0;
	final int TRAINING = 1;
	final int WORKING = 2;
	final int EXPLORING = 3;
	final int RESTING = 4;
	final int STORY = 5;
	
	GUS gus;
	ScheduleElement element;
	Player player;
	Map[] world;
	
	int xCoor;
	int yCoor;
	int width;
	int height;
	
	//Menu Buttons
	ScheduleSubButton[] subButtonMenu;
	
	//Training Buttons
	ScheduleSubButton[] subButtonTraining;
	
	//Working Buttons
	ScheduleSubButton[] subButtonWorking;
	
	//Exploring Buttons
	ScheduleSubButton[] subButtonExploring;
	
	//Resting Buttons
	ScheduleSubButton[] subButtonResting;
	
	//Story Buttons
	ScheduleSubButton[] subButtonStory;
	
	public ScheduleButton(GUS g, ScheduleElement e, int x, int y, int w, int h){
		gus = g;
		element = e;
		buttonState = IDLE;
		subMenu = NONE;
		player = gus.getPlayer();
		world = gus.getWorld();
		
		xCoor = x;
		yCoor = y;
		width = w;
		height = h;
		
		//MenuButtons
		subButtonMenu = new ScheduleSubButton[5];
		subButtonMenu[0] = new ScheduleSubButton("Train Skill", x, y, w, h, TRAINING, 0, true);
		subButtonMenu[1] = new ScheduleSubButton("Work Job", x, y, w, h, WORKING, 0, true);
		subButtonMenu[2] = new ScheduleSubButton("Explore", x, y, w, h, EXPLORING, 0, true);
		subButtonMenu[3] = new ScheduleSubButton("Rest", x, y, w, h, RESTING, 0, true);
		subButtonMenu[4] = new ScheduleSubButton("Special", x, y, w, h, STORY, 0, true);
		
		if(player.hasAvailableSkill()){
			subButtonMenu[0].setButtonActive(true);
		}else{
			subButtonMenu[0].setButtonActive(false);
		}
		if(player.hasAvailableWork()){
			subButtonMenu[1].setButtonActive(true);
		}else{
			subButtonMenu[1].setButtonActive(false);
		}
		if(player.notTrapped()){
			subButtonMenu[2].setButtonActive(true);
		}else{
			subButtonMenu[2].setButtonActive(false);
		}
		if(player.canRest()){
			subButtonMenu[3].setButtonActive(true);
		}else{
			subButtonMenu[3].setButtonActive(false);
		}
		if(gus.hasExploreStory()){
			subButtonMenu[4].setButtonActive(true);
		}else{
			subButtonMenu[4].setButtonActive(false);
		}
		int place = 0;
		int subWidth = 100;
		int subHeight = 20;
		int subY = yCoor;
		int subX = xCoor - subWidth - 5;
		for(int i = 0; i < subButtonMenu.length; i++){
			if(subButtonMenu[i].buttonActive()){
				subButtonMenu[i].setXCoordinate(subX);
				subButtonMenu[i].setYCoordinate(subY);
				subButtonMenu[i].setWidth(subWidth);
				subButtonMenu[i].setHeight(subHeight);
				subY = subY + subHeight;
			}else{
				subButtonMenu[i].setWidth(0);
				subButtonMenu[i].setHeight(0);
			}
		}
		
		//subButtonTraining menu
		subButtonTraining = new ScheduleSubButton[21];
		Skill[][] skills = player.getSkills();
		place = 0;
		subWidth = 100;
		subHeight = 20;
		subY = yCoor;
		subX = xCoor - subWidth - 5;
		//Ehhhh... if skill selection fails later, here was the error!
		for(int i = 0; i < skills.length; i++){
			for(int j = 0; j < skills.length; j++){
				if(skills[i][j].available() && skills[i][j].getLock()){
					subButtonTraining[place] = new ScheduleSubButton(skills[i][j].getName(), subX, subY, subWidth, subHeight, i + 1, 0, (skills[i][j].available() && skills[i][j].getLock()));
					subY = subY + subHeight;
					place++;
				}
			}
		}
		
		//subButtonWorking menu
		subButtonWorking = new ScheduleSubButton[2];
		
		
		//subButtonExploring menu
		subButtonExploring = new ScheduleSubButton[3];
		place = 0;
		subWidth = 100;
		subHeight = 20;
		subY = yCoor;
		subX = xCoor - subWidth - 5;
		for(int i = 0; i < world.length; i++){
			if(world[i].mapAvailable()){
				subButtonExploring[place] = new ScheduleSubButton(world[i].getName(), subX, subY, subWidth, subHeight, i + 1, 0, (world[i].mapAvailable()));
				subY = subY +  subHeight;
				place++;
			}
		}
		
		//subButtonResting menu
		subButtonResting = new ScheduleSubButton[2];
		place = 0;
		subWidth = 100;
		subHeight = 20;
		subY = yCoor;
		subX = xCoor - subWidth - 5;
		subButtonResting[0] = new ScheduleSubButton("Sleep", subX, subY, subWidth, subHeight, 1, 0, true);
		subY = subY +  subHeight;
		place++;
		subButtonResting[1] = new ScheduleSubButton("Read", subX, subY, subWidth, subHeight, 2, 0, true);
		
		//subButtonStory menu
		subButtonStory = new ScheduleSubButton[2];
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
			g.drawImage(currentImage, xCoor, yCoor, width, height, null);
			element.draw(g, xCoor, yCoor, width, height);
			g.setColor(Color.BLACK);
			g.drawRect(xCoor, yCoor, width, height);
		if(buttonState == IDLE){
			
		}
		if(buttonState == MENU){
			
			int subWidth = 100;
			int subHeight = 20;
			int subY = yCoor;
			int subX = xCoor - subWidth - 5;
			for(int i = 0; i < subButtonMenu.length; i++){
				if(subButtonMenu[i].buttonActive()){
					subButtonMenu[i].draw(g, subX, subY, subWidth, subHeight);
					//subButtonMenu[i].setXCoordinate(subX);
					//subButtonMenu[i].setYCoordinate(subY);
					//subButtonMenu[i].setHeight(subHeight);
					//subButtonMenu[i].setWidth(subWidth);
					subY = subY + subHeight;
				}
			}
		}
		if(buttonState == SUB_MENU){
			if(subMenu == TRAINING){
				for(int i = 0; i < subButtonTraining.length; i++){
					if(subButtonTraining[i] != null){
						subButtonTraining[i].draw(g, subButtonTraining[i].getXCoordinate(), subButtonTraining[i].getYCoordinate(), subButtonTraining[i].getWidth(), subButtonTraining[i].getHeight());
					}
				}
			}
			if(subMenu == WORKING){
				
			}
			if(subMenu == EXPLORING){
				for(int i = 0; i < subButtonExploring.length; i++){
					if(subButtonExploring[i] != null){
						subButtonExploring[i].draw(g, subButtonExploring[i].getXCoordinate(), subButtonExploring[i].getYCoordinate(), subButtonExploring[i].getWidth(), subButtonExploring[i].getHeight());
					}
				}
			}
			if(subMenu == RESTING){
				for(int i = 0; i < subButtonResting.length; i++){
					if(subButtonResting[i] != null){
						subButtonResting[i].draw(g, subButtonResting[i].getXCoordinate(), subButtonResting[i].getYCoordinate(), subButtonResting[i].getWidth(), subButtonResting[i].getHeight());
					}
				}
			}
			if(subMenu == STORY){
				
			}
		}
	}

	@Override
	public int mouseMoved(int x, int y) {
		
		int hrc = 0;
		
		if(buttonState == IDLE){
			
		}
		if(buttonState == MENU){
			for(int i = 0; i < subButtonMenu.length; i++){
				hrc = subButtonMenu[i].mouseMoved(x, y);
			}
		}
		if(buttonState == SUB_MENU){
			if(subMenu == TRAINING){
				for(int i = 0; i < subButtonTraining.length; i++){
					if(subButtonTraining[i] != null){
						hrc = subButtonTraining[i].mouseMoved(x, y);
					}
				}
			}
			if(subMenu == WORKING){
				for(int i = 0; i < subButtonWorking.length; i++){
					if(subButtonWorking[i] != null){
						hrc = subButtonWorking[i].mouseMoved(x, y);
					}
				}
			}
			if(subMenu == EXPLORING){
				for(int i = 0; i < subButtonExploring.length; i++){
					if(subButtonExploring[i] != null){
						hrc = subButtonExploring[i].mouseMoved(x, y);
					}
				}
			}
			if(subMenu == RESTING){
				for(int i = 0; i < subButtonResting.length; i++){
					if(subButtonResting[i] != null){
						hrc = subButtonResting[i].mouseMoved(x, y);
					}
				}
			}
			if(subMenu == STORY){
				for(int i = 0; i < subButtonStory.length; i++){
					if(subButtonStory[i] != null){
						hrc = subButtonStory[i].mouseMoved(x, y);
					}
				}
			}
		}
		
		return hrc;
	}

	@Override
	public int mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		int crc = 0;
		
		if(buttonState == IDLE){
			if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
				buttonState = MENU;
				crc = 1;
			}
		}else if(buttonState == MENU){
			boolean buttonClicked = false;
			for(int i = 0; i < subButtonMenu.length; i++){
				crc = subButtonMenu[i].mouseClicked(x, y);
				if(crc != 0){
					i = subButtonMenu.length;
					buttonClicked = true;
				}
			}
			if(buttonClicked){
				buttonState = SUB_MENU;
				subMenu = crc;
			}else{
				buttonState = IDLE;
			}
		}else if(buttonState == SUB_MENU){
			boolean buttonClicked = false;
			if(subMenu == TRAINING){
				for(int i = 0; i < subButtonTraining.length; i++){
					if(subButtonTraining[i] != null){
						crc = subButtonTraining[i].mouseClicked(x, y);
						if(crc != 0){
							i = subButtonTraining.length;
							buttonClicked = true;
						}
					}
				}
				element.setElementType(ScheduleElement.TRAINING);
				element.setElementSubtype(crc);
			}
			if(subMenu == WORKING){
				for(int i = 0; i < subButtonWorking.length; i++){
					if(subButtonWorking[i] != null){
						crc = subButtonWorking[i].mouseClicked(x, y);
						if(crc != 0){
							i = subButtonWorking.length;
							buttonClicked = true;
						}
					}
				}
				element.setElementType(ScheduleElement.WORKING);
				element.setElementSubtype(crc);
			}
			if(subMenu == EXPLORING){
				for(int i = 0; i < subButtonExploring.length; i++){
					if(subButtonExploring[i] != null){
						crc = subButtonExploring[i].mouseClicked(x, y);
						if(crc != 0){
							i = subButtonExploring.length;
							buttonClicked = true;
						}
					}
				}
				element.setElementType(ScheduleElement.EXPLORING);
				element.setElementSubtype(crc);
			}
			if(subMenu == RESTING){
				for(int i = 0; i < subButtonResting.length; i++){
					if(subButtonResting[i] != null){
						crc = subButtonResting[i].mouseClicked(x, y);
						if(crc != 0){
							i = subButtonResting.length;
							buttonClicked = true;
						}
					}
				}
				element.setElementType(ScheduleElement.RESTING);
				element.setElementSubtype(crc);
			}
			if(subMenu == STORY){
				for(int i = 0; i < subButtonStory.length; i++){
					if(subButtonStory[i] != null){
						crc = subButtonStory[i].mouseClicked(x, y);
						if(crc != 0){
							i = subButtonStory.length;
							buttonClicked = true;
						}
					}
				}
				element.setElementType(ScheduleElement.STORY);
				element.setElementSubtype(crc);
			}
			
			buttonState = IDLE;
		}
		return crc;
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
		if(x > xCoor && x < xCoor + width && y > yCoor && y < yCoor + height){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean buttonActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setButtonActive(boolean activate) {
		// TODO Auto-generated method stub
		
	}
	
	public void setImage(BufferedImage i){
		currentImage = i;
	}
	
	public void setScheduleValue(int i){
		
	}
	
	public int getScheduleValue(){
		return 0;
	}

	public int getButtonState(){
		return buttonState;
	}
}
