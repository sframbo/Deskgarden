package background;

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
	private final int CAP = 10;
	
	private int biomeType;
	private Weather weather;
	
	public Biome(int biomeType) {
		this.weather = new Weather(Weather.CLEAR);
		if(biomeType <= LAST_TYPE) {
			this.setBiomeType(biomeType);
		}else {
			this.setBiomeType(Biome.PLAINS);
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
	
	public void update() {
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
			case Biome.TROPICAL_ISLAND:
			case Biome.JUNGLE:
				if(this.weather.getWeatherType() == Weather.FLURRIES) {
					this.weather.setWeatherType(Weather.CLEAR);
				}
				break;
		}
	}
}
