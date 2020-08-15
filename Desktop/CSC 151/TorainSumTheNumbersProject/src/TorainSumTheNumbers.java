import java.util.Scanner;

public class TorainSumTheNumbers {
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to see the sum of it's digits: ");
        long userLong = input.nextLong();
        long sumOfUserLong = sumTheNumbers(userLong);
        System.out.println("The sum of " + userLong + "'s digits is " + sumOfUserLong);
    }
    public static int sumTheNumbers(long n) {
        int sumOfN = 0;
        while (n > 0) {
            sumOfN += n % 10;
            n = n / 10;
        } return sumOfN;

    }

}
