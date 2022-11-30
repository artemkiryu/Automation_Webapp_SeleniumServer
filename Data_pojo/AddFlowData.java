package pojo;

import java.util.Objects;

public class AddFlowData {

    private String flowTitle;
    private String flowSource;
    private String regStatus;
    private String regCustomTags;
    private String regSessionStatus;
    private String flowType;
    private String eventStatus;
    private String flowCategory;

    public AddFlowData(String flowTitle, String flowSource, String regStatus, String regCustomTags, String regSessionStatus, String flowType, String eventStatus, String flowCategory) {
        this.flowTitle = flowTitle;
        this.flowSource = flowSource;
        this.regStatus = regStatus;
        this.regCustomTags = regCustomTags;
        this.regSessionStatus = regSessionStatus;
        this.flowType = flowType;
        this.eventStatus = eventStatus;
        this.flowCategory = flowCategory;
    }

    public AddFlowData(String flowTitle, String flowSource, String regStatus, String regCustomTags, String regSessionStatus, String flowType) {
        this.flowTitle = flowTitle;
        this.flowSource = flowSource;
        this.regStatus = regStatus;
        this.regCustomTags = regCustomTags;
        this.regSessionStatus = regSessionStatus;
        this.flowType = flowType;
    }

    public AddFlowData(String flowTitle, String flowSource, String regStatus, String regCustomTags, String regSessionStatus, String flowType, String eventStatus) {
        this.flowTitle = flowTitle;
        this.flowSource = flowSource;
        this.regStatus = regStatus;
        this.regCustomTags = regCustomTags;
        this.regSessionStatus = regSessionStatus;
        this.flowType = flowType;
        this.eventStatus = eventStatus;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public String getFlowSource() {
        return flowSource;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public String getRegCustomTags() {
        return regCustomTags;
    }

    public String getRegSessionStatus() {
        return regSessionStatus;
    }

    public String getFlowType() {
        return flowType;
    }

    public String getFlowCategory() {
        return flowCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFlowData that = (AddFlowData) o;
        return Objects.equals(flowTitle, that.flowTitle) &&
                Objects.equals(flowSource, that.flowSource) &&
                Objects.equals(regStatus, that.regStatus) &&
                Objects.equals(regCustomTags, that.regCustomTags) &&
                Objects.equals(regSessionStatus, that.regSessionStatus) &&
                Objects.equals(flowType, that.flowType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowTitle, flowSource, regStatus, regCustomTags, regSessionStatus, flowType);
    }

    @Override
    public String toString() {
        return "AddFlowData{" +
                "flowTitle='" + flowTitle + '\'' +
                ", flowSource='" + flowSource + '\'' +
                ", regStatus='" + regStatus + '\'' +
                ", regCustomTags='" + regCustomTags + '\'' +
                ", regSessionStatus='" + regSessionStatus + '\'' +
                ", flowType='" + flowType + '\'' +
                '}';
    }


}
