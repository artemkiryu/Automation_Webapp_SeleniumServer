package pojo;

/**
 * Created by infoobjects on 29-08-2017.
 */
public class GroupDetailsData {

    private String groupName;
    private String groupCode;
    private String description;
    private String notes;
    private String attendeeType;

    public GroupDetailsData(String groupName, String groupCode, String description, String notes, String attendeeType) {
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.description = description;
        this.notes = notes;
        this.attendeeType = attendeeType;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public String getAttendeeType() {
        return attendeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupDetailsData)) return false;

        GroupDetailsData that = (GroupDetailsData) o;

        if (!getGroupName().equals(that.getGroupName())) return false;
        if (!getGroupCode().equals(that.getGroupCode())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (!getNotes().equals(that.getNotes())) return false;
        return getAttendeeType().equals(that.getAttendeeType());
    }

    @Override
    public int hashCode() {
        int result = getGroupName().hashCode();
        result = 31 * result + getGroupCode().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getNotes().hashCode();
        result = 31 * result + getAttendeeType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GroupDetailsData{" +
                "groupName='" + groupName + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", attendeeType='" + attendeeType + '\'' +
                '}';
    }

}
