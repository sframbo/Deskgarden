package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class GardenUI {

	private static void createWindow() {
		JFrame frame = new JFrame("TEST");
		frame.setSize(500,500);
		frame.setLocation(300,200);
		final JTextArea textArea1= new JTextArea(10,40);
		frame.getContentPane().add(BorderLayout.CENTER, textArea1);
		textArea1.append("BLAH");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		createWindow();
	}
	
}
