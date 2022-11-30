package pojo;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class CustomStatusData {
    private String name;
    private String sortOrder;
    private String statusGroup;
    private String groupName;
    private String description;
    private String status;

    public CustomStatusData(String name, String sortOrder, String statusGroup, String groupName, String description, String status) {
        this.name = name;
        this.sortOrder = sortOrder;
        this.statusGroup = statusGroup;
        this.groupName = groupName;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public String getStatusGroup() {
        return statusGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomStatusData)) return false;

        CustomStatusData that = (CustomStatusData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (statusGroup != null ? !statusGroup.equals(that.statusGroup) : that.statusGroup != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return !(status != null ? !status.equals(that.status) : that.status != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (statusGroup != null ? statusGroup.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomStatusData{" +
                "name='" + name + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", statusGroup='" + statusGroup + '\'' +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
