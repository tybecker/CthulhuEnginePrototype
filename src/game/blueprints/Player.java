package game.blueprints;

import game.resources.Images;

public class Player {
	
	String name;
	String nickName;
	String firstName;
	String lastName;

	Skill[][] skills;
	
	Inventory inventory;
	
	//Prepare the stats thingy.
	int[] stats;
	public final int HP = 0;
	public final int MAX_HP = 1;
	public final int SANITY = 2;
	public final int MAX_SANITY = 3;
	
	public Player(){
		
		//General player info
		name = "Cthulhu Sleuth";
		nickName = "CS";
		firstName = "Cthulhu";
		lastName = "Sleuth";
		
		//Make player stats
		stats = new int[4];
		stats[HP] = 100;
		stats[MAX_HP] = 100;
		stats[SANITY] = 100;
		stats[MAX_SANITY] = 100;
		
		//Make skills.
		skills = new Skill[3][4];
		skills[0][0] = new Skill("Charisma", 0, true, true, null, 200, 200);
		skills[0][1] = new Skill("Sleuth Diplomacy", 0, false, true, skills[0][0], 230, 240);
		skills[0][2] = new Skill("Speaking Easy", 0, false, true, skills[0][0], 230, 280);
		skills[0][3] = new Skill("Flapping Gums", 0, false, true, skills[0][0], 230, 320);
		
		skills[1][0] = new Skill("Imagination", 0, true, true, null, 500, 200);
		skills[1][1] = new Skill("Couch Forts", 0, false, true, skills[1][0], 530, 240);
		skills[1][2] = new Skill("Freudian Doppleganging", 0, false, true, skills[1][0], 530, 280);
		skills[1][3] = new Skill("Yog Sotherie", 0, false, true, skills[1][0], 530, 320);
		
		skills[2][0] = new Skill("Vim", 0, true, true, null, 800, 200);
		skills[2][1] = new Skill("Fisticuffs", 0, false, true, skills[2][0], 830, 240);
		skills[2][2] = new Skill("Even Lift", 0, false, true, skills[2][0], 830, 280);
		skills[2][3] = new Skill("No Sell", 0, false, true, skills[2][0], 830, 320);
		
		//Make Inventory
		inventory = new Inventory();
		inventory.addItem(new Item(1, "Magnifying Glass", 0));
	}
	
	public Skill[][] getSkills(){
		return skills;
	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNick(){
		return nickName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int[] getStats(){
		return stats;
	}
	
	public int getHP(){
		return stats[HP];
	}
	
	public int getMaxHP(){
		return stats[MAX_HP];
	}
	
	public int getSanity(){
		return stats[SANITY];
	}
	
	public int getMaxSanity(){
		return stats[MAX_SANITY];
	}
	
	public boolean hasAvailableSkill(){
		for(int i = 0; i < skills.length; i++){
			for(int j = 0; j < skills[0].length; j++){
				if(skills[i][j].available() && skills[i][j].getLock()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasAvailableWork(){
		return false;
	}
	
	public boolean notTrapped(){
		return true;
	}
	
	public boolean canRest(){
		return true;
	}
}
