package pojo;

import java.util.Objects;

public class SessionProposalInfo {
    private String sessionName;
    private String sessionType;
    private String track;
    private String tags;
    private String sessionLevel;
    private String abstractFile;
    private String abstractDesc;
    private String sessionDesc;
    private String notes;
    private String jobFunctions;
    private String industries;
    private String sessionLabel;

    public SessionProposalInfo(String sessionName, String sessionType, String track, String tags, String sessionLevel, String abstractFile, String abstractDesc, String sessionDesc, String notes) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.track = track;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.abstractFile = abstractFile;
        this.abstractDesc = abstractDesc;
        this.sessionDesc = sessionDesc;
        this.notes = notes;
    }

    public SessionProposalInfo(String sessionName, String sessionType, String track, String tags, String sessionLevel, String abstractFile, String abstractDesc, String sessionDesc, String notes, String jobFunctions, String industries, String sessionLabel) {
        this.sessionName = sessionName;
        this.sessionType = sessionType;
        this.track = track;
        this.tags = tags;
        this.sessionLevel = sessionLevel;
        this.abstractFile = abstractFile;
        this.abstractDesc = abstractDesc;
        this.sessionDesc = sessionDesc;
        this.notes = notes;
        this.jobFunctions = jobFunctions;
        this.industries = industries;
        this.sessionLabel = sessionLabel;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionType() {
        return sessionType;
    }

    public String getTrack() {
        return track;
    }

    public String getTags() {
        return tags;
    }

    public String getSessionLevel() {
        return sessionLevel;
    }

    public String getAbstractFile() {
        return abstractFile;
    }

    public String getAbstractDesc() {
        return abstractDesc;
    }

    public String getSessionDesc() {
        return sessionDesc;
    }

    public String getNotes() {
        return notes;
    }

    public String getJobFunctions() {
        return jobFunctions;
    }

    public String getIndustries() {
        return industries;
    }

    public String getSessionLabel() {
        return sessionLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionProposalInfo that = (SessionProposalInfo) o;
        return Objects.equals(sessionName, that.sessionName) &&
                Objects.equals(sessionType, that.sessionType) &&
                Objects.equals(track, that.track) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(sessionLevel, that.sessionLevel) &&
                Objects.equals(abstractFile, that.abstractFile) &&
                Objects.equals(abstractDesc, that.abstractDesc) &&
                Objects.equals(sessionDesc, that.sessionDesc) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(jobFunctions, that.jobFunctions) &&
                Objects.equals(industries, that.industries) &&
                Objects.equals(sessionLabel, that.sessionLabel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sessionName, sessionType, track, tags, sessionLevel, abstractFile, abstractDesc, sessionDesc, notes, jobFunctions, industries, sessionLabel);
    }

    @Override
    public String toString() {
        return "SessionProposalInfo{" +
                "sessionName='" + sessionName + '\'' +
                ", sessionType='" + sessionType + '\'' +
                ", track='" + track + '\'' +
                ", tags='" + tags + '\'' +
                ", sessionLevel='" + sessionLevel + '\'' +
                ", abstractFile='" + abstractFile + '\'' +
                ", abstractDesc='" + abstractDesc + '\'' +
                ", sessionDesc='" + sessionDesc + '\'' +
                ", notes='" + notes + '\'' +
                ", jobFunctions='" + jobFunctions + '\'' +
                ", industries='" + industries + '\'' +
                ", sessionLabel='" + sessionLabel + '\'' +
                '}';
    }
}
