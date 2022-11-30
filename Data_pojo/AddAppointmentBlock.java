package pojo;

/**
 * Created by Aditi on 23-06-2015.
 */
public class AddAppointmentBlock {
    private String blockName;
    private String startDate;
    private String fromTime;
    private String toTime;
    private String duration;
    private String travelTime;

    public AddAppointmentBlock(String blockName, String startDate, String fromTime, String toTime, String duration, String travelTime) {
        this.blockName = blockName;
        this.startDate = startDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.duration = duration;
        this.travelTime = travelTime;
    }

    public String getBlockName() {
        return blockName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getTravelTime() {
        return travelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddAppointmentBlock)) return false;

        AddAppointmentBlock that = (AddAppointmentBlock) o;

        if (getBlockName() != null ? !getBlockName().equals(that.getBlockName()) : that.getBlockName() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getFromTime() != null ? !getFromTime().equals(that.getFromTime()) : that.getFromTime() != null)
            return false;
        if (getToTime() != null ? !getToTime().equals(that.getToTime()) : that.getToTime() != null) return false;
        if (getDuration() != null ? !getDuration().equals(that.getDuration()) : that.getDuration() != null)
            return false;
        return !(getTravelTime() != null ? !getTravelTime().equals(that.getTravelTime()) : that.getTravelTime() != null);

    }

    @Override
    public int hashCode() {
        int result = getBlockName() != null ? getBlockName().hashCode() : 0;
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getFromTime() != null ? getFromTime().hashCode() : 0);
        result = 31 * result + (getToTime() != null ? getToTime().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + (getTravelTime() != null ? getTravelTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddAppointmentBlock{" +
                "blockName='" + blockName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", duration='" + duration + '\'' +
                ", travelTime='" + travelTime + '\'' +
                '}';
    }
}
