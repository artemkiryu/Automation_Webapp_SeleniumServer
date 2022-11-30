package pojo;

import java.util.Objects;

public class AddActionData {
    private String listID;
    private String campaignID;
    private String formName;
    private String formURL;
    private String assetType;
    private String activityType;
    private String url;
    private String requestMethod;
    private String contentType;

    public AddActionData(String listID, String campaignID, String formName, String formURL, String assetType, String activityType) {
        this.listID = listID;
        this.campaignID = campaignID;
        this.formName = formName;
        this.formURL = formURL;
        this.assetType = assetType;
        this.activityType = activityType;
    }

    public AddActionData(String listID, String campaignID, String formName, String formURL, String assetType, String activityType, String url, String requestMethod, String contentType) {
        this.listID = listID;
        this.campaignID = campaignID;
        this.formName = formName;
        this.formURL = formURL;
        this.assetType = assetType;
        this.activityType = activityType;
        this.url = url;
        this.requestMethod = requestMethod;
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getContentType() {
        return contentType;
    }

    public String getListID() {
        return listID;
    }

    public String getCampaignID() {
        return campaignID;
    }

    public String getFormName() {
        return formName;
    }

    public String getFormURL() {
        return formURL;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getActivityType() {
        return activityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddActionData that = (AddActionData) o;
        return Objects.equals(listID, that.listID) &&
                Objects.equals(campaignID, that.campaignID) &&
                Objects.equals(formName, that.formName) &&
                Objects.equals(formURL, that.formURL) &&
                Objects.equals(assetType, that.assetType) &&
                Objects.equals(activityType, that.activityType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(listID, campaignID, formName, formURL, assetType, activityType);
    }

    @Override
    public String toString() {
        return "AddActionData{" +
                "listID='" + listID + '\'' +
                ", campaignID='" + campaignID + '\'' +
                ", formName='" + formName + '\'' +
                ", formURL='" + formURL + '\'' +
                ", assetType='" + assetType + '\'' +
                ", activityType='" + activityType + '\'' +
                '}';
    }

}
