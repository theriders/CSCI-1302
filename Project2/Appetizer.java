/*
 * Appetizer.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: the Appetizer object is only responsible for the appetizer menu in the Pizza store class
 */
import java.util.Scanner;

public final class Appetizer extends CustomerOrder{

private static int appOrders = 0;

private enum ApptType{
	SOUP, SALAD;

	public String toString() {
		String a = super.toString().substring(0,1);
		String b = super.toString().substring(1,super.toString().length()).toLowerCase();
		return a + b;
	}

}

public Appetizer() {
	printHeading();
	displayMenu();	
}

public void displayMenu() {
	boolean go = true;
	while(go){
	System.out.println("Enter Choice (1-2) or any key to exit\n1) Salad\n2) Soup");
	String a = scan.next();
	String b = "";
	int quantity = 0;
	double cost = 0;
	switch(a){
		case "1": b = ApptType.SALAD.toString();
			  quantity = getQuantity();
			  cost = SALAD_PRICE;
			  break;
		case "2": b = ApptType.SOUP.toString();
			  quantity = getQuantity();
			  cost = SOUP_PRICE;
			  break;
		default: go = false;
			 break;
	}
	if(go){
		appOrders++;
		total = total + (cost * quantity);
		output = output + b + "\t\t\t" + cost + "\t" + quantity + "\n";
		noOfItems = noOfItems + quantity;
	}
	} //while loop
	displayInvoice();
}

public void printHeading() {
	System.out.println("\t\tAppetizers Menu:");
}

private int getQuantity() {
	System.out.println("Please enter quantity:");
	String in = scan.next();
	int out = 0;
	try{
		out = Integer.parseInt(in);
	} catch(NumberFormatException e) {
		System.out.println("bad input - not counted");
		out = 0;
	}
	return out;
}

public static int getOrders(){
	return appOrders;
}
}
