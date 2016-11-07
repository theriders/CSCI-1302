/*
 * Drink.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: The Drink object is only responsible for the drink menu in the pizza store menu program
 */
import java.util.Scanner;

public final class Drink extends CustomerOrder {

private static int drinkOrders = 0;

public Drink(){
	printHeading();
	displayMenu();
}

public void printHeading(){
	System.out.println("\tDrink Menu");
}

public void displayMenu(){
	System.out.println("There is only one option.");
	System.out.println("Please enter quantity:");
	int quantity = 0;
	String in = scan.next();
	try{
		quantity = Integer.parseInt(in);
	} catch(NumberFormatException e){
		System.out.println("bad input - not counted");
	}
	if (quantity != 0){
		drinkOrders++;
		total = total + (DRINK_PRICE * quantity);
		output = output + "Drink\t\t\t" + DRINK_PRICE + "\t" + quantity + "\n";
		noOfItems = noOfItems + quantity;
	}
	displayInvoice();
}

public static int getOrders(){
	return drinkOrders;
}

}
