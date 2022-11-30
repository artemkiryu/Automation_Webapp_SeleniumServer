package pojo;

import java.util.Objects;

public class AddJobs {
    private String application;
    private String jobName;
    private String jobDescription;
    private String profileDeduplication;
    private String attendeeTypeCode;
    private String regStatus;
    private String regStatusOverwrite;
    private String listName;
    private String retrievalPage;
    private String startingPage;
    private String endingPage;
    private String agendaStatus;
    private String regSessionStatus;
    private String sessionStatus;
    private String campaignId;
    private String endDate;
    private String email;

    public AddJobs(String application, String jobName, String jobDescription, String profileDeduplication, String attendeeTypeCode, String regStatus, String regStatusOverwrite, String listName, String retrievalPage, String startingPage, String endingPage, String agendaStatus, String regSessionStatus, String sessionStatus, String campaignId, String endDate, String email) {
        this.application = application;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.profileDeduplication = profileDeduplication;
        this.attendeeTypeCode = attendeeTypeCode;
        this.regStatus = regStatus;
        this.regStatusOverwrite = regStatusOverwrite;
        this.listName = listName;
        this.retrievalPage = retrievalPage;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
        this.agendaStatus = agendaStatus;
        this.regSessionStatus = regSessionStatus;
        this.sessionStatus = sessionStatus;
        this.campaignId = campaignId;
        this.endDate = endDate;
        this.email = email;
    }

    public AddJobs(String application, String jobName, String jobDescription, String regStatus) {
        this.application = application;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.regStatus = regStatus;
    }

    public AddJobs(String application, String jobName, String jobDescription, String profileDeduplication, String attendeeTypeCode, String regStatus, String regStatusOverwrite, String listName, String retrievalPage, String startingPage, String endingPage, String email) {
        this.application = application;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.profileDeduplication = profileDeduplication;
        this.attendeeTypeCode = attendeeTypeCode;
        this.regStatus = regStatus;
        this.regStatusOverwrite = regStatusOverwrite;
        this.listName = listName;
        this.retrievalPage = retrievalPage;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getApplication() {
        return application;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getProfileDeduplication() {
        return profileDeduplication;
    }

    public String getAttendeeTypeCode() {
        return attendeeTypeCode;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public String getRegStatusOverwrite() {
        return regStatusOverwrite;
    }

    public String getListName() {
        return listName;
    }

    public String getRetrievalPage() {
        return retrievalPage;
    }

    public String getStartingPage() {
        return startingPage;
    }

    public String getEndingPage() {
        return endingPage;
    }

    public String getAgendaStatus() {
        return agendaStatus;
    }

    public String getRegSessionStatus() {
        return regSessionStatus;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddJobs addJobs = (AddJobs) o;
        return Objects.equals(application, addJobs.application) &&
                Objects.equals(jobName, addJobs.jobName) &&
                Objects.equals(jobDescription, addJobs.jobDescription) &&
                Objects.equals(profileDeduplication, addJobs.profileDeduplication) &&
                Objects.equals(attendeeTypeCode, addJobs.attendeeTypeCode) &&
                Objects.equals(regStatus, addJobs.regStatus) &&
                Objects.equals(regStatusOverwrite, addJobs.regStatusOverwrite) &&
                Objects.equals(listName, addJobs.listName) &&
                Objects.equals(retrievalPage, addJobs.retrievalPage) &&
                Objects.equals(startingPage, addJobs.startingPage) &&
                Objects.equals(endingPage, addJobs.endingPage) &&
                Objects.equals(agendaStatus, addJobs.agendaStatus) &&
                Objects.equals(regSessionStatus, addJobs.regSessionStatus) &&
                Objects.equals(sessionStatus, addJobs.sessionStatus) &&
                Objects.equals(campaignId, addJobs.campaignId) &&
                Objects.equals(endDate, addJobs.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(application, jobName, jobDescription, profileDeduplication, attendeeTypeCode, regStatus, regStatusOverwrite, listName, retrievalPage, startingPage, endingPage, agendaStatus, regSessionStatus, sessionStatus, campaignId, endDate);
    }

    @Override
    public String toString() {
        return "AddJobs{" +
                "application='" + application + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", profileDeduplication='" + profileDeduplication + '\'' +
                ", attendeeTypeCode='" + attendeeTypeCode + '\'' +
                ", regStatus='" + regStatus + '\'' +
                ", regStatusOverwrite='" + regStatusOverwrite + '\'' +
                ", listName='" + listName + '\'' +
                ", retrievalPage='" + retrievalPage + '\'' +
                ", startingPage='" + startingPage + '\'' +
                ", endingPage='" + endingPage + '\'' +
                ", agendaStatus='" + agendaStatus + '\'' +
                ", regSessionStatus='" + regSessionStatus + '\'' +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
