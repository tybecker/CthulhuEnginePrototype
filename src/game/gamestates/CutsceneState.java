package game.gamestates;

import game.cutscenes.Cutscene;

import java.awt.Graphics;

public class CutsceneState extends GameState{

	public Cutscene cs;
	
	public CutsceneState(GameStateManager gsm, Cutscene cs){
		super(gsm);
		this.cs = cs;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		cs.tick();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		cs.draw(g);
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
		cs.mouseMoved(x, y);
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		cs.mouseClicked(x, y);
	}

}
