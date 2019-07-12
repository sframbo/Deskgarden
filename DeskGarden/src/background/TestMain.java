package background;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		ProcessParser testParser = new ProcessParser();
		ArrayList<String> noList = new ArrayList<String>();
		ArrayList<String> yesList = new ArrayList<String>();
		yesList.add("explorer.exe");
		
		yesList.add("Discord.exe");
		noList.add("firefox.exe");
		testParser.setBlackList(noList);
		testParser.setWhiteList(yesList);
		int score = 0;
		
		for(int i = 0; i < 20; i++) {
			
			testParser.updateList();
			score -= testParser.checkBlackList();
			score += testParser.checkWhiteList();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
