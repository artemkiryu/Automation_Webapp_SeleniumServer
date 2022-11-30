package pojo;

/**
 * Created by infoobjects on 03-08-2017.
 */
public class AddAgenda {
    private String agendaType;
    private String agendaName;
    private String uniqueCode;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String sortOrder;
    private String ceu;
    private String capacity;
    private String maxOrder;
    private String points;
    private String tags;
    private String location;
    private String track;
    private String group;
    private String labelText;
    private String descriptionText;
    private String userNotes;
    private String classification;

    public AddAgenda(String agendaType, String agendaName, String uniqueCode, String startDate, String startTime, String endDate, String endTime, String sortOrder, String ceu, String capacity, String maxOrder, String points, String tags, String location, String track, String group, String labelText, String descriptionText, String userNotes, String classification) {
        this.agendaType = agendaType;
        this.agendaName = agendaName;
        this.uniqueCode = uniqueCode;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.ceu = ceu;
        this.capacity = capacity;
        this.maxOrder = maxOrder;
        this.points = points;
        this.tags = tags;
        this.location = location;
        this.track = track;
        this.group = group;
        this.labelText = labelText;
        this.descriptionText = descriptionText;
        this.userNotes = userNotes;
        this.classification = classification;
    }

    public AddAgenda(String agendaType, String agendaName, String uniqueCode, String sortOrder, String capacity, String maxOrder, String group, String labelText, String descriptionText, String userNotes, String classification) {
        this.agendaType = agendaType;
        this.agendaName = agendaName;
        this.uniqueCode = uniqueCode;
        this.sortOrder = sortOrder;
        this.capacity = capacity;
        this.maxOrder = maxOrder;
        this.group = group;
        this.labelText = labelText;
        this.descriptionText = descriptionText;
        this.userNotes = userNotes;
        this.classification = classification;
    }

    public AddAgenda(String agendaType, String agendaName, String uniqueCode, String sortOrder, String labelText, String descriptionText, String userNotes) {
        this.agendaType = agendaType;
        this.agendaName = agendaName;
        this.uniqueCode = uniqueCode;
        this.sortOrder = sortOrder;
        this.labelText = labelText;
        this.descriptionText = descriptionText;
        this.userNotes = userNotes;
    }

    public String getAgendaType() {
        return agendaType;
    }

    public String getAgendaName() {
        return agendaName;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public String getCeu() {
        return ceu;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getMaxOrder() {
        return maxOrder;
    }

    public String getPoints() {
        return points;
    }

    public String getTags() {
        return tags;
    }

    public String getLocation() {
        return location;
    }

    public String getTrack() {
        return track;
    }

    public String getGroup() {
        return group;
    }

    public String getLabelText() {
        return labelText;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public String getClassification() {
        return classification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddAgenda addAgenda = (AddAgenda) o;

        if (agendaType != null ? !agendaType.equals(addAgenda.agendaType) : addAgenda.agendaType != null) return false;
        if (agendaName != null ? !agendaName.equals(addAgenda.agendaName) : addAgenda.agendaName != null) return false;
        if (uniqueCode != null ? !uniqueCode.equals(addAgenda.uniqueCode) : addAgenda.uniqueCode != null) return false;
        if (startDate != null ? !startDate.equals(addAgenda.startDate) : addAgenda.startDate != null) return false;
        if (startTime != null ? !startTime.equals(addAgenda.startTime) : addAgenda.startTime != null) return false;
        if (endDate != null ? !endDate.equals(addAgenda.endDate) : addAgenda.endDate != null) return false;
        if (endTime != null ? !endTime.equals(addAgenda.endTime) : addAgenda.endTime != null) return false;
        if (sortOrder != null ? !sortOrder.equals(addAgenda.sortOrder) : addAgenda.sortOrder != null) return false;
        if (ceu != null ? !ceu.equals(addAgenda.ceu) : addAgenda.ceu != null) return false;
        if (capacity != null ? !capacity.equals(addAgenda.capacity) : addAgenda.capacity != null) return false;
        if (maxOrder != null ? !maxOrder.equals(addAgenda.maxOrder) : addAgenda.maxOrder != null) return false;
        if (points != null ? !points.equals(addAgenda.points) : addAgenda.points != null) return false;
        if (tags != null ? !tags.equals(addAgenda.tags) : addAgenda.tags != null) return false;
        if (location != null ? !location.equals(addAgenda.location) : addAgenda.location != null) return false;
        if (track != null ? !track.equals(addAgenda.track) : addAgenda.track != null) return false;
        if (group != null ? !group.equals(addAgenda.group) : addAgenda.group != null) return false;
        if (labelText != null ? !labelText.equals(addAgenda.labelText) : addAgenda.labelText != null) return false;
        if (descriptionText != null ? !descriptionText.equals(addAgenda.descriptionText) : addAgenda.descriptionText != null)
            return false;
        if (userNotes != null ? !userNotes.equals(addAgenda.userNotes) : addAgenda.userNotes != null) return false;
        return classification != null ? classification.equals(addAgenda.classification) : addAgenda.classification == null;
    }

    @Override
    public int hashCode() {
        int result = agendaType != null ? agendaType.hashCode() : 0;
        result = 31 * result + (agendaName != null ? agendaName.hashCode() : 0);
        result = 31 * result + (uniqueCode != null ? uniqueCode.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (ceu != null ? ceu.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (maxOrder != null ? maxOrder.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (labelText != null ? labelText.hashCode() : 0);
        result = 31 * result + (descriptionText != null ? descriptionText.hashCode() : 0);
        result = 31 * result + (userNotes != null ? userNotes.hashCode() : 0);
        result = 31 * result + (classification != null ? classification.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddAgenda{" +
                "agendaType='" + agendaType + '\'' +
                ", agendaName='" + agendaName + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", ceu='" + ceu + '\'' +
                ", capacity='" + capacity + '\'' +
                ", maxOrder='" + maxOrder + '\'' +
                ", points='" + points + '\'' +
                ", tags='" + tags + '\'' +
                ", location='" + location + '\'' +
                ", track='" + track + '\'' +
                ", group='" + group + '\'' +
                ", labelText='" + labelText + '\'' +
                ", descriptionText='" + descriptionText + '\'' +
                ", userNotes='" + userNotes + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}
