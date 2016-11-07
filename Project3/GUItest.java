package uga.csci1302.test;

import uga.csci1302.myStack.*;
import javax.swing.JFrame;

/**
 * Tests the IntegerStackEmulator JPanel
 * @author Rohan Malik
 */
public class GUItest{

	/**
 	 * Tests the IntegerStackEmulaot JPanel
 	 * @param args main method string array
 	 */ 	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Integer Stack Emulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.getContentPane().add(new IntegerStackEmulator());
		frame.setSize(1000,400);
		frame.setVisible(true);
	}	

}
