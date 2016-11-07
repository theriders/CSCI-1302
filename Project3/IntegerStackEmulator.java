package uga.csci1302.myStack;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates an graphical implementation of a stack as a JPanel
 * @author Rohan Malik
 */
public class IntegerStackEmulator extends JPanel implements ActionListener {

	JTextField display;
	JButton input, restart, expand;
	JTextField set;
	JLabel tell;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, push, pop, clear;
	JPanel left, right, flow, newFlow;
	JScrollPane scroll;

	Stack<JLabel> stack;
	String toDisplay = "Create Stack Below";
	
	/**
 	 * creates an IntegerStackEmulator JPanel object
 	 */ 	
	public IntegerStackEmulator() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(left);

		right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		//right.setBorder(BorderFactory.createEmptyBorder(10,10,10,0));
		scroll = new JScrollPane(right);
		scroll.setBorder(BorderFactory.createEmptyBorder(10,10,10,0));
		scroll.setViewportBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		scroll.setPreferredSize(new Dimension(500,400));
		add(scroll);	
		//add(right);
		
		//LEFT
		display = new JTextField(toDisplay);
		toDisplay = "";
		display.setHorizontalAlignment(JTextField.CENTER);
		display.setEditable(false);
		input = new JButton("Set Capacity");
		set = new JTextField("100");
		restart = new JButton("Restart");
		expand = new JButton("Expand Capacity");
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setSize(400,400);
		flow = new JPanel(new FlowLayout());
		flow.setBorder(BorderFactory.createLineBorder(Color.red));
		JPanel showSize = new JPanel(new FlowLayout());
		JLabel size = new JLabel("Size: ");
		showSize.add(size);
		tell = new JLabel("");
		tell.setHorizontalAlignment(JLabel.CENTER);
		left.add(display);
		showSize.add(tell);
		left.add(showSize);
		flow.add(set);
		flow.add(input);
		left.add(flow);
		JPanel calc = new JPanel(new GridLayout(4,3));
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		clear = new JButton("Clear");
		b0 = new JButton("0");
		calc.add(b1);
		calc.add(b2);
		calc.add(b3);
		calc.add(b4);
		calc.add(b5);
		calc.add(b6);
		calc.add(b7);
		calc.add(b8);
		calc.add(b9);
		calc.add(new JLabel());
		calc.add(b0);
		calc.add(clear);
		left.add(calc);
		JPanel operate = new JPanel(new GridLayout(1,2));
		operate.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		push = new JButton("Push");
		push.setEnabled(false);
		pop = new JButton("Pop");
		pop.setEnabled(false);
		operate.add(push);
		operate.add(pop);
		left.add(operate);

		// Action Listeners
		input.addActionListener(this);
		restart.addActionListener(this);
		expand.addActionListener(this);
		push.addActionListener(this);
		pop.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		clear.addActionListener(this);
		b0.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
	// check the buttons
		toDisplay = display.getText();			
		if(b0 == e.getSource()) {
			 toDisplay+="0";
		} else if(b1 == e.getSource()) {
			 toDisplay+="1";
		} else if(b2 == e.getSource()) {
			 toDisplay+="2";
		} else if(b3 == e.getSource()) {
			 toDisplay+="3";
		} else if(b4 == e.getSource()) {
			 toDisplay+="4";
		} else if(b5 == e.getSource()) {
			 toDisplay+="5";
		} else if(b6 == e.getSource()) {
			 toDisplay+="6";
		} else if (b7 == e.getSource()) { 
			 toDisplay+="7";
		} else if (b8 == e.getSource()) {
			 toDisplay+="8";
		} else if (b9 == e.getSource()) {
			 toDisplay+="9";
		} else if (clear == e.getSource()) {
		         toDisplay = "";
		}			
		display.setText(toDisplay);
		
		if(e.getSource() == input) {
			display.requestFocusInWindow();
			display.setText("");
			int makesize;
			try {
				makesize = Integer.parseInt(set.getText());
				stack = new Stack<JLabel>(makesize);
				tell.setText(stack.size() + "");
				display.setEditable(true);
				flow.remove(input);
				flow.remove(set);
				flow.add(restart);
				flow.add(expand);
				flow.setBorder(BorderFactory.createLineBorder(Color.blue));
				flow.revalidate();
				flow.repaint();
				push.setEnabled(true);
				pop.setEnabled(true);
			} catch (NumberFormatException o) {
				JOptionPane.showMessageDialog(null,"Only Integers");
			}
		}

		if(e.getSource() == push) {
			display.requestFocusInWindow();
			String toAdd = display.getText();
			try {
				int parse = Integer.parseInt(toAdd);
				toAdd = parse + "";
				JLabel add = new JLabel(toAdd);
				add.setBorder(BorderFactory.createLineBorder(Color.black));
				//add.setBackground(Color.green);
				//add.setOpaque(true);
				add.setAlignmentX(Component.CENTER_ALIGNMENT);
				add.setPreferredSize(new Dimension(100,100));
				stack.push(add);
				right.add(stack.peek());
				tell.setText(stack.size() + "");
				right.revalidate();
				right.repaint();
				display.setText("");				
			} catch (NumberFormatException o) {
				JOptionPane.showMessageDialog(null, "Only Integers");
			} catch (FullStackException o) {
				JOptionPane.showMessageDialog(null, "stack is full");
			}		
		}

		if(e.getSource() == pop) {
			display.requestFocusInWindow();
			try { 
				right.remove(stack.pop());
				right.revalidate();
				right.repaint();
				tell.setText(stack.size() + "");
			} catch (EmptyStackException o) {
				JOptionPane.showMessageDialog(null, "stack is empty");
			}
		}
	
		if (e.getSource() == expand) {
			display.requestFocusInWindow();
			stack.expandCapacity();
		}

		if (e.getSource() == restart) {
			push.setEnabled(false);
			pop.setEnabled(false);
			display.setEditable(false);
			right.removeAll();
			right.revalidate();
			right.repaint();
			flow.removeAll();
			flow.add(set);
			flow.add(input);
			flow.setBorder(BorderFactory.createLineBorder(Color.red));
			flow.revalidate();
			flow.repaint();			
			tell.setText("");
		}		
	}
}
