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
	
	public ProcessParser(ArrayList<String> blackList, ArrayList<String> whiteList) {
		this.blackList = blackList;
		this.whiteList = whiteList;
		this.updateList();
	}
	//sets List to lower case letters, qol improvement
	private ArrayList<String> setLowerCase(ArrayList<String> input){
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0; i < input.size(); i++) {
			output.add(input.get(i).toLowerCase());		
		}
		return output;
	}
	//getters/setters
	public void setBlackList(ArrayList<String> List) {
		this.blackList = setLowerCase(List);
	}
	public void setWhiteList(ArrayList<String> List) {
		this.whiteList = setLowerCase(List);
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
	
	//check the List of currently running processes for entries from black List
	public int checkBlackList() {
		int res = 0;
		for(int i = 0; i < blackList.size(); i++) {
			 if(processList.contains(blackList.get(i))) {
				 res++;
			 }
		}
		return res;
	}
	
	//check the List of currently running processes for white List entries
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
	//update the List of currently running processes
	public void updateList() {
		this.processList = new ArrayList<String>();
		try {
		    String line;
		    Process p = Runtime.getRuntime().exec
		    	    (System.getenv("windir") +"\\system32\\"+"taskList.exe");
		    BufferedReader input =
		            new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = input.readLine()) != null) {
		    	if(!this.processList.contains(this.parseString(line)))
		        this.processList.add(this.parseString(line));
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}
	}
}
