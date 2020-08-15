import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class TorainTestClass {
    public static void main(String[] args) throws FileNotFoundException {
        // create file object for the text file
        File bankDataFile = new File("./src/BankData.txt");

        // create arrays to store data from file as String
        String[] bankDataFromFile = new String[11];
        double[] balanceArray = new double[11];

        // check that file exists
        if (bankDataFile.exists()) {
            // create scanner from file
            Scanner inBankDataFile = new Scanner(bankDataFile);
            // create index variable
            int index = 0;
            // use while loop and hasNext() method to determine if you are at end of file
            while (inBankDataFile.hasNext()) {
                // read the data into variables
                String firstName = inBankDataFile.next();
                String lastName = inBankDataFile.next();
                long accountNumber = inBankDataFile.nextLong();
                double balance = inBankDataFile.nextDouble();
                // instantiate person
                TorainAccount person = new TorainAccount(accountNumber, firstName, lastName, balance);
                // call appropriate methods
                displayAccounts(person);
                index++;

            } applyRandomBonus(balanceArray);
        }

    }
    public static void displayAccounts(TorainAccount person) {
        System.out.println(person.toString());
    }
    public static void applyRandomBonus(double[] balanceArray) {
        double[] randomBonus = new double[11];
        Random number = new Random();
        for (int i = 0; i < balanceArray.length; i++) {
            balanceArray[i] = (number.nextDouble() + 10) * 10;
            System.out.println(randomBonus);
        }
    }
}

// To Mrs. Halsey,
// I figured out the first part, but got stuck trying to display and add the bonus rewards
// I'm not sure where I went wrong