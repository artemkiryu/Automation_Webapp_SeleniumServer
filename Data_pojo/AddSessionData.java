package pojo;

public class AddSessionData {

    private String instanceStartTime;
    private boolean overrideCapacity;
    private String capacity;
    private String instanceStartDate;
    private String location;
    private String waitListLimit;
    private String instanceEndTime;
    private String instanceSpeakers;

    private String sessionName;
    private String sessionType;
    private String sessionCode;
    private String sessionTrack;
    private String tags;
    private String sessionLevel;
    private String points;
    private String durationHrs;
    private String durationMins;
    private String ceuCredits;
    private String instances;
    private String speakers;
    private String notes;
    private String abstractDescription;
    private String abstractFile;
    private String sessionFile;
    private String sessionDescription;
    private String sessionLabel;
    private String jobFunction;
    private String industry;

    private String instanceCode;
    private String instanceEndDate;
    private String locationName;
    private String sessionNotes;
    private String overrideCapacityValue;

    private String noOfInstances;
    private String totalDuration;
    private String layoutType;

    public AddSessionData(String instanceStartTime, boolean overrideCapacity, String capacity, String instanceStartDate, String location, String waitListLimit, String instanceEndTime, String instanceSpeakers, String instanceCode) {
        this.instanceStartTime = instanceStartTime;
        this.overrideCapacity = overrideCapacity;
        this.capacity = capacity;
        this.instanceStartDate = instanceStartDate;
        this.location = location;
        this.waitListLimit = waitListLimit;
        this.instanceEndTime = instanceEndTime;
        this.instanceSpeakers = instanceSpeakers;
        this.instanceCode = instanceCode;
    }


    public AddSessionData(String sessionName, String sessionType, String sessionCode, String sessionTrack, String tags, String sessionLevel, String points, String durationHrs, String durationMins, String ceuCredits, String instances, String speakers, String notes, String abstractDescription, String abstractFile, String sessionFile, String sessionDescription) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.sessionCode = sessionCode;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.durationHrs = durationHrs;
        this.durationMins = durationMins;
        this.ceuCredits = ceuCredits;
        this.instances = instances;
        this.speakers = speakers;
        this.notes = notes;
        this.abstractDescription = abstractDescription;
        this.abstractFile = abstractFile;
        this.sessionFile = sessionFile;
        this.sessionDescription = sessionDescription;
    }

    public AddSessionData(String sessionName, String sessionType, String sessionCode, String sessionTrack, String tags, String sessionLevel, String points, String durationHrs, String durationMins, String ceuCredits, String instances, String speakers, String notes, String abstractDescription, String abstractFile, String sessionFile, String sessionDescription, String sessionLabel, String jobFunction, String industry) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.sessionCode = sessionCode;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.durationHrs = durationHrs;
        this.durationMins = durationMins;
        this.ceuCredits = ceuCredits;
        this.instances = instances;
        this.speakers = speakers;
        this.notes = notes;
        this.abstractDescription = abstractDescription;
        this.abstractFile = abstractFile;
        this.sessionFile = sessionFile;
        this.sessionDescription = sessionDescription;
        this.sessionLabel = sessionLabel;
        this.jobFunction = jobFunction;
        this.industry = industry;
    }

    public AddSessionData(String sessionName, String sessionType, String sessionCode, String sessionTrack, String tags, String sessionLevel, String points, String ceuCredits, String notes, String abstractDescription, String sessionDescription, String sessionLabel, String jobFunction, String industry) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.sessionCode = sessionCode;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.ceuCredits = ceuCredits;
        this.notes = notes;
        this.abstractDescription = abstractDescription;
        this.sessionDescription = sessionDescription;
        this.sessionLabel = sessionLabel;
        this.jobFunction = jobFunction;
        this.industry = industry;
    }

    public AddSessionData(String instanceStartTime, boolean overrideCapacity, String capacity, String instanceStartDate, String location, String waitListLimit, String instanceEndTime, String instanceSpeakers) {
        this.instanceStartTime = instanceStartTime;
        this.overrideCapacity = overrideCapacity;
        this.capacity = capacity;
        this.instanceStartDate = instanceStartDate;
        this.location = location;
        this.waitListLimit = waitListLimit;
        this.instanceEndTime = instanceEndTime;
        this.instanceSpeakers = instanceSpeakers;
    }

    public AddSessionData(String instanceStartTime, boolean overrideCapacity, String capacity, String instanceStartDate, String waitListLimit, String instanceEndTime, String instanceSpeakers) {
        this.instanceStartTime = instanceStartTime;
        this.overrideCapacity = overrideCapacity;
        this.capacity = capacity;
        this.instanceStartDate = instanceStartDate;
        this.waitListLimit = waitListLimit;
        this.instanceEndTime = instanceEndTime;
        this.instanceSpeakers = instanceSpeakers;
    }

    public AddSessionData(String speakers, String location, String capacity, String waitListLimit, boolean overrideCapacity, String instanceStartTime, String instanceEndTime, String instanceStartDate) {
        this.speakers = speakers;
        this.location = location;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacity = overrideCapacity;
        this.instanceStartTime = instanceStartTime;
        this.instanceEndTime = instanceEndTime;
        this.instanceStartDate = instanceStartDate;

    }

    public AddSessionData(String speakers, String capacity, String waitListLimit, boolean overrideCapacity, String instanceStartTime, String instanceEndTime, String instanceStartDate) {
        this.speakers = speakers;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacity = overrideCapacity;
        this.instanceStartTime = instanceStartTime;
        this.instanceEndTime = instanceEndTime;
        this.instanceStartDate = instanceStartDate;

    }

    public AddSessionData(String instanceSpeakers, String location, String capacity, String waitListLimit, boolean overrideCapacity, String instanceStartTime, String instanceEndTime) {
        this.instanceSpeakers = instanceSpeakers;
        this.location = location;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacity = overrideCapacity;
        this.instanceStartTime = instanceStartTime;
        this.instanceEndTime = instanceEndTime;
    }

    public AddSessionData(String instanceSpeakers, String capacity, String waitListLimit, boolean overrideCapacity, String instanceStartTime, String instanceEndTime) {
        this.instanceSpeakers = instanceSpeakers;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacity = overrideCapacity;
        this.instanceStartTime = instanceStartTime;
        this.instanceEndTime = instanceEndTime;
    }

    public AddSessionData(String sessionName, String sessionType, String sessionCode, String sessionTrack, String tags, String sessionLevel, String points, String ceuCredits, String speakers, String notes, String abstractDescription, String sessionDescription, String sessionLabel, String jobFunction, String industry) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.sessionCode = sessionCode;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.ceuCredits = ceuCredits;
        this.speakers = instanceSpeakers;
        this.notes = notes;
        this.abstractDescription = abstractDescription;
        this.sessionDescription = sessionDescription;
        this.sessionLabel = sessionLabel;
        this.jobFunction = jobFunction;
        this.industry = industry;
    }

    //constructor for export session without abstract description and session description
    public AddSessionData(String sessionName, String sessionCode, String sessionType, String points, String instanceCode, String startDate, String endDate, String locationName, String locationCode, String capacity, String waitListLimit, String overrideCapacityValue, String speakers, String sessionNotes, String ceuCredits, String sessionLabel, String sessionLevel,
                          String sessionTrack, String jobFunction, String industry, String tags) {
        this.sessionName = sessionName;
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.points = points;
        this.instanceCode = instanceCode;
        this.instanceStartDate = startDate;
        this.instanceEndDate = endDate;
        this.locationName = locationName;
        this.location = locationCode;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacityValue = overrideCapacityValue;
        this.speakers = speakers;
        this.sessionNotes = sessionNotes;
        this.ceuCredits = ceuCredits;
        this.sessionLabel = sessionLabel;
        this.sessionLevel = sessionLevel;
        this.sessionTrack = sessionTrack;
        this.jobFunction = jobFunction;
        this.industry = industry;
        this.tags = tags;

    }

    //constructor for export session
    public AddSessionData(String sessionName, String sessionCode, String sessionType, String points, String instanceCode, String startDate, String endDate, String locationName, String locationCode, String capacity, String waitListLimit, String overrideCapacityValue, String speakers, String abstractDescription, String sessionNotes, String sessionDescription, String ceuCredits, String sessionLabel, String sessionLevel,
                          String sessionTrack, String jobFunction, String industry, String tags) {
        this.sessionName = sessionName;
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.points = points;
        this.instanceCode = instanceCode;
        this.instanceStartDate = startDate;
        this.instanceEndDate = endDate;
        this.locationName = locationName;
        this.location = locationCode;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacityValue = overrideCapacityValue;
        this.speakers = speakers;
        this.abstractDescription = abstractDescription;
        this.sessionNotes = sessionNotes;
        this.sessionDescription = sessionDescription;
        this.ceuCredits = ceuCredits;
        this.sessionLabel = sessionLabel;
        this.sessionLevel = sessionLevel;
        this.sessionTrack = sessionTrack;
        this.jobFunction = jobFunction;
        this.industry = industry;
        this.tags = tags;

    }

    //constructor for export conference session
    public AddSessionData(String layoutType, String sessionName, String sessionCode, String sessionType, String sessionTrack, String tags, String sessionLevel, String points, String duration, String ceuCredits, String noOfInstances, String speakers, String abstractDescription, String sessionDescription, String sessionNotes, String industry, String sessionLabel, String jobFunction) {

        this.layoutType = layoutType;
        this.sessionName = sessionName;
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.totalDuration = duration;
        this.ceuCredits = ceuCredits;
        this.noOfInstances = noOfInstances;
        this.speakers = speakers;
        this.abstractDescription = abstractDescription;
        this.sessionDescription = sessionDescription;
        this.sessionNotes = sessionNotes;
        this.industry = industry;
        this.sessionLabel = sessionLabel;
        this.jobFunction = jobFunction;

    }

    public AddSessionData(String sessionName, String sessionCode, String sessionType, String sessionTrack, String tags, String sessionLevel, String points, String duration, String ceuCredits, String speakers, String abstractDescription, String sessionDescription, String sessionNotes, String industry, String sessionLabel, String jobFunction) {

        this.sessionName = sessionName;
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.sessionTrack = sessionTrack;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.points = points;
        this.totalDuration = duration;
        this.ceuCredits = ceuCredits;
        this.speakers = speakers;
        this.abstractDescription = abstractDescription;
        this.sessionDescription = sessionDescription;
        this.sessionNotes = sessionNotes;
        this.industry = industry;
        this.sessionLabel = sessionLabel;
        this.jobFunction = jobFunction;

    }

    public AddSessionData(String instanceCode, String instanceStartDate, String instanceEndDate, String locationName, String location, String capacity, String waitListLimit, String overrideCapacityValue, String instanceSpeakers) {
        this.instanceCode = instanceCode;
        this.instanceStartDate = instanceStartDate;
        this.instanceEndDate = instanceEndDate;
        this.locationName = locationName;
        this.location = location;
        this.capacity = capacity;
        this.waitListLimit = waitListLimit;
        this.overrideCapacityValue = overrideCapacityValue;
        this.instanceSpeakers = instanceSpeakers;

    }


    public String getInstanceSpeakers() {
        return instanceSpeakers;
    }

    public String getInstanceStartTime() {
        return instanceStartTime;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getInstanceStartDate() {
        return instanceStartDate;
    }

    public String getLocation() {
        return location;
    }

    public String getWaitListLimit() {
        return waitListLimit;
    }

    public String getInstanceEndTime() {
        return instanceEndTime;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionType() {
        return sessionType;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public String getSessionTrack() {
        return sessionTrack;
    }

    public String getTags() {
        return tags;
    }

    public String getSessionLevel() {
        return sessionLevel;
    }

    public String getPoints() {
        return points;
    }

    public String getDurationHrs() {
        return durationHrs;
    }

    public String getDurationMins() {
        return durationMins;
    }

    public String getCeuCredits() {
        return ceuCredits;
    }

    public String getInstances() {
        return instances;
    }

    public String getSpeakers() {
        return speakers;
    }

    public String getNotes() {
        return notes;
    }

    public String getAbstractDescription() {
        return abstractDescription;
    }

    public String getAbstractFile() {
        return abstractFile;
    }

    public String getSessionFile() {
        return sessionFile;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public String getSessionLabel() {
        return sessionLabel;
    }

    public String getJobFunction() {
        return jobFunction;
    }

    public String getIndustry() {
        return industry;
    }

    public boolean isOverrideCapacity() {
        return overrideCapacity;
    }

    public String getInstanceCode() {
        return instanceCode;
    }

    public String getInstanceEndDate() {
        return instanceEndDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public String getOverrideCapacityValue() {
        return overrideCapacityValue;
    }

    public String getNoOfInstances() {
        return noOfInstances;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    @Override
    public String toString() {
        return "AddSessionData{" +
                "instanceStartTime='" + instanceStartTime + '\'' +
                ", overrideCapacity=" + overrideCapacity +
                ", capacity='" + capacity + '\'' +
                ", instanceStartDate='" + instanceStartDate + '\'' +
                ", location='" + location + '\'' +
                ", waitListLimit='" + waitListLimit + '\'' +
                ", instanceEndTime='" + instanceEndTime + '\'' +
                ", instanceSpeakers='" + instanceSpeakers + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", sessionType='" + sessionType + '\'' +
                ", sessionCode='" + sessionCode + '\'' +
                ", sessionTrack='" + sessionTrack + '\'' +
                ", tags='" + tags + '\'' +
                ", sessionLevel='" + sessionLevel + '\'' +
                ", points='" + points + '\'' +
                ", durationHrs='" + durationHrs + '\'' +
                ", durationMins='" + durationMins + '\'' +
                ", ceuCredits='" + ceuCredits + '\'' +
                ", instances='" + instances + '\'' +
                ", speakers='" + speakers + '\'' +
                ", notes='" + notes + '\'' +
                ", abstractDescription='" + abstractDescription + '\'' +
                ", abstractFile='" + abstractFile + '\'' +
                ", sessionFile='" + sessionFile + '\'' +
                ", sessionDescription='" + sessionDescription + '\'' +
                ", sessionLabel='" + sessionLabel + '\'' +
                ", jobFunction='" + jobFunction + '\'' +
                ", industry='" + industry + '\'' +
                ", instanceCode='" + instanceCode + '\'' +
                ", instanceEndDate='" + instanceEndDate + '\'' +
                ", locationName='" + locationName + '\'' +
                ", sessionNotes='" + sessionNotes + '\'' +
                ", overrideCapacityValue='" + overrideCapacityValue + '\'' +
                ", noOfInstances='" + noOfInstances + '\'' +
                ", totalDuration='" + totalDuration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddSessionData)) return false;

        AddSessionData that = (AddSessionData) o;

        if (isOverrideCapacity() != that.isOverrideCapacity()) return false;
        if (getInstanceStartTime() != null ? !getInstanceStartTime().equals(that.getInstanceStartTime()) : that.getInstanceStartTime() != null)
            return false;
        if (getCapacity() != null ? !getCapacity().equals(that.getCapacity()) : that.getCapacity() != null)
            return false;
        if (getInstanceStartDate() != null ? !getInstanceStartDate().equals(that.getInstanceStartDate()) : that.getInstanceStartDate() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null)
            return false;
        if (getWaitListLimit() != null ? !getWaitListLimit().equals(that.getWaitListLimit()) : that.getWaitListLimit() != null)
            return false;
        if (getInstanceEndTime() != null ? !getInstanceEndTime().equals(that.getInstanceEndTime()) : that.getInstanceEndTime() != null)
            return false;
        if (getInstanceSpeakers() != null ? !getInstanceSpeakers().equals(that.getInstanceSpeakers()) : that.getInstanceSpeakers() != null)
            return false;
        if (getSessionName() != null ? !getSessionName().equals(that.getSessionName()) : that.getSessionName() != null)
            return false;
        if (getSessionType() != null ? !getSessionType().equals(that.getSessionType()) : that.getSessionType() != null)
            return false;
        if (getSessionCode() != null ? !getSessionCode().equals(that.getSessionCode()) : that.getSessionCode() != null)
            return false;
        if (getSessionTrack() != null ? !getSessionTrack().equals(that.getSessionTrack()) : that.getSessionTrack() != null)
            return false;
        if (getTags() != null ? !getTags().equals(that.getTags()) : that.getTags() != null) return false;
        if (getSessionLevel() != null ? !getSessionLevel().equals(that.getSessionLevel()) : that.getSessionLevel() != null)
            return false;
        if (getPoints() != null ? !getPoints().equals(that.getPoints()) : that.getPoints() != null) return false;
        if (getDurationHrs() != null ? !getDurationHrs().equals(that.getDurationHrs()) : that.getDurationHrs() != null)
            return false;
        if (getDurationMins() != null ? !getDurationMins().equals(that.getDurationMins()) : that.getDurationMins() != null)
            return false;
        if (getCeuCredits() != null ? !getCeuCredits().equals(that.getCeuCredits()) : that.getCeuCredits() != null)
            return false;
        if (getInstances() != null ? !getInstances().equals(that.getInstances()) : that.getInstances() != null)
            return false;
        if (getSpeakers() != null ? !getSpeakers().equals(that.getSpeakers()) : that.getSpeakers() != null)
            return false;
        if (getNotes() != null ? !getNotes().equals(that.getNotes()) : that.getNotes() != null) return false;
        if (getAbstractDescription() != null ? !getAbstractDescription().equals(that.getAbstractDescription()) : that.getAbstractDescription() != null)
            return false;
        if (getAbstractFile() != null ? !getAbstractFile().equals(that.getAbstractFile()) : that.getAbstractFile() != null)
            return false;
        if (getSessionFile() != null ? !getSessionFile().equals(that.getSessionFile()) : that.getSessionFile() != null)
            return false;
        if (getSessionDescription() != null ? !getSessionDescription().equals(that.getSessionDescription()) : that.getSessionDescription() != null)
            return false;
        if (getSessionLabel() != null ? !getSessionLabel().equals(that.getSessionLabel()) : that.getSessionLabel() != null)
            return false;
        if (getJobFunction() != null ? !getJobFunction().equals(that.getJobFunction()) : that.getJobFunction() != null)
            return false;
        if (getIndustry() != null ? !getIndustry().equals(that.getIndustry()) : that.getIndustry() != null)
            return false;
        if (getInstanceCode() != null ? !getInstanceCode().equals(that.getInstanceCode()) : that.getInstanceCode() != null)
            return false;
        if (getInstanceEndDate() != null ? !getInstanceEndDate().equals(that.getInstanceEndDate()) : that.getInstanceEndDate() != null)
            return false;
        if (getLocationName() != null ? !getLocationName().equals(that.getLocationName()) : that.getLocationName() != null)
            return false;
        if (getSessionNotes() != null ? !getSessionNotes().equals(that.getSessionNotes()) : that.getSessionNotes() != null)
            return false;
        if (getOverrideCapacityValue() != null ? !getOverrideCapacityValue().equals(that.getOverrideCapacityValue()) : that.getOverrideCapacityValue() != null)
            return false;
        if (getNoOfInstances() != null ? !getNoOfInstances().equals(that.getNoOfInstances()) : that.getNoOfInstances() != null)
            return false;
        return getTotalDuration() != null ? getTotalDuration().equals(that.getTotalDuration()) : that.getTotalDuration() == null;
    }

    @Override
    public int hashCode() {
        int result = getInstanceStartTime() != null ? getInstanceStartTime().hashCode() : 0;
        result = 31 * result + (isOverrideCapacity() ? 1 : 0);
        result = 31 * result + (getCapacity() != null ? getCapacity().hashCode() : 0);
        result = 31 * result + (getInstanceStartDate() != null ? getInstanceStartDate().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getWaitListLimit() != null ? getWaitListLimit().hashCode() : 0);
        result = 31 * result + (getInstanceEndTime() != null ? getInstanceEndTime().hashCode() : 0);
        result = 31 * result + (getInstanceSpeakers() != null ? getInstanceSpeakers().hashCode() : 0);
        result = 31 * result + (getSessionName() != null ? getSessionName().hashCode() : 0);
        result = 31 * result + (getSessionType() != null ? getSessionType().hashCode() : 0);
        result = 31 * result + (getSessionCode() != null ? getSessionCode().hashCode() : 0);
        result = 31 * result + (getSessionTrack() != null ? getSessionTrack().hashCode() : 0);
        result = 31 * result + (getTags() != null ? getTags().hashCode() : 0);
        result = 31 * result + (getSessionLevel() != null ? getSessionLevel().hashCode() : 0);
        result = 31 * result + (getPoints() != null ? getPoints().hashCode() : 0);
        result = 31 * result + (getDurationHrs() != null ? getDurationHrs().hashCode() : 0);
        result = 31 * result + (getDurationMins() != null ? getDurationMins().hashCode() : 0);
        result = 31 * result + (getCeuCredits() != null ? getCeuCredits().hashCode() : 0);
        result = 31 * result + (getInstances() != null ? getInstances().hashCode() : 0);
        result = 31 * result + (getSpeakers() != null ? getSpeakers().hashCode() : 0);
        result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
        result = 31 * result + (getAbstractDescription() != null ? getAbstractDescription().hashCode() : 0);
        result = 31 * result + (getAbstractFile() != null ? getAbstractFile().hashCode() : 0);
        result = 31 * result + (getSessionFile() != null ? getSessionFile().hashCode() : 0);
        result = 31 * result + (getSessionDescription() != null ? getSessionDescription().hashCode() : 0);
        result = 31 * result + (getSessionLabel() != null ? getSessionLabel().hashCode() : 0);
        result = 31 * result + (getJobFunction() != null ? getJobFunction().hashCode() : 0);
        result = 31 * result + (getIndustry() != null ? getIndustry().hashCode() : 0);
        result = 31 * result + (getInstanceCode() != null ? getInstanceCode().hashCode() : 0);
        result = 31 * result + (getInstanceEndDate() != null ? getInstanceEndDate().hashCode() : 0);
        result = 31 * result + (getLocationName() != null ? getLocationName().hashCode() : 0);
        result = 31 * result + (getSessionNotes() != null ? getSessionNotes().hashCode() : 0);
        result = 31 * result + (getOverrideCapacityValue() != null ? getOverrideCapacityValue().hashCode() : 0);
        result = 31 * result + (getNoOfInstances() != null ? getNoOfInstances().hashCode() : 0);
        result = 31 * result + (getTotalDuration() != null ? getTotalDuration().hashCode() : 0);
        return result;
    }


}
