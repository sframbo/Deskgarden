package background;

import java.util.ArrayList;
import java.util.Random;

public class Garden {
	
	private Biome biome;
	private String name;
	private int hp;
	private ArrayList<Plant> plants;
	private ArrayList<String> whiteList;
	private ArrayList<String> blackList;
	private ArrayList<Animal> animals;
	private ProcessParser parser;
	private int blackMult;
	private int whiteMult;
	
	private final int MAXANI = 10;
	private final int MAXATT = 40;
	private final int MAXRAND = 101;
	
	
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
		this.animals = new ArrayList<Animal>();
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
		this.animals = new ArrayList<Animal>();
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
		this.animals = new ArrayList<Animal>();
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
		this.animals = new ArrayList<Animal>();
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
	
	private boolean chkAnimal() {
		//make sure not to exceed number cap
		if(this.animals.size() == MAXANI) {
			return false;
		}
		//add up rarity values
		int rarSum = 0;
		for(int i = 0; i < this.plants.size(); i++) {
			rarSum+=plants.get(i).getAnimalAttract();
		}
		//cap spawn rate to max amount
		if(rarSum > MAXATT) {
			rarSum = MAXATT;
		}
		//RNG to see if an animal is spawned
		Random rand = new Random();
		int chk = rand.nextInt(MAXRAND);
		return chk < rarSum;		
	}
	
	
	public void update() {
		//check running process against lists
		int white = this.parser.checkWhiteList();
		int black = this.parser.checkBlackList();
		int score = white*whiteMult - black*blackMult;
		//apply score check to plants
		for(int i = 0; i < this.plants.size(); i++) {
			plants.get(i).update(score);
		}
		//determine garden health
		this.calcHP();
		//update list of animals
		if(this.animals.size() > 0) {
			for(int i = 0; i < this.animals.size(); i++) {
				Animal chk = this.animals.get(i);
				boolean keep = chk.update(this.getHp());
				if(!keep) {
					System.out.println("REMOVING: " + i + " " + this.animals.get(i));
					this.animals.remove(i);
				}
			}
		}
		//determines if an animal is spawned, and if so, tells the biome to do so.
		boolean chkSpawn = chkAnimal();
		if(chkSpawn) {
			this.animals.add(new Animal(this.biome.update(chkSpawn)));
			System.out.println("NEW ANIMAL: " + (this.animals.size()-1) + " " + this.animals.get(this.animals.size()-1));
		}else {
			this.biome.update(chkSpawn);
		}
		//refresh process list	
		this.parser.updateList();
	}
	
	public Weather getWeather() {
		return this.biome.getWeather();
	}
	public ArrayList<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
}
