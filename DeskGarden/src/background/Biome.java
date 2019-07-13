package background;

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
	
	private int biomeType;
	
	public Biome(int biomeType) {
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
}
