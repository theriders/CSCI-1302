/*
 * PizzaStore.java
 * Author: Rohan Malik
 * Submission Date: October 10, 2016
 * Purpose: it is an interface for a Pizza Shop program
 */
public interface PizzaStore {

double TAX = 0.07;
double S_VEGETARIAN_PRICE = 6.5;
double M_VEGETARIAN_PRICE = 10.5;
double L_VEGETARIAN_PRICE = 13.5;
double S_CHEESE_PRICE = 5.5;
double M_CHEESE_PRICE = 8.0;
double L_CHEESE_PRICE = 10.0;
double S_PEPPERONI_PRICE = 6.0;
double M_PEPPERONI_PRICE = 8.5;
double L_PEPPERONI_PRICE = 12.0;
double DRINK_PRICE = 2.0;
double SALAD_PRICE = 4.5;
double SOUP_PRICE = 5.0;

public void calculateTotal();

public void printHeading();

public void printInvoice();

public void displayMenu();

}
