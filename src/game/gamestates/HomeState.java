package game.gamestates;

import game.blueprints.Item;
import game.blueprints.Player;
import game.blueprints.ScheduleElement;
import game.blueprints.Skill;
import game.entities.RectangleButton;
import game.entities.ScheduleButton;
import game.entities.TabbedButton;
import game.gus.GUS;
import game.resources.Images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HomeState extends GameState{
	
	//GUS
	GUS gus;

	//Homestate
	final int CHARACTER_SCREEN = 1;
	final int SKILL_SCREEN = 2;
	final int INVENTORY_SCREEN = 3;
	final int SCHEDULE_SCREEN = 4;
	int currentScreen = CHARACTER_SCREEN;
	
	//General Buttons
	TabbedButton generalButtons[];
	final int CHARACTER_BUTTON = 0;
	final int SKILL_BUTTON = 1;
	final int INVENTORY_BUTTON = 2;
	final int SCHEDULE_BUTTON = 3;
	
	//ScheduleState
	final int SCHEDULE_IDLE = 0;
	final int SCHEDULE_MENU = 1;
	final int SCHEDULE_SUBMENU = 2;
	int scheduleState = SCHEDULE_IDLE;
	
	//ScheduleButtons
	ScheduleButton[][] scheduleButtons;
	final int MONDAY = 0;
	final int TUESDAY = 1;
	final int WEDNESDAY = 2;
	final int THURSDAY = 3;
	final int FRIDAY = 4;
	final int SATURDAY = 5;
	final int SUNDAY = 6;
	final int MORNING = 0;
	final int AFTERNOON = 1;
	final int EVENING = 2;
	int day;
	int dayTime;
	
	RectangleButton useScheduleButton;
	final int USE_RETURN_CODE = 7;
	
	public HomeState(GameStateManager gsm, GUS gus){
		super(gsm);
		
		this.gus = gus;
		
		generalButtons = new TabbedButton[4];
		
		generalButtons[0] = new TabbedButton(50, 10, 173, 41, 3, 0, 1, 2, 3, true, true, false, CHARACTER_SCREEN, CHARACTER_SCREEN);
		generalButtons[1] = new TabbedButton(223, 10, 104, 41, 4, 0, 1, 2, 3, true, false, false, SKILL_SCREEN, SKILL_SCREEN);
		generalButtons[2] = new TabbedButton(327, 10, 173, 41, 5, 0, 1, 2, 3, true, false, false, INVENTORY_SCREEN, INVENTORY_SCREEN);
		generalButtons[3] = new TabbedButton(500, 10, 150, 41, 6, 0, 1, 2, 3, true, false, false, SCHEDULE_SCREEN, SCHEDULE_SCREEN);
		
		scheduleButtons = new ScheduleButton[7][3];
		
		scheduleButtons[MONDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 220, 120, 120, 120);
		scheduleButtons[MONDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 220, 270, 120, 120);
		scheduleButtons[MONDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 220, 420, 120, 120);
		scheduleButtons[TUESDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 350, 120, 120, 120);
		scheduleButtons[TUESDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 350, 270, 120, 120);
		scheduleButtons[TUESDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 350, 420, 120, 120);
		scheduleButtons[WEDNESDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 480, 120, 120, 120);
		scheduleButtons[WEDNESDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 480, 270, 120, 120);
		scheduleButtons[WEDNESDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 480, 420, 120, 120);
		scheduleButtons[THURSDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 610, 120, 120, 120);
		scheduleButtons[THURSDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 610, 270, 120, 120);
		scheduleButtons[THURSDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 610, 420, 120, 120);
		scheduleButtons[FRIDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 740, 120, 120, 120);
		scheduleButtons[FRIDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 740, 270, 120, 120);
		scheduleButtons[FRIDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 740, 420, 120, 120);
		scheduleButtons[SATURDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 870, 120, 120, 120);
		scheduleButtons[SATURDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 870, 270, 120, 120);
		scheduleButtons[SATURDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 870, 420, 120, 120);
		scheduleButtons[SUNDAY][MORNING] = new ScheduleButton(gus, new ScheduleElement(), 1000, 120, 120, 120);
		scheduleButtons[SUNDAY][AFTERNOON] = new ScheduleButton(gus, new ScheduleElement(), 1000, 270, 120, 120);
		scheduleButtons[SUNDAY][EVENING] = new ScheduleButton(gus, new ScheduleElement(), 1000, 420, 120, 120);

		useScheduleButton = new RectangleButton(850, 570, 198, 45, 23, 0, 1, 2, true, false, USE_RETURN_CODE, 0);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1200, 700);
		g.setColor(Color.WHITE);
		g.fillRect(50, 50, 1100, 600);
		g.setColor(Color.BLACK);
		g.drawRect(50, 50, 1100, 600);
		
		for(int i = 0; i < generalButtons.length; i++){
			generalButtons[i].draw(g);
		}
		
		if(currentScreen == CHARACTER_SCREEN){
			Player player = gus.getPlayer();
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			g.drawString("Name: " + player.getName(), 125, 120);
			g.drawString("Alias: " + player.getNick(), 125, 150);
			g.drawString("Profession: Eldritch Sleuth", 125, 180);
			g.drawString("HP: " + player.getHP() + "/" + player.getMaxHP(), 125, 210);
			g.drawString("Sanity: " + player.getSanity() + "/" + player.getMaxSanity(), 125, 240);
			
			g.drawImage(Images.player[0], 730, 100, 264, 517, null);
			
		}
		if(currentScreen == SKILL_SCREEN){
			Player player = gus.getPlayer();
			
			Skill[][] skills = player.getSkills();
			
			for(int i = 0; i < skills.length; i++){
				for(int j = 0; j < skills[0].length; j++){
					skills[i][j].draw(g);
				}
			}
		}
		if(currentScreen == INVENTORY_SCREEN){
			Item[] items = gus.getPlayer().getInventory().getItems();
			int x = 0;
			int y = 0;
			
			
			for(int i = 0; i < items.length; i++){
				if(items[i] != null){
					items[i].draw(g, (x * 170) + 100, (y * 170) + 100, 150, 150);
				}
				if(x != 5){
					x++;
				}else{
					x = 0;
					y++;
				}
			}
		}
		if(currentScreen == SCHEDULE_SCREEN){
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			g.drawString("Morning", 100, 140);
			g.drawString("Afternoon", 100, 290);
			g.drawString("Evening", 100, 440);
			g.drawString("Monday", 220, 100);
			g.drawString("Tuesday", 350, 100);
			g.drawString("Wednesday", 480, 100);
			g.drawString("Thursday", 610, 100);
			g.drawString("Friday", 740, 100);
			g.drawString("Saturday", 870, 100);
			g.drawString("Sunday", 1000, 100);
			
			for(int i = 0; i < scheduleButtons.length; i++){
				for(int j = 0; j < scheduleButtons[0].length; j++){
					scheduleButtons[i][j].draw(g);
				}
			}
			
			useScheduleButton.draw(g);
			
			if(scheduleState == SCHEDULE_IDLE){
				
			}
			if(scheduleState == SCHEDULE_MENU){
				
			}
			if(scheduleState == SCHEDULE_SUBMENU){
				
			}
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		for(int i = 0; i < generalButtons.length; i++){
			generalButtons[i].mouseMoved(x, y);
		}
		if(currentScreen == SCHEDULE_SCREEN){
			for(int i = 0; i < scheduleButtons.length; i++){
				for(int j = 0; j < scheduleButtons[0].length; j++){
					scheduleButtons[i][j].mouseMoved(x, y);
				}
			}
			useScheduleButton.mouseMoved(x, y);
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		int clickCode = 0;
		for(int i = 0; i < generalButtons.length; i++){
			int crc = generalButtons[i].mouseClicked(x, y);
			if(crc != 0){
				clickCode = crc;
			}
		}
		
		if(clickCode == CHARACTER_SCREEN){
			currentScreen = CHARACTER_SCREEN;
			for(int i = 0; i < generalButtons.length; i++){
				generalButtons[i].setButtonSelected(false);
			}
			generalButtons[CHARACTER_BUTTON].setButtonSelected(true);
		}
		if(clickCode == SKILL_SCREEN){
			currentScreen = SKILL_SCREEN;
			for(int i = 0; i < generalButtons.length; i++){
				generalButtons[i].setButtonSelected(false);
			}
			generalButtons[SKILL_BUTTON].setButtonSelected(true);
		}
		if(clickCode == INVENTORY_SCREEN){
			currentScreen = INVENTORY_SCREEN;
			for(int i = 0; i < generalButtons.length; i++){
				generalButtons[i].setButtonSelected(false);
			}
			generalButtons[INVENTORY_BUTTON].setButtonSelected(true);
		}
		if(clickCode == SCHEDULE_SCREEN){
			currentScreen = SCHEDULE_SCREEN;
			for(int i = 0; i < generalButtons.length; i++){
				generalButtons[i].setButtonSelected(false);
			}
			generalButtons[SCHEDULE_BUTTON].setButtonSelected(true);
		}
		
		if(currentScreen == SCHEDULE_SCREEN){
			clickCode = 0;
			
			if(scheduleState == SCHEDULE_IDLE){
				for(int i = 0; i < scheduleButtons.length; i++){
					for(int j = 0; j < scheduleButtons[0].length; j++){
						int crc = scheduleButtons[i][j].mouseClicked(x, y);
						if(crc != 0){
							clickCode = crc;
						}
					}
				}
				if(clickCode != 0){
					scheduleState = SCHEDULE_MENU;
				}else{
					int crc = useScheduleButton.mouseClicked(x, y);
					if(crc != 0){
						ScheduleButton[] inputStoryButtons = new ScheduleButton[21];
						int place = 0;
						for(int i = 0; i < scheduleButtons.length; i++){
							for(int j = 0; j < scheduleButtons[0].length; j++){
								inputStoryButtons[place] = scheduleButtons[i][j];
								place++;
							}
						}
						gus.advanceStory(GUS.INPUT_CALENDAR, inputStoryButtons);
					}
				}
			}else if(scheduleState == SCHEDULE_MENU){
				for(int i = 0; i < scheduleButtons.length; i++){
					for(int j = 0; j < scheduleButtons[0].length; j++){
						if(scheduleButtons[i][j].getButtonState() == SCHEDULE_MENU){
							int crc = scheduleButtons[i][j].mouseClicked(x, y);
							if(crc != 0){
								clickCode = crc;
							}
						}
					}
				}
				if(clickCode != 0){
					scheduleState = SCHEDULE_SUBMENU;
				}else{
					scheduleState = SCHEDULE_IDLE;
				}
			}else if(scheduleState == SCHEDULE_SUBMENU){
				for(int i = 0; i < scheduleButtons.length; i++){
					for(int j = 0; j < scheduleButtons[0].length; j++){
						if(scheduleButtons[i][j].getButtonState() == SCHEDULE_SUBMENU){
							int crc = scheduleButtons[i][j].mouseClicked(x, y);
							if(crc != 0){
								clickCode = crc;
							}
						}
					}
				}
				scheduleState = SCHEDULE_IDLE;
			}
		}
	}

}
