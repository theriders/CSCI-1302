/*
 * Order.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: abstract class used to polymorphically access objects
 */
abstract class Order implements PizzaStore {

	protected static int counter = 0;
	protected static int noOfItems;
	protected static double total = 0;
	protected static String output = "Item \t\t\tPrice\tQty\n";

	public void displayMenu(){
		System.out.print("Pizza:\n\t\tSmall \t\tMedium\t\tLarge\n");
		System.out.printf(" Vegetarian\t$%.1f\t\t$%.1f\t\t$%.1f\n",S_VEGETARIAN_PRICE,M_VEGETARIAN_PRICE,L_VEGETARIAN_PRICE);
		System.out.printf(" Cheese    \t$%.1f\t\t$%.1f\t\t$%.1f\n",S_CHEESE_PRICE,M_CHEESE_PRICE,L_CHEESE_PRICE);
		System.out.printf(" Pepperoni \t$%.1f\t\t$%.1f\t\t$%.1f\n",S_PEPPERONI_PRICE,M_PEPPERONI_PRICE,L_PEPPERONI_PRICE);
		System.out.print("Appetizers:\n");
		System.out.printf("Salad.................................................... $%.1f\n",SALAD_PRICE);
		System.out.printf("Soup..................................................... $%.1f\n",SOUP_PRICE);
		System.out.printf("Soft Drinks.............................................. $%.1f\n",DRINK_PRICE);
		System.out.println();
	}

	public void printHeading(){
		System.out.println("\tWelcome to Pizza Store");
	}

	public void displayInvoice(){
		System.out.println();
		System.out.println("Order Summary");
		System.out.println(output);
	}

	public void printInvoice() {
		counter++;
		System.out.println("\n\n");
		System.out.println("Invoice " + String.format("%03d",counter));
		System.out.println(output);
		System.out.println("Total Sales\t\t$" + total);
		System.out.printf("Tax        \t\t$%.3f\n",(total * TAX));
		System.out.println("Total      \t\t$" + (total + (total * TAX)));
		System.out.println();
	}

	public static int getNumItems(){
		return noOfItems;
	}

}

