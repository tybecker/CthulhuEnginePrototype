package game.gus;

import game.blueprints.Map;
import game.blueprints.Player;
import game.cutscenes.Cutscene0001;
import game.data.GameDataPuller;
import game.entities.ScheduleButton;
import game.gamestates.CutsceneState;
import game.gamestates.GameStateManager;
import game.gamestates.HomeState;
import game.maps.MapArkham;
import game.maps.MapInnsmouth;

public class GUS {

	//Worldstats;
	int worldState;
	int week;
	public static final int INTRO_SCENE = 0;
	public static final int PHASE_ONE = 1;
	public static final int PHASE_TWO = 2;
	public static final int PHASE_THREE = 3;
	
	//Player
	Player player;
	
	//Map
	Map[] maps;
	
	//Input sources
	int inputSource;
	public static final int INPUT_CALENDAR = 0;	//The calendar will need to work through the GUS
	public static final int INPUT_MAP = 1;			//The map will need to work through the GUS
	public static final int INPUT_CONVERSATION = 2;//Conversations will need to work through the GUS
	public static final int INPUT_BATTLE = 3;		//Battles will need to work through the GUS
	public static final int INPUT_CUSTOM = 4;		//Custom screens should end with input to the GUS
	
	//Finally, we'll need a gamestatemanager
	public GameStateManager gsm;
	
	public GUS(GameStateManager gsm){
		//Make Player
		player = new Player();
		
		//Make World
		worldState = INTRO_SCENE;
		week = 1;
		//Make setpieces
		
		
		//Make maps
		maps = new Map[2];
		maps[0] = new MapInnsmouth();
		maps[1] = new MapArkham();
		
		
		//Get NPCs from setpieces, then make free NPCs.
		
		
		//Place setpieces on map
		
		
		//Game State Manager
		this.gsm = gsm;
		
		gsm.states.push(new HomeState(gsm, this));
		gsm.states.push(new CutsceneState(gsm, new Cutscene0001(gsm, this)));
	}
	
	public GUS(GameDataPuller g){
		//Make Player
		
		//Make World
		
		//Make setpieces
		
		//Get NPCs from setpieces, then make free NPCs.
		
		//Place setpieces on map
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Map[] getWorld(){
		return maps;
	}
	
	public int getWeek(){
		return week;
	}
	
	public boolean hasExploreStory(){
		return false;
	}
	
	public int getWorldState(){
		return worldState;
	}
	
	public void setWorldState(int state){
		worldState = state;
	}
	
	public void advanceStory(int inputSource){
		
	}
	
	public void advanceStory(int inputSource, ScheduleButton[] scheduleButtons){
		if(inputSource != INPUT_CALENDAR){
			System.out.println("Well, I'm not sure how you did this, but you clearly fed the story input to the wrong part of GUS.");
		}else{
			boolean special = false;
			boolean story = false;
			//First step:  sort the inputs.  This will always happen!
			//Second step:  Check the inputs for storyline, in case you need to go special.
			//Third step:  Check for special world and week conditions
			//Fourth step:  Activate the story handler state that coincides with your condition.  There should be three.  Let's call them Story, Special, and Standard
			
			
			
			if(story){
				//Story
			}else if(special){
				//Special
			}else{
				//Standard
				
			}
		}
	}
}
