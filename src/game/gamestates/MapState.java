package game.gamestates;

import game.blueprints.Map;
import game.maps.MapGUIHandler;

import java.awt.Graphics;

public class MapState extends GameState{
	
	GameStateManager gsm;
	Map map;
	MapGUIHandler mapHandler;

	public MapState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}
	
	public MapState(GameStateManager gsm, Map map, MapGUIHandler handler){
		super(gsm);
		
		this.gsm = gsm;
		this.map = map;
		mapHandler = handler;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		mapHandler.tick();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		mapHandler.draw(g);
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
		mapHandler.mouseMoved(x, y);
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		mapHandler.mouseClicked(x, y);
	}
}
