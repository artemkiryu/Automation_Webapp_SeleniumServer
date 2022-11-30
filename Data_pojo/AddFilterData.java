package pojo;

import java.util.Objects;

public class AddFilterData {

    private String flowTitle;
    private String filterType;
    private String fieldName;
    private String operator;
    private String searchString;
    private String attendeeTag;
    private String sessionTag;

    public AddFilterData(String flowTitle, String filterType, String fieldName, String operator, String searchString, String sessionTag) {
        this.flowTitle = flowTitle;
        this.filterType = filterType;
        this.fieldName = fieldName;
        this.operator = operator;
        this.searchString = searchString;
        this.sessionTag = sessionTag;
    }

    public AddFilterData(String flowTitle, String filterType, String attendeeTag) {
        this.flowTitle = flowTitle;
        this.filterType = filterType;
        this.attendeeTag = attendeeTag;
    }

    public AddFilterData(String flowTitle, String filterType, String fieldName, String operator, String searchString) {
        this.flowTitle = flowTitle;
        this.filterType = filterType;
        this.fieldName = fieldName;
        this.operator = operator;
        this.searchString = searchString;
    }

    public AddFilterData(String flowTitle, String filterType, String fieldName, String operator, String searchString, String attendeeTag, String sessionTag) {
        this.flowTitle = flowTitle;
        this.filterType = filterType;
        this.fieldName = fieldName;
        this.operator = operator;
        this.searchString = searchString;
        this.attendeeTag = attendeeTag;
        this.sessionTag = sessionTag;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOperator() {
        return operator;
    }

    public String getSearchString() {
        return searchString;
    }

    public String getAttendeeTag() {
        return attendeeTag;
    }

    public String getSessionTag() {
        return sessionTag;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFilterData that = (AddFilterData) o;
        return Objects.equals(flowTitle, that.flowTitle) &&
                Objects.equals(filterType, that.filterType) &&
                Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(searchString, that.searchString) &&
                Objects.equals(attendeeTag, that.attendeeTag) &&
                Objects.equals(sessionTag, that.sessionTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowTitle, filterType, fieldName, operator, searchString, attendeeTag, sessionTag);
    }

    @Override
    public String toString() {
        return "AddFilterData{" +
                "flowTitle='" + flowTitle + '\'' +
                ", filterType='" + filterType + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", operator='" + operator + '\'' +
                ", searchString='" + searchString + '\'' +
                ", attendeeTag='" + attendeeTag + '\'' +
                ", sessionTag='" + sessionTag + '\'' +
                '}';
    }

}
