package background;

import java.util.Random;

public class Weather{
	public static final int CLEAR = 0;
	public static final int DRIZZLE = 1;
	public static final int RAINSTORM = 2;
	public static final int MONSOON = 3;
	public static final int FLURRIES = 4;
	public static final int SNOWFALL = 5;
	public static final int BLIZZARD = 6;
	public static final int CLOUDY = 7;
	public static final int MIN_DURATION = 10;
	public static final int LAST_TYPE = 7;
	private final int THRESHOLD = 2;
	private final int CAP = 10;
	private final int CLEARTHRESH = 4;
	private int weatherType;
	private int timer;
	
	public Weather(int weatherType) {
		this.timer = 0;
		if(weatherType <= LAST_TYPE) {
			this.setWeatherType(weatherType);
		}else {
			this.setWeatherType(Weather.CLEAR);
		}	
	}
	
	public int getWeatherType() {
		return weatherType;
	}
	
	public void update() {
		//increase time spent as current weather
		this.timer++;
		//check to change weather type
		if(this.timer > MIN_DURATION) {
			Random rand = new Random();
			int chk = rand.nextInt(CAP);
			if (chk < THRESHOLD) {
				int clrChk = rand.nextInt(CAP);
				if(clrChk < CLEARTHRESH) {
					setWeatherType(CLEAR);
					timer = 0;
				}else {
					setWeatherType(rand.nextInt(LAST_TYPE + 1));	
					timer = 0;
				}
				
			}

		}
	}
	
	public void setWeatherType(int weatherType) {
		this.weatherType = weatherType;
	}

	@Override
	public String toString() {
		switch(this.weatherType) {
			case 0:
				return "CLEAR";
			case 1:
				return "DRIZZLE";
			case 2:
				return "RAINSTORM";
			case 3:
				return "MONSOON";
			case 4: 
				return "FLURRIES";
			case 5: 
				return "SNOWFALL";
			case 6:
				return "BLIZZARD";
			case 7:
				return "CLOUDY";
			default:
				return "WEATHER_ERROR";
		}
	}
}
