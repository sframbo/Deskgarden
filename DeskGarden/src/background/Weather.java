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
	public static final int WINDY = 8;
	
	public static final int MIN_DURATION = 10;
	public static final int LAST_TYPE = 8;
	
	private final int CAP = 10;
	private final int MOVTHRESH = 5;
	private final int CLEARTHRESH = 2;
	private final int WINDTHRESH = 1;
	private final int T0THRESH = 6;
	private final int T1THRESH = 3;
	private final int T2THRESH = 4;
	private final int T3THRESH = 8;
	
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
	/**
	 * Updates weather to next valid state based on thresholds specified in constants.
	 */
	public void update() {
		//increase time spent as current weather
		this.timer++;
		//check to change weather type to next stages
		if(this.timer > MIN_DURATION) {
			this.timer = 0;
			Random rand = new Random();			
			int movChk = rand.nextInt(CAP);
			if(movChk < MOVTHRESH) {
				int chk = rand.nextInt(CAP);
				switch(this.weatherType) {
				case CLEAR:
					if(chk < CLEARTHRESH) {
						int clrChk = rand.nextInt(WINDTHRESH);
						if(clrChk < WINDTHRESH) {
							this.weatherType = Weather.WINDY;
						}else {
							this.weatherType = Weather.CLOUDY;
						}
					}
					break;
				case DRIZZLE:
					if(chk < T1THRESH) {
						this.weatherType = Weather.RAINSTORM;
					}else {
						int clrChk = rand.nextInt(WINDTHRESH);
						if(clrChk < WINDTHRESH) {
							this.weatherType = Weather.WINDY;
						}else {
							this.weatherType = Weather.CLOUDY;
						}
					}
					break;
				case RAINSTORM:
					if(chk < T2THRESH) {
						this.weatherType = Weather.MONSOON;
					}else {
						this.weatherType = Weather.DRIZZLE;
					}
					break;
				case MONSOON:
					if(chk < T3THRESH) {
						this.weatherType = Weather.RAINSTORM;
					}
					break;
				case FLURRIES:
					if(chk < T1THRESH) {
						this.weatherType = Weather.SNOWFALL;
					}else {
						int clrChk = rand.nextInt(WINDTHRESH);
						if(clrChk < WINDTHRESH) {
							this.weatherType = Weather.WINDY;
						}else {
							this.weatherType = Weather.CLOUDY;
						}
					}
					break;
				case SNOWFALL: 
					if(chk < T2THRESH) {
						this.weatherType = Weather.BLIZZARD;
					}else {
						this.weatherType = Weather.FLURRIES;
					}
					break;
				case BLIZZARD:
					if(chk < T3THRESH) {
						this.weatherType = Weather.SNOWFALL;
					}
					break;
				case WINDY:
				case CLOUDY:
					if(chk < T0THRESH) {
						this.weatherType = Weather.CLEAR;
					}else {
						int rnChk = rand.nextInt(WINDTHRESH);
						if(rnChk < WINDTHRESH) {
							this.weatherType = Weather.DRIZZLE;
						}else {
							this.weatherType = Weather.FLURRIES;
						}
					}
					break;
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
			case CLEAR:
				return "CLEAR";
			case DRIZZLE:
				return "DRIZZLE";
			case RAINSTORM:
				return "RAINSTORM";
			case MONSOON:
				return "MONSOON";
			case FLURRIES: 
				return "FLURRIES";
			case SNOWFALL: 
				return "SNOWFALL";
			case BLIZZARD:
				return "BLIZZARD";
			case CLOUDY:
				return "CLOUDY";
			case WINDY:
				return "WINDY";
			default:
				return "WEATHER_ERROR";
		}
	}
}
