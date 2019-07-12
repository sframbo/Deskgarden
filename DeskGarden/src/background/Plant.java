package background;

public class Plant {
	private int growthTime;
	private float rarity;
	private int animalAttract;
	private int hp;
	private String type;
	private int growthStage;
	private int growPoint;
	private int growThresh;
	private int growCap;
	
	public Plant(String type, int growthTime, float rarity, int animalAttract, int hp, int growThresh, int growCap) {
		this.type = type;
		this.growthTime = growthTime;
		this.rarity = rarity;
		this.animalAttract = animalAttract;
		this.hp = hp;
		this.growthStage = 0;
		this.growPoint = 0;
		this.growThresh = growThresh;
		this.growCap = growCap;
	}
	public int getGrowthTime() {
		return growthTime;
	}
	public void setGrowthTime(int growthTime) {
		this.growthTime = growthTime;
	}
	public float getRarity() {
		return rarity;
	}
	public void setRarity(float rarity) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		this.growPoint = growPoint;
	}
	public void grow(int amt) {
		if(amt > 0) {
			this.growPoint+=amt;
			if(growPoint > growThresh && growthStage < growCap) {
				this.growPoint = 0;
				this.growthStage++;
			}
		}else {
			if(this.hp > 0)
			this.hp-=amt;
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
}
