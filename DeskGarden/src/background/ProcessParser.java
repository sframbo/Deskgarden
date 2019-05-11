package background;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProcessParser {
	private ArrayList<String> processList;
	private ArrayList<String> blackList;
	private ArrayList<String> whiteList;
	
	public ProcessParser() {
		this.processList = new ArrayList<String>();
		this.blackList = new ArrayList<String>();
		this.whiteList = new ArrayList<String>();
		this.updateList();
	}
	//sets list to lower case letters, qol improvement
	private ArrayList<String> setLowerCase(ArrayList<String> input){
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0; i < input.size(); i++) {
			output.add(input.get(i).toLowerCase());		
		}
		return output;
	}
	//getters/setters
	public void setBlackList(ArrayList<String> list) {
		this.blackList = setLowerCase(list);
	}
	public void setWhiteList(ArrayList<String> list) {
		this.whiteList = setLowerCase(list);
	}
	public ArrayList<String> getBlackList(){
		return this.blackList;
	}
	public ArrayList<String> getWhiteList(){
		return this.whiteList;
	}
	public ArrayList<String> getProcessList() {
		return this.processList;
	}
	
	//check the list of currently running processes for entries from black list
	public int checkBlackList() {
		int res = 0;
		for(int i = 0; i < blackList.size(); i++) {
			 if(processList.contains(blackList.get(i))) {
				 res++;
			 }
		}
		return res;
	}
	
	//check the list of currently running processes for white list entries
	public int checkWhiteList() {
		int res = 0;
		for(int i = 0; i < whiteList.size(); i++) {
			 if(processList.contains(whiteList.get(i))) {
				 res++;
			 }
		}
		return res;
	}
	
	//trim process return to only hold process name
	private String parseString(String input) {
		String name = "";
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch != ' ') {
				name+=ch;
			}else {
				break;
			}
		}
		return name.toLowerCase();
	}
	//update the list of currently running processes
	public void updateList() {
		this.processList = new ArrayList<String>();
		try {
		    String line;
		    Process p = Runtime.getRuntime().exec
		    	    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		    BufferedReader input =
		            new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = input.readLine()) != null) {
		        this.processList.add(this.parseString(line));
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}
	}
}
