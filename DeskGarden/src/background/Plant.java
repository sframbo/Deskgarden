package background;

public class Plant {
	private int rarity;
	private int animalAttract;
	private int hp;
	private int growthStage;
	private int growPoint;
	private int growThresh;
	private int growCap;
	private int maxHP;
	
	public Plant(){
		this.rarity = 1;
		this.animalAttract = 1;
		this.hp = 1;
		this.growthStage = 1;
		this.growPoint = 0;
		this.growThresh = 1;
		this.growCap = 1;
		this.maxHP = 1;
	}
	
	public Plant(int rarity, int animalAttract, int hp, int growThresh, int growCap) {
		this.rarity = rarity;
		this.animalAttract = animalAttract;
		this.hp = hp;
		this.maxHP = hp;
		this.growthStage = 0;
		this.growPoint = 0;
		this.growThresh = growThresh;
		this.growCap = growCap;
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
}
