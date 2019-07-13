package background;

import java.util.ArrayList;

public class Garden {
	
	private Biome biome;
	private String name;
	private int hp;
	private ArrayList<Plant> plants;
	private ArrayList<String> whiteList;
	private ArrayList<String> blackList;
	private ProcessParser parser;
	private int blackMult;
	private int whiteMult;
	private Weather weather;
	
	
	public Garden(Biome biome, String name, Plant plant, ArrayList<String> whiteList, ArrayList<String> blackList, int blackMult, int whiteMult) {
		this.name = name;
		this.plants = new ArrayList<Plant>();
		this.plants.add(plant);	
		this.hp = plant.getHP();
		this.whiteList = whiteList;
		this.blackList = blackList;
		this.biome = biome;
		this.parser = new ProcessParser(blackList, whiteList);
		this.blackMult = blackMult;
		this.whiteMult = whiteMult;
		this.weather = new Weather(Weather.CLEAR);
	}
	public Garden(Biome biome, String name, Plant plant, ArrayList<String> whiteList, ArrayList<String> blackList) {
		this.name = name;
		this.plants = new ArrayList<Plant>();
		this.plants.add(plant);	
		this.hp = plant.getHP();
		this.whiteList = whiteList;
		this.blackList = blackList;
		this.biome = biome;
		this.parser = new ProcessParser(blackList, whiteList);
		this.blackMult = 1;
		this.whiteMult = 1;
		this.weather = new Weather(Weather.CLEAR);
	}
	public Garden(Biome biome, String name, ArrayList<Plant> plants, ArrayList<String> whiteList, ArrayList<String> blackList, int blackMult, int whiteMult) {
		this.name = name;
		this.whiteList = whiteList;
		this.blackList = blackList;
		this.biome = biome;
		this.plants = plants;
		this.hp = 0;
		this.parser = new ProcessParser(blackList, whiteList);
		this.calcHP();
		this.blackMult = blackMult;
		this.whiteMult = whiteMult;
		this.weather = new Weather(Weather.CLEAR);
	}
	public Garden(Biome biome, String name, ArrayList<Plant> plants, ArrayList<String> whiteList, ArrayList<String> blackList) {
		this.name = name;
		this.whiteList = whiteList;
		this.blackList = blackList;
		this.biome = biome;
		this.plants = plants;
		this.hp = 0;
		this.parser = new ProcessParser(blackList, whiteList);
		this.calcHP();
		this.blackMult = 1;
		this.whiteMult = 1;
		this.weather = new Weather(Weather.CLEAR);
	}
	public void syncWhiteList(Garden other) {
		this.whiteList = other.getWhiteList();
	}
	public void syncBlackList(Garden other) {
		this.blackList = other.getBlackList();
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
	public Biome getBiome() {
		return biome;
	}

	public void setBiome(Biome biome) {
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

	public ArrayList<String> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(ArrayList<String> whiteList) {
		this.whiteList = whiteList;
	}

	public ArrayList<String> getBlackList() {
		return blackList;
	}

	public void setBlackList(ArrayList<String> blackList) {
		this.blackList = blackList;
	}

	public void update() {
		int white = this.parser.checkWhiteList();
		int black = this.parser.checkBlackList();
		int score = white*whiteMult - black*blackMult;
		for(int i = 0; i < this.plants.size(); i++) {
			plants.get(i).update(score);
		}
		this.calcHP();
		this.weather.update();
		this.parser.updateList();
	}
	
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
}
