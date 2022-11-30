package pojo;

import java.util.Objects;

public class AddFormPostData {
    private String formPostName;
    private String regStatuses;
    private String regProperties;
    private String regSessionStatus;
    private String url;
    private String method;
    private String sourceName;
    private String value;
    private String formFieldName;

    public AddFormPostData(String formPostName, String regStatuses, String regProperties, String regSessionStatus, String url, String method, String sourceName, String value, String formFieldName) {
        this.formPostName = formPostName;
        this.regStatuses = regStatuses;
        this.regProperties = regProperties;
        this.regSessionStatus = regSessionStatus;
        this.url = url;
        this.method = method;
        this.sourceName = sourceName;
        this.value = value;
        this.formFieldName = formFieldName;
    }

    public String getFormPostName() {
        return formPostName;
    }

    public String getRegStatuses() {
        return regStatuses;
    }

    public String getRegProperties() {
        return regProperties;
    }

    public String getRegSessionStatus() {
        return regSessionStatus;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getValue() {
        return value;
    }

    public String getFormFieldName() {
        return formFieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFormPostData that = (AddFormPostData) o;
        return Objects.equals(formPostName, that.formPostName) &&
                Objects.equals(regStatuses, that.regStatuses) &&
                Objects.equals(regProperties, that.regProperties) &&
                Objects.equals(regSessionStatus, that.regSessionStatus) &&
                Objects.equals(url, that.url) &&
                Objects.equals(method, that.method) &&
                Objects.equals(sourceName, that.sourceName) &&
                Objects.equals(value, that.value) &&
                Objects.equals(formFieldName, that.formFieldName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(formPostName, regStatuses, regProperties, regSessionStatus, url, method, sourceName, value, formFieldName);
    }

    @Override
    public String toString() {
        return "AddFormPostData{" +
                "formPostName='" + formPostName + '\'' +
                ", regStatuses='" + regStatuses + '\'' +
                ", regProperties='" + regProperties + '\'' +
                ", regSessionStatus='" + regSessionStatus + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", value='" + value + '\'' +
                ", formFieldName='" + formFieldName + '\'' +
                '}';
    }
}
