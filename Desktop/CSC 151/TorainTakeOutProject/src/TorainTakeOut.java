/*
Joshua Torain
6/20/2020
Take Out Program Project
CSC	151	MON01

I abide	by GTCC’s academic integrity policy
this work is my	own	original work.
 */

//Import Scanner, BigDecimal, and RoundingMode
import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class TorainTakeOut {
    public static void main(String[] args) {
        double taxRate = .07;
        double tipRate = .15;
        double price = 0;
        int people;
        int feeds = 0;
        Scanner input = new Scanner(System.in);
        // Use a do...while loop to prompt user to enter the amount of people until they enter a valid number.
        // Once valid response (between 10 and 100) call displayMainMenu()
        do {
            System.out.print("\nHow many people are ordering? ");
            people = input.nextInt();
            if (10 > people) {
                System.out.println("\nThat's not enough people to place an order!");
            } else if (people > 100) {
                System.out.println("\nThat's too many people to place an order!");
            } else {
                displayMainMenu();
            }
        } while (people < 10 || people > 100);
        // initialize two variables typeOfFood and typeOfTray to store user input
        int typeOfFood;
        int typeOfTray = 0;
        // Use do...while loop to prompt user to choose type of food they want. Repeat until valid response is entered
        // Call appropriate method, depending on user input.
        do {
            typeOfFood = input.nextInt();
            if (typeOfFood == 1) {
                do {
                    displayItalianFoodMenu();
                    typeOfTray = input.nextInt();
                    if (typeOfTray != 1 && typeOfTray != 2 && typeOfTray != 3) {
                        System.out.print("\nThat is not a valid selection!\n");
                    } else {
                    }
                } while (typeOfTray != 1 && typeOfTray != 2 && typeOfTray != 3);
            } else if (typeOfFood == 2) {
                do {
                    displayChineseFoodMenu();
                    typeOfTray = (input.nextInt() + 3);
                    if (typeOfTray != 4 && typeOfTray != 5 && typeOfTray != 6) {
                        System.out.print("\nThat is not a valid selection!\n");
                    } else {
                    }
                } while (typeOfTray != 4 && typeOfTray != 5 && typeOfTray != 6);
            } else if (typeOfFood == 3) {
                do {
                    displayAmericanFoodMenu();
                    typeOfTray = (input.nextInt() + 6);
                    if (typeOfTray != 7 && typeOfTray != 8 && typeOfTray != 9) {
                        System.out.print("\nThat is not a valid selection!\n");
                    } else {
                    }
                } while (typeOfTray != 7 && typeOfTray != 8 && typeOfTray != 9);
            } else {
                System.out.println("\nThat is not a valid selection!");
                displayMainMenu();
            }
        } while (typeOfFood < 1 || typeOfFood > 3);
        // Switch Statement to determine the price and how many the meal feeds.
        switch (typeOfTray) {
            case 1: feeds = 5; price = 17.99;
                break;
            case 2: feeds = 7; price = 15.99;
                break;
            case 3: feeds = 4; price = 12.99;
                break;
            case 4:
            case 5:
                feeds = 7; price = 18.99;
                break;
            case 6: feeds = 5; price = 10.99;
                break;
            case 7: feeds = 8; price = 21.99;
                break;
            case 8: feeds = 5; price = 22.99;
                break;
            case 9: feeds = 10; price = 26.99;
        }
        // assign variables by calling appropriate methods
        int trays = determineTrays(people, feeds);
        double subTotal = getSubtotal(price, trays);
        double tax = getTax( subTotal, taxRate);
        double tip = getTip(subTotal, tipRate);
        double grandTotal = getGrandTotal(subTotal, tax, tip);
        double pricePerPerson = pricePerPerson(grandTotal, people);
        int leftOvers = determineLeftOvers(feeds, trays, people);
        // call method to display the results to the user
        displayTotals(feeds, trays, people, subTotal, tax, tip, grandTotal, pricePerPerson, leftOvers);
    }
    public static void displayMainMenu() {
        System.out.println("\nCHOOSE YOUR CUISINE\n___________________\n1. Italian\n2. Chinese\n3. American\n");
        System.out.print("What type of food would you like? Please enter 1, 2, or 3: ");
    }
    public static void displayItalianFoodMenu() {
        System.out.println("\nCHOOSE ONE\n__________\n1. Lasagna Tray - Feeds 5 - $17.99\n" +
                "2. Pizza Pack - Feeds 7 - $15.99\n" +
                "3. Gazpacho Soup, salad and breadsticks pack - Feeds 4 - $12.99\n");
        System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
    }
    public static void displayChineseFoodMenu() {
        System.out.println("\nCHOOSE ONE\n__________\n1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) -"
                + " feeds"
                + " 7 - $18.99\n2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 -"
                + " $18.99\n3. Shrimp Fried Rice Tray (includes 10 egg rolls) - feeds 5 - $10.99\n");
        System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
    }
    public static void displayAmericanFoodMenu() {
        System.out.println("\nCHOOSE ONE\n__________\n"
                + "1. Hamburger and Hot Dog Tray (includes buns and condiments) - feeds 8 - "
                + "$21.99\n2. Grilled Chicken Sandwich and Mozzarella Sticks Tray (includes dipping sauces) - Feeds 5"
                + " - $22.99\n3. Barbecue Tray (includes buns and peach cobbler) - Feeds 10 - $26.99\n");
        System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
    }
    public static int determineTrays(int people, int feeds) {
        int trays;
        if (people % feeds == 0) {
            trays = (people / feeds);
        } else {
            trays = 1 + (people / feeds);
        } return trays;
    }
    public static double getSubtotal(double price, int trays) {
        double subTotal = (price * ((double) trays));
        return subTotal;
    }
    public static double getTax(double subTotal, double taxRate) {
        double tax = subTotal * taxRate;
        return tax;
    }
    public static double getTip(double subTotal, double tipRate) {
        double tip = subTotal * tipRate;
        return tip;
    }
    public static double getGrandTotal(double subtotal, double tax, double tip){
        double grandTotal = subtotal + tax + tip;
        return grandTotal;
    }
    public static double pricePerPerson(double grandTotal, int people) {
        double pricePerPerson = (grandTotal / ((double) people));
        return pricePerPerson;
    }
    public static int determineLeftOvers(int feeds, int trays, int people) {
        int leftOvers = (feeds * trays) - people;
        return leftOvers;
    }
    public static void displayTotals(int feeds, int trays, int people, double subTotal, double tax,
                                     double tip, double grandTotal, double pricePerPerson, int leftOvers) {
        var stringSubTotal = Double.toString(subTotal);
        var subTotalCurrency = new BigDecimal(stringSubTotal).setScale(2, RoundingMode.HALF_UP);
        var stringTax = Double.toString(tax);
        var taxCurrency = new BigDecimal(stringTax).setScale(2, RoundingMode.HALF_UP);
        var stringTip = Double.toString(tip);
        var tipCurrency = new BigDecimal(stringTip).setScale(2, RoundingMode.HALF_UP);
        var stringGrandTotal = Double.toString(grandTotal);
        var grandTotalCurrency = new BigDecimal(stringGrandTotal).setScale(2, RoundingMode.HALF_UP);
        var stringPricePerPerson = Double.toString(pricePerPerson);
        var pricePerPersonCurrency = new BigDecimal(stringPricePerPerson).setScale(2, RoundingMode.HALF_UP);

        System.out.println("\nThis feeds " + feeds + " people.");
        System.out.println("You need " + trays + " tray(s).");
        System.out.println("Price for " + people + " people (" + trays + " trays): $" + subTotalCurrency);
        System.out.println("Tax: $" + taxCurrency);
        System.out.println("Tip: $" + tipCurrency);
        System.out.println("Total (food, tax, tip): $" + grandTotalCurrency);
        System.out.println("Price per person: $" + pricePerPersonCurrency);
        System.out.println("Leftover servings for the delivery person: " + leftOvers);
    }

}
