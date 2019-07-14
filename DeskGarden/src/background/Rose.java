package background;

public class Rose extends Plant{

	private int growThresh = 10;
	private int growCap = 4;
	private int rarity = 10;
	private int animalAttract = 1;
	private int hp = 10;
	
	public Rose() {
		super();	
		super.setGrowThresh(this.growThresh);
		super.setRarity(this.rarity);
		super.setGrowCap(this.growCap);
		super.setAnimalAttract(this.animalAttract);
		super.setHP(this.hp);
	}

}
