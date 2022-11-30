package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 8/13/2015.
 */
public class AddTags {
    private String tagName;
    private String tagLabel;
    private String tagObject;

    public AddTags(String tagName, String tagLabel, String tagObject) {
        this.tagName = tagName;
        this.tagLabel = tagLabel;
        this.tagObject = tagObject;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagLabel() {
        return tagLabel;
    }

    public String getTagObject() {
        return tagObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTags addTags = (AddTags) o;
        return Objects.equals(tagName, addTags.tagName) &&
                Objects.equals(tagLabel, addTags.tagLabel) &&
                Objects.equals(tagObject, addTags.tagObject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tagName, tagLabel, tagObject);
    }

    @Override
    public String toString() {
        return "AddTags{" +
                "tagName='" + tagName + '\'' +
                ", tagLabel='" + tagLabel + '\'' +
                ", tagObject='" + tagObject + '\'' +
                '}';
    }
}
