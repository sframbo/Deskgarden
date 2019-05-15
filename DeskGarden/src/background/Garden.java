package background;

import java.util.ArrayList;

public class Garden {
	
	private String biome;
	private String name;
	private int hp;
	private ArrayList<Plant> plants;
	private ArrayList<String> whitelist;
	private ArrayList<String> blacklist;
	
	public Garden(String biome, String name, Plant plant, ArrayList<String> whitelist, ArrayList<String> blacklist) {
		this.name = name;
		this.plants = new ArrayList<Plant>();
		this.plants.add(plant);	
		this.hp = plant.getHP();
		this.whitelist = whitelist;
		this.blacklist = blacklist;
		this.biome = biome;
	}
	public Garden(String biome, String name, ArrayList<Plant> plants, ArrayList<String> whitelist, ArrayList<String> blacklist) {
		this.name = name;
		this.whitelist = whitelist;
		this.blacklist = blacklist;
		this.biome = biome;
		this.plants = plants;
		this.hp = 0;
		this.calcHP();
	}
	public void syncWhitelist(Garden other) {
		this.whitelist = other.getWhitelist();
	}
	public void syncBlacklist(Garden other) {
		this.blacklist = other.getBlacklist();
	}
	public void addPlant(Plant plant) {
		this.plants.add(plant);
	}
	public void addPlants(ArrayList<Plant> plantList) {
		for(int i = 0; i < plantList.size(); i++) {
			this.plants.add(plantList.get(i));
		}
	}
	public void removePlant(Plant plant) {
		if(this.plants.contains(plant)) {
			this.plants.remove(plant);
		}
	}
	public void calcHP() {
		int gardenHealth = 0;
		for(int i = 0; i < this.plants.size(); i++) {
			gardenHealth+=this.plants.get(i).getHP();
		}
		this.hp = gardenHealth;
	}
	public String getBiome() {
		return biome;
	}

	public void setBiome(String biome) {
		this.biome = biome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ArrayList<Plant> getPlants() {
		return plants;
	}

	public void setPlants(ArrayList<Plant> plants) {
		this.plants = plants;
	}

	public ArrayList<String> getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(ArrayList<String> whitelist) {
		this.whitelist = whitelist;
	}

	public ArrayList<String> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(ArrayList<String> blacklist) {
		this.blacklist = blacklist;
	}

}
