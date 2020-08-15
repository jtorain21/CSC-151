import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class TorainTakeOut {
    public static void main(String[] args) {
        /*
        create scanner class to get input from user. Prompt user to enter number of people ordering.
        Use if/else-statement to make sure value is between 10 and 100.
        If in range display cuisine choices to user.
         */
        Scanner input = new Scanner(System.in);
        System.out.print("How many people are ordering? ");
        int numberOfPeople = input.nextInt();
        String message;
        if (10 > numberOfPeople) {
            message = "That's not enough people to place an order!";
            System.out.print(message);
            System.exit(0);
        } else if (numberOfPeople > 100) {
            message = "That's too many people to place an order!";
            System.out.print(message);
            System.exit(0);
        } else {
            message = "Choose Your Cuisine\n___________________\n1. Italian\n2. Chinese\n3. American";
        } System.out.println(message);
        /* Use an if statement to display the appropriate menu
        Stop the program if the user enters an invalid input
         */
        System.out.print("What type of food would you like? Please enter 1, 2, or 3: ");
        int typeOfFood = input.nextInt();
        int typeOfTray = 0;
        String menu;
        if (typeOfFood == 1) {
            menu = "CHOOSE ONE\n__________\n1. Lasagna Tray - Feeds 5 - $17.99\n2. Pizza Pack - Feeds 7 - $15.99\n" +
                    "3. Gazpacho Soup, salad and breadsticks pack - Feeds 4 - $12.99\n";
            System.out.print(menu);
            System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
            typeOfTray = input.nextInt();
            if (typeOfTray != 1 && typeOfTray != 2 && typeOfTray != 3) {
                System.out.print("That is not a valid input!");
                System.exit(0);
            } else {}
        } else if (typeOfFood == 2) {
            menu = "CHOOSE ONE\n__________\n1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds"
                    + " 7 - $18.99\n2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 -"
                    + " $18.99\n3. Shrimp Fried Rice Tray (includes 10 egg rolls) - feeds 5 - $10.99\n";
            System.out.print(menu);
            System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
            typeOfTray = (input.nextInt() + 3);
            if (typeOfTray != 4 && typeOfTray != 5 && typeOfTray != 6) {
                System.out.print("That is not a valid input!");
                System.exit(0);
            } else {}
        } else if (typeOfFood == 3) {
            menu = "CHOOSE ONE\n__________\n1. Hamburger and Hot Dog Tray (includes buns and condiments) - feeds 8 - " +
                    "$21.99\n2. Grilled Chicken Sandwich and Mozzarella Sticks Tray (includes dipping sauces) - Feeds 5"
                    + " - $22.99\n3. Barbecue Tray (includes buns and peach cobbler) - Feeds 10 - $26.99\n";
            System.out.print(menu);
            System.out.print("Which tray would you like to order? Please choose 1, 2, or 3: ");
            typeOfTray = (input.nextInt() + 6);
            if (typeOfTray != 7 && typeOfTray != 8 && typeOfTray != 9) {
                System.out.print("That is not a valid input!");
                System.exit(0);
            } else {}
        } else {
            menu = "That is not a valid selection!";
            System.out.print(menu);
            System.exit(0);
        }
        /*
            Initialize two variables, number the tray feeds and how much it costs.
            Use switch statement to assign values to variables depending on user input.
         */
        int numberItFeeds = 0;
        double costOfTray = 0;
        switch (typeOfTray) {
            case 1: numberItFeeds = 5; costOfTray = 17.99;
            break;
            case 2: numberItFeeds = 7; costOfTray = 15.99;
            break;
            case 3: numberItFeeds = 4; costOfTray = 12.99;
            break;
            case 4:
            case 5:
                numberItFeeds = 7; costOfTray = 18.99;
            break;
            case 6: numberItFeeds = 5; costOfTray = 10.99;
            break;
            case 7: numberItFeeds = 8; costOfTray = 21.99;
            break;
            case 8: numberItFeeds = 5; costOfTray = 22.99;
            break;
            case 9: numberItFeeds = 10; costOfTray = 26.99;
        }

        //Calculations
        double taxRate = .07;
        double tipRate = .15;
        int numberOfTrays = 0;
        if (numberOfPeople % numberItFeeds == 0) {
            numberOfTrays = (numberOfPeople / numberItFeeds);
        } else {
            numberOfTrays = 1 + (numberOfPeople / numberItFeeds);
        }
        int numberOfServings = numberItFeeds * numberOfTrays;
        double price = numberOfTrays * costOfTray;
        var stringPrice = Double.toString(price);
        var priceCurrency = new BigDecimal(stringPrice).setScale(2, RoundingMode.HALF_UP);
        double tax = price * taxRate;
        var stringTax = Double.toString(tax);
        var taxCurrency = new BigDecimal(stringTax).setScale(2, RoundingMode.HALF_UP);
        double tip =  price * tipRate;
        var stringTip = Double.toString(tip);
        var tipCurrency = new BigDecimal(stringTip).setScale(2, RoundingMode.HALF_UP);
        double total = price + tax + tip;
        var stringTotal = Double.toString(total);
        var totalCurrency = new BigDecimal(stringTotal).setScale(2, RoundingMode.HALF_UP);
        double pricePerPerson = total / numberOfPeople;
        var stringPricePerPerson = Double.toString(pricePerPerson);
        var pricePerPersonCurrency = new BigDecimal(stringPricePerPerson).setScale(2, RoundingMode.HALF_UP);

        // Output results to user
        System.out.println("This feeds " + numberItFeeds + " people.");
        System.out.println("You need " + numberOfTrays + " tray(s).");
        System.out.println("Price for " + numberOfPeople + " people (" + numberOfTrays + " trays): $" + priceCurrency);
        System.out.println("Tax: $" + taxCurrency);
        System.out.println("Tip: $" + tipCurrency);
        System.out.println("Total (food, tax, tip): $" + totalCurrency);
        System.out.println("Price per person: $" + pricePerPersonCurrency);
        System.out.println("Leftover servings for the delivery person: " + (numberOfServings - numberOfPeople));
    }
}
