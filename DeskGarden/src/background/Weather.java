 package background;

public class Weather{
	public static final int DRIZZLE = 0;
	public static final int RAINSTORM = 1;
	public static final int MONSOON = 2;
	public static final int FLURRIES = 3;
	public static final int SNOWFALL = 4;
	public static final int BLIZZARD = 5;
	public static final int CLEAR = 6;
	public static final int CLOUDY = 7;
	
	private int lastType = 7;
	
	private int weatherType;
	
	public Weather(int weatherType) {
		if(weatherType <= lastType) {
			this.setWeatherType(weatherType);
		}else {
			this.setWeatherType(0);
		}	
	}

	public int getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(int weatherType) {
		this.weatherType = weatherType;
	}
}
