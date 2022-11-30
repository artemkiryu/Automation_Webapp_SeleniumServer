package pojo;

import java.util.Objects;

public class SubmitterInfo {
    private String email;
    private String firstName;
    private String lastName;
    private String position;

    public SubmitterInfo(String email, String firstName, String lastName, String position) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmitterInfo that = (SubmitterInfo) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, firstName, lastName, position);
    }

    @Override
    public String toString() {
        return "SubmitterInfo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
