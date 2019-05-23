 package background;

public class Weather{
	public static final int CLEAR = 0;
	public static final int DRIZZLE = 1;
	public static final int RAINSTORM = 2;
	public static final int MONSOON = 3;
	public static final int FLURRIES = 4;
	public static final int SNOWFALL = 5;
	public static final int BLIZZARD = 6;
	public static final int CLOUDY = 7;
	
	private int lastType = 7;
	
	private int weatherType;
	
	public Weather(int weatherType) {
		if(weatherType <= lastType) {
			this.setWeatherType(weatherType);
		}else {
			this.setWeatherType(Weather.CLEAR);
		}	
	}
	
	public int getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(int weatherType) {
		this.weatherType = weatherType;
	}
}
