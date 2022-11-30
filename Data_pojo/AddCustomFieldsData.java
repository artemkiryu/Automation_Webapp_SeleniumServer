package pojo;

import java.util.Objects;

public class AddCustomFieldsData {

    private String fieldType;
    private String fieldName;
    private String fieldCode;
    private String fieldClass;
    private String options;

    public AddCustomFieldsData(String fieldType, String fieldName, String fieldCode, String fieldClass, String options) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.fieldCode = fieldCode;
        this.fieldClass = fieldClass;
        this.options = options;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public String getFieldClass() {
        return fieldClass;
    }

    public String getOptions() {
        return options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCustomFieldsData that = (AddCustomFieldsData) o;
        return Objects.equals(fieldType, that.fieldType) &&
                Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(fieldCode, that.fieldCode) &&
                Objects.equals(fieldClass, that.fieldClass) &&
                Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldType, fieldName, fieldCode, fieldClass, options);
    }

    @Override
    public String toString() {
        return "AddCustomFieldsData{" +
                "fieldType='" + fieldType + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldCode='" + fieldCode + '\'' +
                ", fieldClass='" + fieldClass + '\'' +
                ", options='" + options + '\'' +
                '}';
    }
}
