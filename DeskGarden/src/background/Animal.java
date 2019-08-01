package background;

public class Animal {
	public static final int SQUIRREL = 0;
	public static final int RAVEN = 1;
	public static final int LASTANI = 1;
	
	public static final int SQRAR = 10;
	public static final int RARAR = 30;
	public static final int DEFAULTRAR = 10;
	
	private final int DEFDURA = 10;
	private final int DEFRAR = 10;
	
	private int duration;
	private int rarity;
	private int type;
	private String name;
	private int locID;	
	/**
	 * Creates a new animal of type specified and at location specified.
	 * @param type Animal constant ID value
	 * @param locID
	 */
	public Animal(int type, int locID) {
		this.setType(type);
		this.setLocID(locID);
		switch(type) {
		case Animal.RAVEN:
			this.setDuration(DEFDURA);
			this.setRarity(Animal.RARAR);
			this.setType(Animal.RAVEN);
			this.setName("RAVEN");
			break;
		case Animal.SQUIRREL:
		default:
			this.setDuration(DEFDURA);
			this.setRarity(Animal.SQRAR);
			this.setType(Animal.SQUIRREL);
			this.setName("SQUIRREL");
		}
	}
	@Override
	public String toString() {
		return this.name;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getRarity() {
		return rarity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if(duration >= 0)
		this.duration = duration;
	}
	
	public boolean update() {
		if(this.duration == 0) {
			return false;
		}else {
			this.duration--;
			return true;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static int getRarityOf(int animalType) {
		switch(animalType) {
		case Animal.RAVEN:
			return RARAR;
		case Animal.SQUIRREL:
			return SQRAR;
		default: 
			return DEFAULTRAR;
		}
	}

	public int getLocID() {
		return locID;
	}

	public void setLocID(int locID) {
		this.locID = locID;
	}
}
