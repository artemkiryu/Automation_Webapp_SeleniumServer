package pojo;

/**
 * Created by infoobjects on 26-09-2017.
 */
public class AddNewRegistrationDataForGroup {

    private String firstName;
    private String lastName;
    private String attendeeType;


    public AddNewRegistrationDataForGroup(String firstName, String lastName, String attendeeType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.attendeeType = attendeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddNewRegistrationDataForGroup)) return false;

        AddNewRegistrationDataForGroup that = (AddNewRegistrationDataForGroup) o;

        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        return getAttendeeType().equals(that.getAttendeeType());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAttendeeType().hashCode();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAttendeeType() {
        return attendeeType;
    }

    @Override
    public String toString() {
        return "AddRegistrationDataForGroup{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", attendeeType='" + attendeeType + '\'' +
                '}';
    }

}
