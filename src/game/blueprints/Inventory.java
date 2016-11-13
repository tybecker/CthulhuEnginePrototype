package game.blueprints;

public class Inventory {
	
	Item[] items;
	
	public Inventory(){
		items = new Item[20];
		
	}
	
	public void addItem(Item item){
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = item;
				i = items.length;
			}
		}
	}
	
	public boolean hasItem(Item item){
		for(int i = 0; i < items.length; i++){
			if(item.getItemID() == items[i].getItemID()){
				return true;
			}
		}
		return false;
	}
	
	public void removeItem(Item item){
		boolean itemFound = false;
		for(int i = 0; i < items.length; i++){
			if(itemFound){
				if(i < items.length - 1){
					items[i] = items[i + 1];
				}
			}else{
				if(items[i].getItemID() == item.getItemID()){
					itemFound = true;
					items[i] = null;
					if(i < items.length - 1){
						items[i] = items[i + 1];
					}
				}
			}
		}
	}
	
	public Item[] getItems(){
		return items;
	}
}
