package pojo;

public class AddCustomFieldFilterData {


    private String filterType;
    private String filterValue;

    public AddCustomFieldFilterData(String filterType, String filterValue) {
        this.filterType = filterType;
        this.filterValue = filterValue;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getFilterValue() {
        return filterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCustomFieldFilterData)) return false;

        AddCustomFieldFilterData that = (AddCustomFieldFilterData) o;

        if (!getFilterType().equals(that.getFilterType())) return false;
        return getFilterValue().equals(that.getFilterValue());
    }

    @Override
    public int hashCode() {
        int result = getFilterType().hashCode();
        result = 31 * result + getFilterValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddCustomFieldFilterData{" +
                "filterType='" + filterType + '\'' +
                ", filterValue='" + filterValue + '\'' +
                '}';
    }

}
