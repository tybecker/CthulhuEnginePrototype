package game.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage[][] buttons;
	public static BufferedImage[] backgrounds;
	
	public static BufferedImage[] inventory;
	
	public static BufferedImage[][] cutscenes;
	
	public static BufferedImage[] player;
	
	public Images(){
		//The order for button images is [x][0] = active, [x][1] = hovered, [x][2] = disabled; 
		buttons = new BufferedImage[40][4];
			
		try{
			//Main Menu
			buttons[0][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/NewGameIdle.png"));
			buttons[0][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/NewGameHovered.png"));
			buttons[0][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/NewGameInactive.png"));
			buttons[1][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/LoadIdle.png"));
			buttons[1][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/LoadHovered.png"));
			buttons[1][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/LoadInactive.png"));
			buttons[2][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/ExitIdle.png"));
			buttons[2][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/ExitHovered.png"));
			buttons[2][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_mainmenu/ExitInactive.png"));
			
			//Home Screen
			//General
			buttons[3][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/CharacterIdle.png"));
			buttons[3][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/CharacterHovered.png"));
			buttons[3][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/CharacterSelected.png"));
			buttons[3][3] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/CharacterDisabled.png"));
			
			buttons[4][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/SkillsIdle.png"));
			buttons[4][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/SkillsHovered.png"));
			buttons[4][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/SkillsSelected.png"));
			buttons[4][3] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/SkillsDisabled.png"));
			
			buttons[5][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/InventoryIdle.png"));
			buttons[5][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/InventoryHovered.png"));
			buttons[5][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/InventorySelected.png"));
			buttons[5][3] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/InventoryDisabled.png"));
			
			buttons[6][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/ScheduleIdle.png"));
			buttons[6][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/ScheduleHovered.png"));
			buttons[6][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/ScheduleSelected.png"));
			buttons[6][3] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_home_general/ScheduleDisabled.png"));
			
			//Character
			
			//Inventory
		
			//Skills
		
			//Scheduler //Training
			buttons[7][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/Charisma.png"));
			buttons[8][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/SleuthDiplomacy.png"));
			buttons[9][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/SpeakingEasy.png"));
			buttons[10][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/FlappingGums.png"));
			buttons[11][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/Imagination.png"));
			buttons[12][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/CouchForts.png"));
			buttons[13][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/FreudianDoppleganging.png"));
			buttons[14][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/YogSotherie.png"));
			buttons[15][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/Vim.png"));
			buttons[16][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/Fisticuffs.png"));
			buttons[17][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/EvenLift.png"));
			buttons[18][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_training/NoSell.png"));
			//Exploring
			buttons[19][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_exploring/Innsmouth.png"));
			buttons[20][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_exploring/Arkham.png"));
			//Resting
			buttons[21][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_resting/Sleep.png"));
			buttons[22][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule_resting/Read.png"));
			//UseSchedule
			buttons[23][0] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule/UseScheduleIdle.png"));
			buttons[23][1] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule/UseScheduleHovered.png"));
			buttons[23][2] = ImageIO.read(getClass().getResourceAsStream("/resources_buttons_schedule/UseScheduleInactive.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		backgrounds = new BufferedImage[4];
		
		try{
			backgrounds[0] = ImageIO.read(getClass().getResourceAsStream("/resources_backgrounds_mainmenu/MainMenu.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		inventory = new BufferedImage[20];
		
		try{
			inventory[0] = ImageIO.read(getClass().getResourceAsStream("/resources_items/MagnifyingGlass.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		cutscenes = new BufferedImage[20][6];
		
		try{
			cutscenes[0][0] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene1.png"));
			cutscenes[0][1] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene2.png"));
			cutscenes[0][2] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene3.png"));
			cutscenes[0][3] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene4.png"));
			cutscenes[0][4] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene5.png"));
			cutscenes[0][5] = ImageIO.read(getClass().getResourceAsStream("/resources_cutscenes_cutscene0001/Scene6.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		player = new BufferedImage[10];
		
		try{
			player[0] = ImageIO.read(getClass().getResourceAsStream("/resources_player_pictures/Player.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
