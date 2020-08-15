/**
 * Created by rwhalsey on 6/24/2020.
 * Joshua Torain
 * 6/26/2020
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Grades {
    public static void main(String [] args) throws IOException {

       File file = new File("./src/Names.txt");             // create a File object
       File gradesFile = new File("./src/Grades.txt");

       String[] gradesFromFile = new String[20];

        int[] grades = new int[20];
        String[] namesFromFile = new String[20];
        grades[0] = 99;
        grades[1] = 78;


        for (int i = 0; i < grades.length; i++) {
            grades[i] = 1;
        }

        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i] + ", ");
        }


        Scanner keyboardInput = new Scanner(System.in);
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Enter Grade: ");
            grades[i] = keyboardInput.nextInt();
        }


        int x = 10;
        String[] names = new String[5];
        // Scanner for getting names from keyboard
        Scanner getNames = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter name; ");
            names[i] = getNames.nextLine();
        }
        int[] scores = {45, 67, 100, 70};


        if ( file.exists() && gradesFile.exists() )                          // check that the file exists
        {                                             // before trying to create a
            // Scanner to read the file
            // Create a Scanner from the file.
            // This statement can cause a FileNotFoundException.
            Scanner inFile = new Scanner( file );
            Scanner inGradesFile = new Scanner( gradesFile );

            // For each line in the file, read in the line and display it with the line number
            int lineNum = 0;

            // Use the results of calling the hasNext method to
            // determine if you are at the end of the file before
            // reading the next line of the file.
            String name;
            String grade;
            int index = 0;
            while ( inFile.hasNext() && inGradesFile.hasNext() )
            {
                name = inFile.nextLine();   // read the next line
                namesFromFile[index] = name;
                grade = inGradesFile.nextLine();
                gradesFromFile[index] = grade;


                index++;
                // Output the line read to the screen for the user
                // System.out.println( ++lineNum + ": " + name );
                System.out.println( name + ", " + grade );
                double gradeAverage = average(grades);
                System.out.print(gradeAverage);

            }
            //for each
            /*int sum = 0;

            for (int grade: grades) {
                //System.out.println(grade);
                sum = grade;
            }
            int average = sum / grade.length;*/

            // When we're done reading the file,
            // close the Scanner object attached to the file
            inFile.close();
        }
        // copying arrays
        String[] newNames = new String[20];
        newNames = namesFromFile;
        newNames[2] = "Show What Happens";

    }

    public static double average (int[] scores) {
        int sum = 0;
        for (int n: scores) {
            sum += n;
        }
        double av = (double)sum/scores.length;
        return av;
    }
}
