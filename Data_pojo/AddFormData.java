package pojo;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class AddFormData {

    private String formName;
    private String subtitle;
    private String cc;
    private String hyperlinkLabel;
    private String googleTrackingID;
    private String regStatus;
    private String userNotes;

    public AddFormData(String formName, String subtitle, String cc, String hyperlinkLabel, String googleTrackingID, String regStatus, String userNotes) {
        this.formName = formName;
        this.subtitle = subtitle;
        this.cc = cc;
        this.hyperlinkLabel = hyperlinkLabel;
        this.googleTrackingID = googleTrackingID;
        this.regStatus = regStatus;
        this.userNotes = userNotes;
    }

    public String getFormName() {
        return formName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCc() {
        return cc;
    }

    public String getHyperlinkLabel() {
        return hyperlinkLabel;
    }

    public String getGoogleTrackingID() {
        return googleTrackingID;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public String getUserNotes() {
        return userNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddFormData)) return false;

        AddFormData that = (AddFormData) o;

        if (!getFormName().equals(that.getFormName())) return false;
        if (!getSubtitle().equals(that.getSubtitle())) return false;
        if (!getCc().equals(that.getCc())) return false;
        if (!getHyperlinkLabel().equals(that.getHyperlinkLabel())) return false;
        if (!getGoogleTrackingID().equals(that.getGoogleTrackingID())) return false;
        if (!getRegStatus().equals(that.getRegStatus())) return false;
        return getUserNotes().equals(that.getUserNotes());
    }

    @Override
    public int hashCode() {
        int result = getFormName().hashCode();
        result = 31 * result + getSubtitle().hashCode();
        result = 31 * result + getCc().hashCode();
        result = 31 * result + getHyperlinkLabel().hashCode();
        result = 31 * result + getGoogleTrackingID().hashCode();
        result = 31 * result + getRegStatus().hashCode();
        result = 31 * result + getUserNotes().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddFormData{" +
                "formName='" + formName + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", cc='" + cc + '\'' +
                ", hyperlinkLabel='" + hyperlinkLabel + '\'' +
                ", googleTrackingID='" + googleTrackingID + '\'' +
                ", regStatus='" + regStatus + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }

}
