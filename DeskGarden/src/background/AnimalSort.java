package background;

import java.util.Comparator;

public class AnimalSort implements Comparator<Animal>{

	@Override
	public int compare(Animal anim0, Animal anim1) {
		return anim0.getRarity() - anim1.getRarity();
	}
	
}
