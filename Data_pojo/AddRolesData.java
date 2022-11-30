package pojo;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class AddRolesData {

    private String name;
    private String sortOrder;

    public AddRolesData(String name, String sortOrder) {
        this.name = name;
        this.sortOrder = sortOrder;
    }

    public String getName() {
        return name;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddRolesData)) return false;

        AddRolesData that = (AddRolesData) o;

        if (!getName().equals(that.getName())) return false;
        return getSortOrder().equals(that.getSortOrder());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSortOrder().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddRolesData{" +
                "name='" + name + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }

}
