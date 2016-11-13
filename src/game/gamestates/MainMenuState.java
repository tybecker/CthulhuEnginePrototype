package game.gamestates;

import game.blueprints.GraphicButton;
import game.entities.RectangleButton;
import game.gus.GUS;
import game.resources.Images;

import java.awt.Color;
import java.awt.Graphics;

public class MainMenuState extends GameState{

	GraphicButton[] buttons = new RectangleButton[3];
	
	public MainMenuState(GameStateManager gsm){
		super(gsm);
		
		buttons[0] = new RectangleButton(500, 200, 164, 45, 0, 0, 1, 2, true, false, 1, 0);
		buttons[1] = new RectangleButton(532, 300, 98, 45, 1, 0, 1, 2, false, false, 2, 0);
		buttons[2] = new RectangleButton(532, 400, 98, 45, 2, 0, 1, 2, true, false, 3, 0);
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
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, 1200, 700);
		
		g.drawImage(Images.backgrounds[0], 0, 0, 1200, 700, null);
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i].draw(g);
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
		for(int i = 0; i < buttons.length; i++){
			buttons[i].mouseMoved(x, y);
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		int clickCode = 0;
		
		for(int i = 0; i < buttons.length; i++){
			int crc = buttons[i].mouseClicked(x, y);
			if(crc != 0){
				clickCode = crc;
			}
		}
		if(clickCode == 1){
			//This is where you start a new game.  Psuedocode below.
			//Create resources
			//Push resources and gamestate manager into new home state.
			//Profit.
			new GUS(gsm);
		}
		if(clickCode == 2){
			
		}
		if(clickCode == 3){
			System.exit(0);
		}
	}

}
