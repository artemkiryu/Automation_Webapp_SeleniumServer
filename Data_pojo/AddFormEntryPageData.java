package pojo;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class AddFormEntryPageData {

    private String dataFieldName;

    public AddFormEntryPageData(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }

    public String getDataFieldName() {
        return dataFieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddFormEntryPageData)) return false;

        AddFormEntryPageData that = (AddFormEntryPageData) o;

        return getDataFieldName() != null ? getDataFieldName().equals(that.getDataFieldName()) : that.getDataFieldName() == null;
    }

    @Override
    public int hashCode() {
        return getDataFieldName() != null ? getDataFieldName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AddFormEntryPageData{" +
                "dataFieldName='" + dataFieldName + '\'' +
                '}';
    }

   }
