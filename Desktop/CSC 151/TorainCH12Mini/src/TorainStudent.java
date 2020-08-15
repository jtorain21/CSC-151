public class TorainStudent {
    // Attributes
    String firstName;
    String lastName;
    String DateOfBirth;
    int studentID;
    double accountBalance;

    // Constructor
    public TorainStudent(String firstName, String lastName, String dateOfBirth, int studentID, double accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.studentID = studentID;
        this.accountBalance = accountBalance;
    }
    // get/set methods

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDateOfBirth() { return DateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { DateOfBirth = dateOfBirth; }

    public int getStudentID() { return studentID; }

    public void setStudentID(int studentID) { this.studentID = studentID; }

    public double getAccountBalance() { return accountBalance; }

    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }

    // toString()

    @Override
    public String toString() {
        return "TorainStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", studentID=" + studentID +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
