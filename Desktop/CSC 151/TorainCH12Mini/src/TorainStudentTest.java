import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TorainStudentTest {
    public static void main(String[] args) throws FileNotFoundException {
        // open file
        File studentDataFile = new File ("./src/Student.txt");
        // create array of length 5
        String[] studentDataFromFile = new String[5];

        if (studentDataFile.exists()) {
            //instantiate scanner outside try/catch.
            Scanner studentInput;
            try {
                studentInput = new Scanner(studentDataFile);
            } catch (FileNotFoundException ex) {
                throw new FileNotFoundException("The path to the text file is incorrect!");
            }
            // instantiate index variable
            int index = 0;
            // use while loop to read file
            while (studentInput.hasNext()) {
                // read data into variables
                int studentID;
                try {
                    studentID = studentInput.nextInt();
                } catch (InputMismatchException ex) {
                    studentID = 0;
                    studentInput.next();
                }
                String firstName = studentInput.next();
                String lastName = studentInput.next();
                String dateOfBirth = studentInput.next();
                double accountBalance = 0.0;
                TorainStudent student = new TorainStudent(firstName, lastName, dateOfBirth, studentID, accountBalance);
                try {
                    studentDataFromFile[index] = student.toString();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    throw new ArrayIndexOutOfBoundsException("Too Many Students!");
                }
                System.out.println(student.toString());

                index++;
            }
        }
    }
    public static void getBalance (String[] studentDataFromFile, int index) {
        for ()
    }
}

