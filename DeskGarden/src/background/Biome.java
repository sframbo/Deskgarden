package background;

public class Biome {
	public static final int TEMPERATE_FOREST = 0;
	public static final int PLAINS = 1;
	public static final int DESERT = 2;
	public static final int TROPICAL_ISLAND = 3;
	public static final int RAINFOREST = 4;
	public static final int MOUNTAIN = 5;
	public static final int CITY = 6;
	public static final int RIVER = 7;
	
	private int lastType = 7;
	
	private int biomeType;
	
	public Biome(int biomeType) {
		if(biomeType <= lastType) {
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
