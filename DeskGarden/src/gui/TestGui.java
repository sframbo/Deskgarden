package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestGui {
	
	private static void createWindow() {
		final JPanel panelButton = new JPanel();
		JFrame frame = new JFrame("TEST");
		GridLayout grid = new GridLayout(0,2);
		final JButton b1 = new JButton("BUTTON 1");
		final JButton b2 = new JButton("BUTTON 2");
		final JButton b3 = new JButton("BUTTON 3");
		final JButton b4 = new JButton("BUTTON 4 with an extended testing name");
		panelButton.setLayout(grid);
		panelButton.add(b1);
		panelButton.add(b2);
		panelButton.add(b3);
		panelButton.add(b4);
		frame.setSize(50,50);
		frame.setLocation(300,200);
		frame.setLayout(grid);
		final JTextArea textArea1= new JTextArea(10,40);
		frame.getContentPane().add(BorderLayout.CENTER, textArea1);
		frame.getContentPane().add(BorderLayout.NORTH, panelButton);
		textArea1.append("BLAH");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		createWindow();
	}
	
}
