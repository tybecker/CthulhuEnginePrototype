package game.blueprints;

import game.resources.Images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ScheduleElement {
	public int day;
	public final static int MONDAY = 1;
	public final static int TUESDAY = 2;
	public final static int WEDNESDAY = 3;
	public final static int THURSDAY = 4;
	public final static int FRIDAY = 5;
	public final static int SATURDAY = 6;
	public final static int SUNDAY = 7;
	
	public int dayTime;
	public final static int MORNING = 1;
	public final static int AFTERNOON = 2;
	public final static int EVENIN = 3;
	
	public int elementType;
	public final static int EMPTY = 0;
	public final static int TRAINING = 1;
	public final static int WORKING = 2;
	public final static int EXPLORING = 3;
	public final static int RESTING = 4;
	public final static int STORY = 5;
	
	public int trainingType;
	public final static int NOT_TRAINING = 0;
	public final static int CHARISMA = 1;
	public final static int SLEUTH_DIPLOMACY = 4;
	public final static int SPEAKING_EASY = 5;
	public final static int FLAPPING_GUMS = 6;
	public final static int IMAGINATION = 2;
	public final static int COUCH_FORTS = 7;
	public final static int FREUDIAN_DOPPLEGANGING = 8;
	public final static int YOG_SOTHERIE = 9;
	public final static int VIM = 3;
	public final static int FISTICUFFS = 10;
	public final static int EVEN_LIFT = 11;
	public final static int NO_SELL = 12;
	
	public int workingType;
	public final static int NOT_WORKING = 0;
	
	public int exploringType;
	public final static int NOT_EXPLORING = 0;
	public final static int INNSMOUTH = 1;
	public final static int ARKHAM = 2;
	
	public int restingType;
	public final static int NOT_RESTING = 0;
	public final static int SLEEPING = 1;
	public final static int READING = 2;
	
	public int storyType;
	public final static int NOT_STORY = 0;
	
	public BufferedImage image;
	
	public ScheduleElement(){
		elementType = 0;
		trainingType = 0;
		workingType = 0;
		exploringType = 0;
		restingType = 0;
		storyType = 0;
		day = MONDAY;
		dayTime = MORNING;
	}
	
	public int getElementType(){
		return elementType;
	}
	
	public void setElementType(int type){
		elementType = type;
	}
	
	public int getElementSubtype(){
		if(elementType == EMPTY){
			return 0;
		}else if(elementType == TRAINING){
			return trainingType;
		}else if(elementType == WORKING){
			return workingType;
		}else if(elementType == EXPLORING){
			return exploringType;
		}else if(elementType == RESTING){
			return restingType;
		}else if(elementType == RESTING){
			return storyType;
		}else{
			return 0;
		}
	}
	
	public void setElementSubtype(int subType){
		if(elementType == EMPTY){
			
		}else if(elementType == TRAINING){
			trainingType = subType;
		}else if(elementType == WORKING){
			workingType = subType;
		}else if(elementType == EXPLORING){
			exploringType = subType;
		}else if(elementType == RESTING){
			restingType = subType;
		}else if(elementType == RESTING){
			storyType = subType;
		}
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	public int getDayTime(){
		return dayTime;
	}
	
	public void setDayTime(int dayTime){
		this.dayTime = dayTime;
	}
	
	public void draw(Graphics g, int x, int y, int width, int height){
		if(elementType == EMPTY){
			
		}else if(elementType == TRAINING){
			if(trainingType == CHARISMA){
				g.drawImage(Images.buttons[7][0], x, y, width, height, null);
			}else if(trainingType == SLEUTH_DIPLOMACY){
				g.drawImage(Images.buttons[8][0], x, y, width, height, null);
			}else if(trainingType == SPEAKING_EASY){
				g.drawImage(Images.buttons[9][0], x, y, width, height, null);
			}else if(trainingType == FLAPPING_GUMS){
				g.drawImage(Images.buttons[10][0], x, y, width, height, null);
			}else if(trainingType == IMAGINATION){
				g.drawImage(Images.buttons[11][0], x, y, width, height, null);
			}else if(trainingType == COUCH_FORTS){
				g.drawImage(Images.buttons[12][0], x, y, width, height, null);
			}else if(trainingType == FREUDIAN_DOPPLEGANGING){
				g.drawImage(Images.buttons[13][0], x, y, width, height, null);
			}else if(trainingType == YOG_SOTHERIE){
				g.drawImage(Images.buttons[14][0], x, y, width, height, null);
			}else if(trainingType == VIM){
				g.drawImage(Images.buttons[15][0], x, y, width, height, null);
			}else if(trainingType == FISTICUFFS){
				g.drawImage(Images.buttons[16][0], x, y, width, height, null);
			}else if(trainingType == EVEN_LIFT){
				g.drawImage(Images.buttons[17][0], x, y, width, height, null);
			}else if(trainingType == NO_SELL){
				g.drawImage(Images.buttons[18][0], x, y, width, height, null);
			}
		}else if(elementType == WORKING){
			
		}else if(elementType == EXPLORING){
			if(exploringType == INNSMOUTH){
				g.drawImage(Images.buttons[19][0], x, y, width, height, null);
			}else if(exploringType == ARKHAM){
				g.drawImage(Images.buttons[20][0], x, y, width, height, null);
			}
		}else if(elementType == RESTING){
			if(restingType == SLEEPING){
				g.drawImage(Images.buttons[21][0], x, y, width, height, null);
			}else if(restingType == READING){
				g.drawImage(Images.buttons[22][0], x, y, width, height, null);
			}
		}else if(elementType == STORY){
			
		}
	}
}
