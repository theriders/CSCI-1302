/*
 * CustomerOrder.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: when a CustomerOrder obect is instantianted and its displayMenu() method is called the entire Pizza Store menu program is run
 */
import java.util.Scanner;

public class CustomerOrder extends Order{

Scanner scan = new Scanner(System.in);

public CustomerOrder(){

}

public void displayMenu(){
	boolean systemPower = true;
	while(systemPower){
	super.printHeading();
	super.displayMenu();
	printHeading();
	boolean go = true;
	while(go){
	System.out.println("Enter Items: Choose (1-3) or hit any key to exit\n1) Pizza\n2) Appetizers\n3) Drinks");
	go = true;
	String in = scan.next();
	switch(in){
		case "1": new Pizza();
			  break;
		case "2": new Appetizer();
			  break;
		case "3": new Drink();
			  break;
		default: go = false;
			 break;
	}
	boolean bad = true;
	while(bad){
	bad = false;
	System.out.print("More to Order (Y for yes N for no)?  ");
	String a = scan.next();
	switch(a){
		case "y":
		case "Y": go = true; 
			  break;
		case "n":
		case "N": go = false;
			  break;
		default: bad = true;;
			 break;
	}
	}
	}//while loop
	printInvoice();
	boolean retry = true;;
	while(retry){
	retry = false;
	System.out.println("System off (Enter N for new customer order or E to exit System)");	
	String g = scan.next();
	switch(g){
		case "N":
		case "n": systemPower = true;
			  break;
		case "E":
		case "e": systemPower = false;
			  break;
		default: retry = true;
			 break;
	}
	}  //retry while loop
	total = 0;
	output = "Item \t\t\tPrice\tQty\n"; 
	noOfItems = 0;
	}
	System.out.println("\nSession Sales Summary");
	System.out.println("Total number of orders             " + counter);
	System.out.println("Total number of Pizza orders       " + Pizza.getOrders());
	System.out.println("Total number of Appetizer orders   " + Appetizer.getOrders());
	System.out.println("Total number of Drink orders       " + Drink.getOrders());
}

public void printHeading(){
	System.out.println("Start Order....");
}

public void calculateTotal(){
	total = total + (TAX * total);
}

}
