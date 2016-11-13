package game.blueprints;

public interface Map {
	
	//The map should have a name, like "Innsmouth", or "Arkham"
	public String getName();
	
	//This returns an array of all the setPieces on the map
	public SetPiece[] getSetPieces();
	
	//This returns an array of all the setPieces that the player knows about
	public SetPiece[] getKnownSetPieces();
	
	//This returns an array with all the setPieces that the player can visit
	public SetPiece[] getAvailableSetPieces();
	
	//This returns a boolean indicating whether or not the map itself is available
	public boolean mapAvailable();
	
	//This returns an array indicating the condition of the map.
	//Be careful here, I think this one is bad design.
	public int[] getMapConditions();
	
	//Here's a bunch of setters.  I might not use them, but I'd kind of like them there.
	public void setName(String name);
	public void setAvailable(boolean available);
	public void setCondition(int arrayIndex, int condition);
	
}
