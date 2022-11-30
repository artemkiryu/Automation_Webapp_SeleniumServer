package pojo;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class PrivacyConfigurationData {
    private String policyType;
    private String configName;
    private String startDate;
    private String endDate;
    private String serviceAuthType;
    private String serviceUrl;
    private String clientId;
    private String clientSecret;
    private String tokenUrl;
    private String ResourceUrl;
    private String waitMessage;
    private String serviceErrorMessage;
    private String externalIdKey;
    private String triggerField;
    private String triggerValue;
    private String certainField;
    private String targetField;

    public PrivacyConfigurationData(String policyType, String configName, String startDate, String endDate, String serviceAuthType, String serviceUrl, String clientId, String clientSecret, String tokenUrl, String resourceUrl, String waitMessage, String serviceErrorMessage, String externalIdKey, String triggerField, String triggerValue, String certainField, String targetField) {
        this.policyType = policyType;
        this.configName = configName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.serviceAuthType = serviceAuthType;
        this.serviceUrl = serviceUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenUrl = tokenUrl;
        ResourceUrl = resourceUrl;
        this.waitMessage = waitMessage;
        this.serviceErrorMessage = serviceErrorMessage;
        this.externalIdKey = externalIdKey;
        this.triggerField = triggerField;
        this.triggerValue = triggerValue;
        this.certainField = certainField;
        this.targetField = targetField;
    }

    public String getPolicyType() {
        return policyType;
    }

    public String getConfigName() {
        return configName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getServiceAuthType() {
        return serviceAuthType;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getResourceUrl() {
        return ResourceUrl;
    }

    public String getWaitMessage() {
        return waitMessage;
    }

    public String getServiceErrorMessage() {
        return serviceErrorMessage;
    }

    public String getExternalIdKey() {
        return externalIdKey;
    }

    public String getTriggerField() {
        return triggerField;
    }

    public String getTriggerValue() {
        return triggerValue;
    }

    public String getCertainField() {
        return certainField;
    }

    public String getTargetField() {
        return targetField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrivacyConfigurationData)) return false;

        PrivacyConfigurationData that = (PrivacyConfigurationData) o;

        if (policyType != null ? !policyType.equals(that.policyType) : that.policyType != null) return false;
        if (configName != null ? !configName.equals(that.configName) : that.configName != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (serviceAuthType != null ? !serviceAuthType.equals(that.serviceAuthType) : that.serviceAuthType != null)
            return false;
        if (serviceUrl != null ? !serviceUrl.equals(that.serviceUrl) : that.serviceUrl != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (clientSecret != null ? !clientSecret.equals(that.clientSecret) : that.clientSecret != null) return false;
        if (tokenUrl != null ? !tokenUrl.equals(that.tokenUrl) : that.tokenUrl != null) return false;
        if (ResourceUrl != null ? !ResourceUrl.equals(that.ResourceUrl) : that.ResourceUrl != null) return false;
        if (waitMessage != null ? !waitMessage.equals(that.waitMessage) : that.waitMessage != null) return false;
        if (serviceErrorMessage != null ? !serviceErrorMessage.equals(that.serviceErrorMessage) : that.serviceErrorMessage != null)
            return false;
        if (externalIdKey != null ? !externalIdKey.equals(that.externalIdKey) : that.externalIdKey != null)
            return false;
        if (triggerField != null ? !triggerField.equals(that.triggerField) : that.triggerField != null) return false;
        if (triggerValue != null ? !triggerValue.equals(that.triggerValue) : that.triggerValue != null) return false;
        if (certainField != null ? !certainField.equals(that.certainField) : that.certainField != null) return false;
        return !(targetField != null ? !targetField.equals(that.targetField) : that.targetField != null);

    }

    @Override
    public int hashCode() {
        int result = policyType != null ? policyType.hashCode() : 0;
        result = 31 * result + (configName != null ? configName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (serviceAuthType != null ? serviceAuthType.hashCode() : 0);
        result = 31 * result + (serviceUrl != null ? serviceUrl.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (clientSecret != null ? clientSecret.hashCode() : 0);
        result = 31 * result + (tokenUrl != null ? tokenUrl.hashCode() : 0);
        result = 31 * result + (ResourceUrl != null ? ResourceUrl.hashCode() : 0);
        result = 31 * result + (waitMessage != null ? waitMessage.hashCode() : 0);
        result = 31 * result + (serviceErrorMessage != null ? serviceErrorMessage.hashCode() : 0);
        result = 31 * result + (externalIdKey != null ? externalIdKey.hashCode() : 0);
        result = 31 * result + (triggerField != null ? triggerField.hashCode() : 0);
        result = 31 * result + (triggerValue != null ? triggerValue.hashCode() : 0);
        result = 31 * result + (certainField != null ? certainField.hashCode() : 0);
        result = 31 * result + (targetField != null ? targetField.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PrivacyConfigurationData{" +
                "policyType='" + policyType + '\'' +
                ", configName='" + configName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", serviceAuthType='" + serviceAuthType + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                ", ResourceUrl='" + ResourceUrl + '\'' +
                ", waitMessage='" + waitMessage + '\'' +
                ", serviceErrorMessage='" + serviceErrorMessage + '\'' +
                ", externalIdKey='" + externalIdKey + '\'' +
                ", triggerField='" + triggerField + '\'' +
                ", triggerValue='" + triggerValue + '\'' +
                ", certainField='" + certainField + '\'' +
                ", targetField='" + targetField + '\'' +
                '}';
    }
}
