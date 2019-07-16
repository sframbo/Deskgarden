package background;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {

		ArrayList<String> noList = new ArrayList<String>();
		ArrayList<String> yesList = new ArrayList<String>();
		yesList.add("discord.exe");	
		yesList.add("eclipse.exe");

		noList.add("firefox.exe");
		
		int growCap = 4;
		int growThresh = 5;
		int animalAttract = 0;
		int rarity = 1;
		int hp = 200;
		Plant plant = new Plant(rarity,animalAttract, hp, growThresh, growCap);
		Plant plant2 = new Plant(rarity,animalAttract, hp-180, growThresh, growCap);
		Biome biome = new Biome(Biome.DESERT);
		
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		plantList.add(plant);
		plantList.add(plant2);
		
		Garden garden = new Garden(biome, "TEST1", plant, yesList, noList);
		//Garden garden = new Garden(biome, "TEST2", plant2, yesList, noList, 3, 1);
		//Garden garden = new Garden(biome, "TEST3", plantList, yesList, noList,4,1);
		
		for(int i = 0; i < 800; i++) {
			garden.update();
			System.out.println(i + ": HP: " + garden.getHp() + " GRPNT: " + garden.getPlants().get(0).getGrowPoint() + 
					" GRSTG: " + garden.getPlants().get(0).getGrowthStage() + " WEATHER: " + garden.getWeather().toString());
			
			try {
				//Thread.sleep(60000);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
