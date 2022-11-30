package pojo;

/**
 * Created by infoobjects on 11/8/2016.
 */
public class LinkedInAppMappings {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String pictureUrl;
    private String numConnections;
    private String id;

    public LinkedInAppMappings(String firstName, String lastName, String emailAddress, String pictureUrl, String numConnections, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.pictureUrl = pictureUrl;
        this.numConnections = numConnections;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getNumConnections() {
        return numConnections;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedInAppMappings that = (LinkedInAppMappings) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(that.pictureUrl) : that.pictureUrl != null) return false;
        if (numConnections != null ? !numConnections.equals(that.numConnections) : that.numConnections != null)
            return false;
        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + (numConnections != null ? numConnections.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LinkedInAppMappings{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", numConnections='" + numConnections + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
