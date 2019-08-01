package background;

public class Plant {
	public static final int ROSE = 0;
	public static final String ROSE_NAME = "ROSE";
	
	public static final int WILLOW = 1;
	public static final String WILLOW_NAME = "WILLOW";
	
	public static final int BASIL = 2;
	public static final String BASIL_NAME = "BASIL";
	
	private final int DEFATT = 5;
	private final int DEFTHRESH = 10;
	private final int DEFHP = 20;
	private final int GRO_STG_START = 1;
	private final int GRO_PNT_START = 1;
	private final int DEFCAP = 4;
	private final int DEFRAR = 1;
	
	private int rarity;
	private int animalAttract;
	private int hp;
	private int growthStage;
	private int growPoint;
	private int growThresh;
	private int growCap;
	private int maxHP;
	private int type;
	private String name;
	private int locID;
	/**
	 * Creates a new Plant of type specified at location specified
	 * @param type Plant type id int
	 * @param locID
	 */
	public Plant(int type, int locID) {
		this.setLocID(locID);
		this.setRarity(DEFRAR);
		this.setAnimalAttract(DEFATT);
		this.setHP(DEFHP);
		this.setGrowthStage(GRO_STG_START);
		this.setGrowPoint(GRO_PNT_START);
		this.setGrowThresh(DEFTHRESH);
		this.setGrowCap(DEFCAP);
		this.setMaxHP(DEFHP);
		this.setType(type);
		switch(type) {
			case Plant.ROSE:
				this.setName(Plant.ROSE_NAME);
				break;
			case Plant.WILLOW:
				this.setName(Plant.WILLOW_NAME);
				break;
			case Plant.BASIL:
				this.setName(Plant.BASIL_NAME);
				break;
			default:
				this.setName("ERROR_PLANT_NAME");
		}
		
	}
	
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getAnimalAttract() {
		return animalAttract;
	}
	public void setAnimalAttract(int animalAttract) {
		this.animalAttract = animalAttract;
	}
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}
	public int getGrowthStage() {
		return growthStage;
	}
	public void setGrowthStage(int growthStage) {
		this.growthStage = growthStage;
	}
	public int getGrowPoint() {
		return growPoint;
	}
	public void setGrowPoint(int growPoint) {
		if(growPoint > 0)
		this.growPoint = growPoint;
	}
	public void update(int amt) {
		if(amt > 0 && this.hp > 0) {
			this.growPoint+=amt;
			if(this.hp < this.maxHP) {
				this.hp+=amt;
			}
			if(growPoint > growThresh && growthStage < growCap) {
				this.growPoint = 0;
				this.growthStage++;
			}
		}else {
			if(this.hp > 0) {
				this.hp+=amt;
				if(this.hp < 0) {
					this.hp = 0;
				}
			}

			
		}
		
	}
	public int getGrowThresh() {
		return growThresh;
	}
	public void setGrowThresh(int growThresh) {
		this.growThresh = growThresh;
	}
	public int getGrowCap() {
		return growCap;
	}
	public void setGrowCap(int growCap) {
		this.growCap = growCap;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getLocID() {
		return locID;
	}


	public void setLocID(int locID) {
		this.locID = locID;
	}
}
