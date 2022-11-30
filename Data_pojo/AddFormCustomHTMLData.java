package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormCustomHTMLData {

    private String customSectionHTMLName;

    public AddFormCustomHTMLData(String customSectionHTMLName) {
        this.customSectionHTMLName = customSectionHTMLName;
    }

    public String getCustomSectionHTMLName() {
        return customSectionHTMLName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddFormCustomHTMLData that = (AddFormCustomHTMLData) o;

        return customSectionHTMLName != null ? customSectionHTMLName.equals(that.customSectionHTMLName) : that.customSectionHTMLName == null;
    }

    @Override
    public int hashCode() {
        return customSectionHTMLName != null ? customSectionHTMLName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AddFormCustomHTMLData{" +
                "customSectionHTMLName='" + customSectionHTMLName + '\'' +
                '}';
    }
}
