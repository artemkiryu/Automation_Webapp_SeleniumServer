package pojo;

import java.util.Objects;

public class AddIFTestCaseDetails {
    private String tcID;
    private String regMail;
    private String regCode;
    private String requestID;
    private String eventCode;
    private String flowTitle;
    private String action;
    private String status;
    private String expectedStatus;

    public AddIFTestCaseDetails(String tcID, String regMail, String regCode, String requestID, String eventCode, String flowTitle, String action, String status) {
        this.tcID = tcID;
        this.regMail = regMail;
        this.regCode = regCode;
        this.requestID = requestID;
        this.eventCode = eventCode;
        this.flowTitle = flowTitle;
        this.action = action;
        this.status = status;
    }

    public AddIFTestCaseDetails(String regMail, String regCode, String requestID, String eventCode, String flowTitle, String status, String expectedStatus) {
        this.regMail = regMail;
        this.regCode = regCode;
        this.requestID = requestID;
        this.eventCode = eventCode;
        this.flowTitle = flowTitle;
        this.status = status;
        this.expectedStatus = expectedStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTcID() {
        return tcID;
    }

    public String getRegMail() {
        return regMail;
    }

    public String getRegCode() {
        return regCode;
    }

    public String getRequestID() {
        return requestID;
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public String getExpectedStatus() {
        return expectedStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddIFTestCaseDetails that = (AddIFTestCaseDetails) o;
        return Objects.equals(tcID, that.tcID) &&
                Objects.equals(regMail, that.regMail) &&
                Objects.equals(regCode, that.regCode) &&
                Objects.equals(requestID, that.requestID) &&
                Objects.equals(eventCode, that.eventCode) &&
                Objects.equals(flowTitle, that.flowTitle) &&
                Objects.equals(action, that.action) &&
                Objects.equals(status, that.status) &&
                Objects.equals(expectedStatus, that.expectedStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tcID, regMail, regCode, requestID, eventCode, flowTitle, action, status, expectedStatus);
    }

    @Override
    public String toString() {
        return "AddIFTestCaseDetails{" +
                "tcID='" + tcID + '\'' +
                ", regMail='" + regMail + '\'' +
                ", regCode='" + regCode + '\'' +
                ", requestID='" + requestID + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", flowTitle='" + flowTitle + '\'' +
                ", action='" + action + '\'' +
                ", status='" + status + '\'' +
                ", expectedStatus='" + expectedStatus + '\'' +
                '}';
    }

}
