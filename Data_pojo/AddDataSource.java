package pojo;

import java.util.Objects;

public class AddDataSource {

    private String dataSource;
    private String sourceName;
    private String sourceSystem;
    private String description;
    private String sourceType;
    private String actionCategory;
    private String incomingWebhookUrl;
    private String requestPerMinute;
    private String connectionUsed;
    private String pollApiurl;
    private String pollApiContentType;
    private String pollApiRequestMethod;
    private String paginationScheme;
    private String pageNumberField;
    private String pageSizeField;
    private String pageSize;
    private String totalRecordsField;
    private String actionType;

    public AddDataSource(String dataSource, String sourceName,String sourceSystem,String description, String sourceType, String actionCategory,String incomingWebhookUrl, String requestPerMinute, String connectionUsed,String pollApiurl,String pollApiContentType, String pollApiRequestMethod, String paginationScheme,String pageNumberField,String pageSizeField, String pageSize,String totalRecordsField,String actionType){
        this.dataSource=dataSource;
        this.sourceName=sourceName;
        this.sourceSystem=sourceSystem;
        this.description=description;
        this.sourceType=sourceType;
        this.actionCategory=actionCategory;
        this.incomingWebhookUrl=incomingWebhookUrl;
        this.requestPerMinute=requestPerMinute;
        this.connectionUsed=connectionUsed;
        this.pollApiurl=pollApiurl;
        this.pollApiContentType=pollApiContentType;
        this.pollApiRequestMethod=pollApiRequestMethod;
        this.paginationScheme=paginationScheme;
        this.pageNumberField=pageNumberField;
        this.pageSizeField=pageSizeField;
        this.pageSize=pageSize;
        this.totalRecordsField=totalRecordsField;
        this.actionType=actionType;

    }

    public String getDataSource() {
        return dataSource;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public String getDescription() {
        return description;
    }

    public String getSourceType() {
        return sourceType;
    }

    public String getActionCategory() {
        return actionCategory;
    }

    public String getIncomingWebhookUrl() {
        return incomingWebhookUrl;
    }

    public String getRequestPerMinute() {
        return requestPerMinute;
    }

    public String getConnectionUsed() {
        return connectionUsed;
    }

    public String getPollApiurl() {
        return pollApiurl;
    }

    public String getPollApiContentType() {
        return pollApiContentType;
    }

    public String getPollApiRequestMethod() {
        return pollApiRequestMethod;
    }

    public String getPaginationScheme() {
        return paginationScheme;
    }

    public String getPageNumberField() {
        return pageNumberField;
    }

    public String getPageSizeField() {
        return pageSizeField;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getTotalRecordsField() {
        return totalRecordsField;
    }

    public String getActionType() {
        return actionType;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddDataSource that = (AddDataSource) o;
        return Objects.equals(dataSource, that.dataSource) &&
                Objects.equals(sourceName, that.sourceName) &&
                Objects.equals(sourceSystem, that.sourceSystem) &&
                Objects.equals(description, that.description) &&
                Objects.equals(sourceType, that.sourceType) &&
                Objects.equals(actionCategory, that.actionCategory) &&
                Objects.equals(incomingWebhookUrl, that.incomingWebhookUrl) &&
                Objects.equals(requestPerMinute, that.requestPerMinute) &&
                Objects.equals(connectionUsed, that.connectionUsed) &&
                Objects.equals(pollApiurl, that.pollApiurl) &&
                Objects.equals(pollApiContentType, that.pollApiContentType) &&
                Objects.equals(pollApiRequestMethod, that.pollApiRequestMethod) &&
                Objects.equals(paginationScheme, that.paginationScheme) &&
                Objects.equals(pageNumberField, that.pageNumberField) &&
                Objects.equals(pageSizeField, that.pageSizeField) &&
                Objects.equals(pageSize, that.pageSize) &&
                Objects.equals(totalRecordsField, that.totalRecordsField) &&
                Objects.equals(actionType, that.actionType) ;

    }
    @Override
    public int hashCode() {
        return Objects.hash(dataSource, sourceName, sourceSystem, description, sourceType, actionCategory, incomingWebhookUrl, requestPerMinute, connectionUsed, pollApiurl, pollApiContentType, pollApiRequestMethod, paginationScheme, pageNumberField, pageSizeField, pageSize, totalRecordsField, actionType);
    }
    @Override
    public String toString() {
        return "AddDataSource{" +
                "dataSource='" + dataSource + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", description='" + description + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", actionCategory='" + actionCategory + '\'' +
                "dataSource='" + incomingWebhookUrl + '\'' +
                ", sourceName='" + requestPerMinute + '\'' +
                ", sourceSystem='" + connectionUsed + '\'' +
                ", description='" + pollApiurl + '\'' +
                ", sourceType='" + pollApiContentType + '\'' +
                ", actionCategory='" + pollApiRequestMethod + '\'' +
                "dataSource='" + paginationScheme + '\'' +
                ", sourceName='" + pageNumberField + '\'' +
                ", sourceSystem='" + pageSizeField + '\'' +
                ", description='" + pageSize + '\'' +
                ", sourceType='" + totalRecordsField + '\'' +
                ", actionCategory='" + actionType + '\'' +

                '}';
    }



}
