package background;

public class Animal {
	
	private final int DEFDURA = 10;
	private final int DEFRAR = 10;
	private final int DEFHP = 10;
	private int duration;
	private int startHP;
	int rarity;
	
	public Animal() {
		this.setDuration(DEFDURA);
		this.setStartHP(DEFHP);
		this.rarity = DEFRAR;
	}
	
	public Animal(int startHP) {
		this.setDuration(DEFDURA);
		this.setStartHP(startHP);
		this.rarity = DEFRAR;
	}

	public int getStartHP() {
		return startHP;
	}
	public int getRarity() {
		return rarity;
	}
	public void setStartHP(int startHP) {
		this.startHP = startHP;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if(duration >= 0)
		this.duration = duration;
	}
	
	public boolean update(int hp) {
		if(hp < startHP) {
			this.duration = 0;
		}
		if(this.duration == 0) {
			return false;
		}else {
			this.duration--;
			return true;
		}
	}
	
}
