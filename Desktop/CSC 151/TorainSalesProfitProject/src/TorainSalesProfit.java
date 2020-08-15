/*
Joshua Torain
7/2/2020
Sales Profit Project
CSC	151	MON01

I abide	by GTCC’s academic integrity policy
this work is my	own	original work.
 */

// import File, Scanner, and IOException
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TorainSalesProfit {
    public static void main(String[] args) throws IOException {
        System.out.println("Employee    | Sales | Commission |   Pay   | Profit");
        System.out.println("---------------------------------------------------");
        // create file objects for the text files
        File namesFile = new File("./src/Names.txt");
        File salesFile = new File("./src/Sales.txt");
        File commissionRatesFile = new File("./src/CommissionRates.txt");

        // create String arrays to store data from files as Strings
        String[] stringNamesFromFile = new String[3];
        String[] stringSalesFromFile = new String[3];
        String[] stringCommissionRatesFromFile = new String[3];

        // create double arrays for files with numbers to store as doubles
        double[] doubleSalesFromFile = new double[3];
        double[] doubleCommissionRatesFromFile = new double[3];

        // check that files exist
        if (namesFile.exists() && salesFile.exists() && commissionRatesFile.exists()) {
            // create Scanners from the files
            Scanner inNamesFile = new Scanner(namesFile);
            Scanner inSalesFileString = new Scanner(salesFile);
            Scanner inCommissionRatesFileString = new Scanner(commissionRatesFile);
            Scanner inSalesFileDouble = new Scanner(salesFile);
            Scanner inCommissionRatesFileDouble = new Scanner(commissionRatesFile);
            // create variables to hold values from files
            String stringName;
            String stringSales;
            String stringCommissionRates;
            double doubleSales;
            double doubleCommissionRates;
            // create index variable
            int index = 0;
            // Use while loop and hasNext() method to determine if you are at end of the file
            while (inNamesFile.hasNext() && inSalesFileString.hasNext() && inCommissionRatesFileString.hasNext()
                    && inSalesFileDouble.hasNext() && inCommissionRatesFileDouble.hasNext()) {
                // read the next line in the file
                stringName = inNamesFile.nextLine();
                stringNamesFromFile[index] = stringName;
                stringSales = inSalesFileString.nextLine();
                stringSalesFromFile[index] = stringSales;
                stringCommissionRates = inCommissionRatesFileString.nextLine();
                stringCommissionRatesFromFile[index] = stringCommissionRates;
                doubleSales = inSalesFileDouble.nextDouble();
                doubleSalesFromFile[index] = doubleSales;
                doubleCommissionRates = inCommissionRatesFileDouble.nextDouble();
                doubleCommissionRatesFromFile[index] = doubleCommissionRates;

                // call appropriate methods
                double[] pay = getPay(doubleSalesFromFile, doubleCommissionRatesFromFile);
                double[] profit = getProfit(pay, doubleSalesFromFile);
                int mostPaidIndex = getMostPaid(pay);
                int mostProfitIndex = getMostProfit(profit);
                displayResults(index, stringName, stringSales, stringCommissionRates, stringNamesFromFile, pay,
                        profit, mostPaidIndex, mostProfitIndex);
                // increase index variable by 1
                index++;
            }
            //close scanners
            inNamesFile.close();
            inSalesFileString.close();
            inCommissionRatesFileString.close();
            inSalesFileDouble.close();
            inCommissionRatesFileDouble.close();
        }
    }
    // method to get pay and create a double array of values
    public static double[] getPay (double[] doubleSalesFromFile, double[] doubleCommissionRatesFromFile) {
        // initialize new array double[] pay. use loop to populate new array
        double[] pay = new double[3];
        for (int i = 0; i < doubleSalesFromFile.length; i++) {
            pay[i] = doubleSalesFromFile[i] * doubleCommissionRatesFromFile[i];
        } return pay;
    }
    // method to get profit and create a double array of values
    public static double[] getProfit (double[] pay, double[] doubleSalesFromFile) {
        // initialize new array double[] profit. use loop to populate new array
        double[] profit = new double[3];
        for (int i = 0; i < doubleSalesFromFile.length; i++) {
            profit[i] = doubleSalesFromFile[i] - pay[i];
        } return profit;
    }
    // method to get index of most paid from double[] pay
    public static int getMostPaid(double[] pay) {
        double mostPaid = pay[0];
        int mostPaidIndex = 0;
        for (int i = 0; i < pay.length; i++) {
            if (pay[i] > mostPaid) {
                mostPaid = pay[i];
                mostPaidIndex = i;
            }
        } return mostPaidIndex;

    }
    // method to get most profit of double[] profit
    public static int getMostProfit(double[] profit) {
        double mostProfit = profit[0];
        int mostProfitIndex = 0;
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] > mostProfit) {
                mostProfit = profit[i];
                mostProfitIndex = i;
            }
        } return mostProfitIndex;
    }
    // method to display results to user
    public static void displayResults (int index, String stringName, String stringSales, String stringCommissionRates,
                                       String[] stringNamesFromFile, double[] pay, double[] profit, int mostPaidIndex,
                                       int mostProfitIndex)
    {
        // Use BigDecimal to convert pay and profit to currency with only 2 decimal places
        var stringPay = Double.toString(pay[index]);
        var moneyPay = new BigDecimal(stringPay).setScale(2, RoundingMode.HALF_UP);
        var stringProfit = Double.toString(profit[index]);
        var moneyProfit = new BigDecimal(stringProfit).setScale(2, RoundingMode.HALF_UP);

        // use if statement to get names of most paid and most profit to only print when highest index is reached
        if (index < stringNamesFromFile.length - 1) {
            System.out.println(stringName + "  $" + stringSales + "      " + stringCommissionRates
                + "       $" + moneyPay + "   $" + moneyProfit);
        } else {
            System.out.println(stringName + "  $" + stringSales + "      " + stringCommissionRates
                    + "       $" + moneyPay + "   $" + moneyProfit);
            System.out.println("\n" + stringNamesFromFile[mostPaidIndex] + " was paid the most commission.");
            System.out.println(stringNamesFromFile[mostProfitIndex] + " made the most profit for the company.");
        }
    }
}
