/*
 * Pizza.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: the Pizza object and its methods is only responsible for the pizza menu in the Pizza Store menu program
 */
import java.util.Scanner;

public final class Pizza extends CustomerOrder{

private static int pizzaOrders = 0;

private enum PizzaType {
	VEGETARIAN, CHEESE, PEPPERONI;

	public String toString() {
		String a = super.toString().substring(0,1);
		String b = super.toString().substring(1,super.toString().length()).toLowerCase();
		return a + b;
	}

}

private enum PizzaSize {
	SMALL, MEDIUM, LARGE;

	public String toString() {
		String a = super.toString().substring(0,1);
		String b = super.toString().substring(1,super.toString().length()).toLowerCase();
		return a + b;
	}
}

public Pizza() {
	printHeading();
	displayMenu();	
}

public void displayMenu() {
	boolean go = true;
	while(go) {
	System.out.println("Enter Pizza choice (1-3) or hit any key to exit\n 1) Vegetarian\n 2) Cheese\n 3) Pepperoni");
	String a = scan.next();
	String b = "";
	double cost = 0;
	int quantity = 0;
	switch(a) {
		case "1": a = PizzaType.VEGETARIAN.toString();
			System.out.println("Please enter size:\n 1) Small\n 2) Medium\n 3) Large");
			b = scan.next();
			switch(b) {
				case "1": b = PizzaSize.SMALL.toString();
					  quantity = getQuantity();
					  cost = S_VEGETARIAN_PRICE; 
					  break;
				case "2": b = PizzaSize.MEDIUM.toString();
					  quantity = getQuantity();
					  cost = M_VEGETARIAN_PRICE;
					  break;
				case "3": b = PizzaSize.LARGE.toString();
					  quantity = getQuantity();
					  cost = L_VEGETARIAN_PRICE;
					  break;
				default: go = false;
					 break; 
			}
			 break;//vegetarian
		case "2": a = PizzaType.CHEESE.toString();
			System.out.println("Please enter size:\n 1) Small\n 2) Medium\n 3) Large");
			b = scan.next();
			switch(b) {
				case "1": b = PizzaSize.SMALL.toString();
					  quantity = getQuantity();
					  cost = S_CHEESE_PRICE; 
					  break;
				case "2": b = PizzaSize.MEDIUM.toString();
					  quantity = getQuantity();
					  cost = M_CHEESE_PRICE;
					  break;
				case "3": b = PizzaSize.LARGE.toString();
					  quantity = getQuantity();
					  cost = L_CHEESE_PRICE;
					  break;
				default: go = false;
					 break; 
			}

			  break; //cheese
		case "3": a = PizzaType.PEPPERONI.toString();
			System.out.println("Please enter size:\n 1) Small\n 2) Medium\n 3) Large");
			b = scan.next();
			switch(b) {
				case "1": b = PizzaSize.SMALL.toString();
					  quantity = getQuantity();
					  cost = S_PEPPERONI_PRICE; 
					  break;
				case "2": b = PizzaSize.MEDIUM.toString();
					  quantity = getQuantity();
					  cost = M_PEPPERONI_PRICE;
					  break;
				case "3": b = PizzaSize.LARGE.toString();
					  quantity = getQuantity();
					  cost = L_PEPPERONI_PRICE;
					  break;
				default: go = false;
					 break; 
			}

			  break; // pepper
		default:  go = false; 
			  break;
	}
	if(!go) {

	} else{
		if(quantity == 0) {

		} else {
			pizzaOrders++;
			total = total + (cost * quantity);
			output = output + b + " " + a + " Pizza\t" + cost + "\t" + quantity + "\n";
			noOfItems = noOfItems + quantity;
		}
	}

	} //for while statement
	displayInvoice();
}

public void printHeading() {
	System.out.println("\t\tPizza Menu:");
}

private int getQuantity() {
	System.out.println("Please enter quantity:");
	String in = scan.next();
	int out = 0;
	try{
		out = Integer.parseInt(in);
	} catch(NumberFormatException e) {
		out = 0;
		System.out.println("bad input - not counted");
	}
	return out;
}

public static int getOrders(){
	return pizzaOrders;
}

}
