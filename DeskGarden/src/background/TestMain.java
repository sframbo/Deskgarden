package background;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {

		ArrayList<String> noList = new ArrayList<String>();
		ArrayList<String> yesList = new ArrayList<String>();
		yesList.add("explorer.exe");	
		yesList.add("Discord.exe");
		yesList.add("eclipse.exe");
		
		noList.add("steam.exe");
		

		Biome biome = new Biome(Biome.FOREST);

		
		for(int i = 0; i < 5; i++) {
			
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
