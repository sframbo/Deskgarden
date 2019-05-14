package background;

public class Plant {
	private int growthTime;
	private float rarity;
	private int animalAttract;
	private int hp;
	private String type;
	
	public Plant(String type, int growthTime, float rarity, int animalAttract, int hp) {
		this.type = type;
		this.growthTime = growthTime;
		this.rarity = rarity;
		this.animalAttract = animalAttract;
		this.hp = hp;
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
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
