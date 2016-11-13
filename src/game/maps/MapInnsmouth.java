package game.maps;

import game.blueprints.Map;
import game.blueprints.SetPiece;

public class MapInnsmouth implements Map{

	String name;
	SetPiece[] setPieces;
	boolean available;
	
	//Here's the map states:
	int[] mapStates = new int[20];
	
	//First, we'll define what each state means.
	final int WEATHER = 0;
	final int ROADSOPEN = 1;
	
	//Then we define the possible states of each state.
	//Weather
	final int SUN = 0;
	final int SNOW = 1;
	final int RAIN = 2;
	final int CLOUDY = 3;
	final int WINDY = 4;
	
	//Roads open
	final int OPEN = 0;
	final int BLOCKADED = 1;
	final int FLOODED = 2;
	final int MONSTERS = 3;
	final int DESTROYED = 4;
	
	public MapInnsmouth(){
		name = "Innsmouth";
		available = true;
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Innsmouth";
	}

	@Override
	public SetPiece[] getSetPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetPiece[] getKnownSetPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetPiece[] getAvailableSetPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mapAvailable() {
		// TODO Auto-generated method stub
		return available;
	}

	@Override
	public int[] getMapConditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setAvailable(boolean available) {
		// TODO Auto-generated method stub
		this.available = available;
	}

	@Override
	public void setCondition(int arrayIndex, int condition) {
		// TODO Auto-generated method stub
		mapStates[arrayIndex] = condition;
	}

}
