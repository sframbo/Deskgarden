package background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Biome {
	public static final int FOREST = 0;
	public static final int PLAINS = 1;
	public static final int DESERT = 2;
	public static final int TROPICAL_ISLAND = 3;
	public static final int JUNGLE = 4;
	public static final int MOUNTAIN = 5;
	public static final int CITY = 6;
	public static final int RIVER = 7;
	
	public static final int LAST_TYPE= 7;
	
	private final int RARETHRESH = 2;
	private final int MTNTHRESH = 6;
	private final int CAP = 10;
	private final int RARCHKVAL = 100;
	
	private int biomeType;
	private Weather weather;
	private ArrayList<Animal> allowedAnimals;
	
	public Biome(int biomeType) {
		this.weather = new Weather(Weather.CLEAR);
		if(biomeType <= LAST_TYPE) {
			this.setBiomeType(biomeType);
		}else { 
			this.setBiomeType(Biome.FOREST) ;
		}
		this.allowedAnimals = new ArrayList<Animal>();
		this.allowedAnimals.add(new Animal());
		switch(this.biomeType) {
			case Biome.FOREST:
				break;
			case Biome.PLAINS:
				break;
			case Biome.DESERT:
				break;
			case Biome.TROPICAL_ISLAND:
				break;
			case Biome.JUNGLE:
				break;
			case Biome.MOUNTAIN:
				break;
			case Biome.CITY:
				break;
			case Biome.RIVER:
				break;
		}
	}

	public int getBiomeType() {
		return biomeType;
	}

	public void setBiomeType(int biomeType) {
		this.biomeType = biomeType;
	}

	public Weather getWeather() {
		return weather;
	}
	//Picks which animal to spawn from the biome's list of allowed animals
	private Animal spawnAnimal() {
		//Identify total animal rarity
		int rarSum = 0;
		//most common animal index location
		int mostCommon = allowedAnimals.size()-1;
		//sort allowed animal list by rarity
		Collections.sort(allowedAnimals, new AnimalSort());
		for(int i = 0; i < allowedAnimals.size(); i++) {
			int curRar = allowedAnimals.get(i).getRarity();
			rarSum += curRar;
		}
		//divide chances into equal intervals
		int rarInterval = RARCHKVAL/rarSum;
		//calculate remainder
		int round = RARCHKVAL - (rarSum * rarInterval);
		int[] weights = new int[allowedAnimals.size()];
		//assign weights
		for(int i = 0; i < allowedAnimals.size(); i++) {
			weights[i] = rarInterval * allowedAnimals.get(i).getRarity();
		}
		//apply remainder
		weights[mostCommon]+=round;
		Random rand = new Random();
		int spawnchk = rand.nextInt();
		for(int i = 0; i < allowedAnimals.size(); i++) {
			if(spawnchk < weights[i]) {
				return allowedAnimals.get(i);
			}
		}
		return allowedAnimals.get(allowedAnimals.size()-1);
	}
	
	public Animal update(boolean aniSpawn) {
		//Controls weather to appropriate biome type
		this.weather.update();
		switch(this.biomeType) {
			case Biome.DESERT:
				if(this.weather.getWeatherType() == Weather.FLURRIES) {
					this.weather.setWeatherType(Weather.CLEAR);
				}else if(this.weather.getWeatherType() == Weather.DRIZZLE || this.weather.getWeatherType() == Weather.CLOUDY) {
					Random rand = new Random();	
					if(rand.nextInt(CAP) > RARETHRESH) {
						this.weather.setWeatherType(Weather.CLEAR);
					}
				}
				break;
			case Biome.MOUNTAIN:
				if(this.weather.getWeatherType() == Weather.FLURRIES) {
					Random rand = new Random();
					if(rand.nextInt(CAP) > MTNTHRESH) {
						this.weather.setWeatherType(Weather.SNOWFALL);
					}
				}
				if(this.weather.getWeatherType() == Weather.DRIZZLE) {
					Random rand = new Random(); 
					if(rand.nextInt(CAP) > MTNTHRESH) {
						this.weather.setWeatherType(Weather.FLURRIES);
					}
				}
				
				break;
			case Biome.TROPICAL_ISLAND:
			case Biome.JUNGLE:
				if(this.weather.getWeatherType() == Weather.FLURRIES) {
					this.weather.setWeatherType(Weather.CLEAR);
				}
				break;
		}
		if(aniSpawn) {
			return spawnAnimal();
		}else {
			return null;
		}
	}
}
