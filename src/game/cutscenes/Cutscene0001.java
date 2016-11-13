package game.cutscenes;

import game.gamestates.GameStateManager;
import game.gus.GUS;
import game.resources.Images;
import game.resources.TextSquare;

import java.awt.Color;
import java.awt.Graphics;

public class Cutscene0001 implements Cutscene{

	int state;
	int timer;
	boolean screenLock;
	public final int SCENE_ONE = 0;
	public final int SCENE_TWO = 1;
	public final int SCENE_THREE = 2;
	public final int SCENE_FOUR = 3;
	public final int SCENE_FIVE = 4;
	public final int SCENE_SIX = 5;
	
	
	GameStateManager gsm;
	GUS gus;
	
	public Cutscene0001(GameStateManager gsm, GUS gus){
		this.gsm = gsm;
		this.gus = gus;
		timer = 0;
		state = SCENE_ONE;
		screenLock = true;
	}
	
	@Override
	public int tick() {
		
		if(timer <= 90){
			timer++;
		}
		if(timer > 90){
			screenLock = false;
		}
		
		return 0;
	}

	@Override
	public int mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(state == SCENE_ONE){
			if(!screenLock){
				state = SCENE_TWO;
				timer = 0;
				screenLock = true;
			}
		}else if(state == SCENE_TWO){
			if(!screenLock){
				state = SCENE_THREE;
				timer = 0;
				screenLock = true;
			}
		}else if(state == SCENE_THREE){
			if(!screenLock){
				state = SCENE_FOUR;
				timer = 0;
				screenLock = true;
			}
		}else if(state == SCENE_FOUR){
			if(!screenLock){
				state = SCENE_FIVE;
				timer = 0;
				screenLock = true;
			}
		}else if(state == SCENE_FIVE){
			if(!screenLock){
				state = SCENE_SIX;
				timer = 0;
				screenLock = true;
			}
		}else if(state == SCENE_SIX){
			if(!screenLock){
				endScene();
			}
		}
		
		return 0;
	}

	@Override
	public int mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(state == SCENE_ONE){
			g.drawImage(Images.cutscenes[0][0], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(240, 540, 740, 35, g, "You are Cthulhu Sleuth, brave and clever detective of all things Eldritch.");
		}
		if(state == SCENE_TWO){
			g.drawImage(Images.cutscenes[0][1], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(300, 540, 580, 35, g, "Today you have no case.  It's time to relax in your office.");
		}
		if(state == SCENE_THREE){
			g.drawImage(Images.cutscenes[0][2], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(90, 540, 1035, 35, g, "No, wait, there's an Innsmouth Dame in your office.  She's wailing something about a missing fiance?");
		}
		if(state == SCENE_FOUR){
			g.drawImage(Images.cutscenes[0][3], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(115, 540, 1000, 35, g, "Her fiance is an Articulate Mechanic that disappeared a few days ago.  No one has seen him since.");
		}
		if(state == SCENE_FIVE){
			g.drawImage(Images.cutscenes[0][4], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(300, 540, 630, 35, g, "You promise to do the job for 20 dollars a day, plus expenses.");
			TextSquare.drawTextBox(270, 580, 690, 35, g, "She gives you enough for the month and includes her contact info.");
		}
		if(state == SCENE_SIX){
			g.drawImage(Images.cutscenes[0][5], 0, 0, 1200, 700, null);
			
			TextSquare.drawTextBox(280, 540, 690, 35, g, "Well, you've got a job to do.  Best schedule your week and get to it!");
		}
	}

	@Override
	public int endScene() {
		// TODO Auto-generated method stub
		gus.setWorldState(GUS.PHASE_ONE);
		gsm.states.pop();
		return 0;
	}
	
}
