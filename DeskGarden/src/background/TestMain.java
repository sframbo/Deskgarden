package background;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {

		ArrayList<String> noList = new ArrayList<String>();
		ArrayList<String> yesList = new ArrayList<String>();
		yesList.add("discord.exe");	
		yesList.add("eclipse.exe");

		noList.add("firefox.exe");
		
		Plant plant = new Plant(Plant.WILLOW,0);
		Plant plant2 = new Plant(Plant.ROSE,1);
		Biome biome = new Biome(Biome.FOREST);
		
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		plantList.add(plant);
		plantList.add(plant2);
		
		Garden garden = new Garden(biome, "TEST1", plant, yesList, noList);
		//Garden garden = new Garden(biome, "TEST2", plant2, yesList, noList, 3, 1);
		//Garden garden = new Garden(biome, "TEST3", plantList, yesList, noList,4,1);
		
		for(int i = 0; i < 800; i++) {
			garden.update();
			System.out.println(i + ": " + garden.getWeather());
			try {
				//Thread.sleep(60000);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
