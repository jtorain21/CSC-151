import java.util.Date;

public class TorainPerson {
    String firstName;
    String lastName;
    Date dob;
    TorainAddress address;

    public TorainPerson() {

    }

    public TorainPerson(String firstName, String lastName, Date dob, TorainAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public TorainAddress getAddress() {
        return address;
    }

    public void setAddress(TorainAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TorainPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                '}';
    }
}
