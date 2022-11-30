package pojo;

import java.util.Objects;

public class SessionPageFilters {

    public String FieldType;
    public String FieldName;

    public SessionPageFilters(String fieldType, String fieldName) {
        FieldType = fieldType;
        FieldName = fieldName;
    }

    public String getFieldType() {
        return FieldType;
    }

    public String getFieldName() {
        return FieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionPageFilters that = (SessionPageFilters) o;
        return Objects.equals(FieldType, that.FieldType) &&
                Objects.equals(FieldName, that.FieldName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(FieldType, FieldName);
    }

    @Override
    public String toString() {
        return "SessionPageFilters{" +
                "FieldType='" + FieldType + '\'' +
                ", FieldName='" + FieldName + '\'' +
                '}';
    }
}
