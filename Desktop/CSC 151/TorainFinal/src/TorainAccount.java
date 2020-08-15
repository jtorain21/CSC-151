public class TorainAccount {
    // attributes
    private long accountNumber;
    private String firstName;
    private String lastName;
    private double balance;

    // constructor
    public TorainAccount(long accountNumber, String firstName, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    //default constructor
    public TorainAccount() {

    }

    // get/set methods
    public long getAccountNumber() { return accountNumber; }

    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    // boolean methods
    public boolean deposit(double amount) {
        if (amount > 10 && amount < 3000) {
            balance = amount + balance;
            return true;
        }
        else { return false; }
    }
    public boolean withdrawal(double amount) {
        if (amount >= 10) {
            return true;
        } else { return false; }
    }
    @Override
    public String toString() {
        return "TorainAccount{" +
                "accountNumber=" + accountNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
