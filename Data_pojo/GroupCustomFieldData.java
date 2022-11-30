package pojo;

/**
 * Created by infoobjects on 29-08-2017.
 */
public class GroupCustomFieldData {

    private String customFieldName;

    public GroupCustomFieldData(String customFieldName) {
        this.customFieldName = customFieldName;
    }

    public String getCustomFieldName() {
        return customFieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupCustomFieldData)) return false;

        GroupCustomFieldData that = (GroupCustomFieldData) o;

        return getCustomFieldName().equals(that.getCustomFieldName());
    }

    @Override
    public int hashCode() {
        return getCustomFieldName().hashCode();
    }

    @Override
    public String toString() {
        return "GroupCustomFieldData{" +
                "customFieldName='" + customFieldName + '\'' +
                '}';
    }


}
