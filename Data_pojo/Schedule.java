package pojo;

import java.util.Objects;

public class Schedule {

    private String meetingId;
    private String status;
    private String sourceAction;
    private String startTime;
    private String frequency;
    private String timeZone;

    public Schedule(String meetingId, String status, String sourceAction, String startTime, String frequency, String timeZone) {
        this.meetingId = meetingId;
        this.status = status;
        this.sourceAction = sourceAction;
        this.startTime = startTime;
        this.frequency = frequency;
        this.timeZone = timeZone;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public String getStatus() {
        return status;
    }

    public String getSourceAction() {
        return sourceAction;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getTimeZone() {
        return timeZone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule that = (Schedule) o;
        return Objects.equals(meetingId, that.meetingId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(sourceAction, that.sourceAction) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(frequency, that.frequency) &&
                Objects.equals(timeZone, that.timeZone);

    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId, status, sourceAction, startTime, frequency, timeZone);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "meetingId='" + meetingId + '\'' +
                ", status='" + status + '\'' +
                ", sourceAction='" + sourceAction + '\'' +
                ", startTime='" + startTime + '\'' +
                ", frequency='" + frequency + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }

}
