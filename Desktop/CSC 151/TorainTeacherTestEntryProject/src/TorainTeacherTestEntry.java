import java.util.Scanner;

public class TorainTeacherTestEntry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testScore;
        int numberOfTestScores = 0;
        int sumOfTestScores = 0;
        int highestTestScore = 0;
        int lowestTestScore = 100;

        do {
            System.out.print("Please enter the student's test score (Enter -1 to exit program): ");
            testScore = input.nextInt();
            if (testScore != -1 && testScore <= 0) {
                System.out.println("That is not a valid score!");
            } else if (testScore == -1) {
                break;
            } else { numberOfTestScores += 1; sumOfTestScores += testScore;
                    if (testScore > highestTestScore) {
                        highestTestScore = testScore;
                    } if (testScore < lowestTestScore) {
                    lowestTestScore = testScore;
                }
            }
        } while (testScore != -1);


        double averageOfTestScores = ((double) sumOfTestScores) / numberOfTestScores;
        System.out.println("You entered " + numberOfTestScores + " scores");
        System.out.println("The highest test score was " + highestTestScore);
        System.out.println("The lowest test score was " + lowestTestScore);
        System.out.printf("The average of the test scores was %.2f", averageOfTestScores);
    }
}
