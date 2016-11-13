package game.maps;

import game.blueprints.Map;
import game.blueprints.SetPiece;

public class MapArkham implements Map{

	public MapArkham(){
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Arkham";
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
		return false;
	}

	@Override
	public int[] getMapConditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAvailable(boolean available) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCondition(int arrayIndex, int condition) {
		// TODO Auto-generated method stub
		
	}

}
