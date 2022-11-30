package pojo;

import java.util.Objects;

public class AddConnectionData {
    private String connectionCategory;
    private String targetName;
    private String connectionName;
    private String serviceURL;
    private String authenticationType;
    private String clientId;
    private String clientSecret;
    private String grantType;
    private String authorizationUrl;
    private String refreshTokenUrl;
    private String resourceUrl;
    private String accessTokenUrl;
    private String scope;
    private String testConnectionUrl;
    private String username;
    private String password;
    private String url;
    private String contentType;
    private String requestMethod;
    private String apiTokenKey;
    private String appType;

    public AddConnectionData(String connectionCategory, String targetName, String connectionName, String serviceURL, String authenticationType, String clientId, String clientSecret, String grantType, String authorizationUrl, String refreshTokenUrl, String resourceUrl, String accessTokenUrl, String scope, String testConnectionUrl, String username, String password, String url, String contentType, String requestMethod, String apiTokenKey, String appType) {
        this.connectionCategory = connectionCategory;
        this.targetName = targetName;
        this.connectionName = connectionName;
        this.serviceURL = serviceURL;
        this.authenticationType = authenticationType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.authorizationUrl = authorizationUrl;
        this.refreshTokenUrl = refreshTokenUrl;
        this.resourceUrl = resourceUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.scope = scope;
        this.testConnectionUrl = testConnectionUrl;
        this.username = username;
        this.password = password;
        this.url = url;
        this.contentType = contentType;
        this.requestMethod = requestMethod;
        this.apiTokenKey = apiTokenKey;
        this.appType = appType;
    }

    public String getAppType() {
        return appType;
    }

    public String getConnectionCategory() {
        return connectionCategory;
    }

    public String getTargetName() {
        return targetName;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public String getScope() {
        return scope;
    }

    public String getTestConnectionUrl() {
        return testConnectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getContentType() {
        return contentType;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getApiTokenKey() {
        return apiTokenKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddConnectionData that = (AddConnectionData) o;
        return Objects.equals(connectionCategory, that.connectionCategory) &&
                Objects.equals(targetName, that.targetName) &&
                Objects.equals(connectionName, that.connectionName) &&
                Objects.equals(serviceURL, that.serviceURL) &&
                Objects.equals(authenticationType, that.authenticationType) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientSecret, that.clientSecret) &&
                Objects.equals(grantType, that.grantType) &&
                Objects.equals(authorizationUrl, that.authorizationUrl) &&
                Objects.equals(refreshTokenUrl, that.refreshTokenUrl) &&
                Objects.equals(resourceUrl, that.resourceUrl) &&
                Objects.equals(accessTokenUrl, that.accessTokenUrl) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(testConnectionUrl, that.testConnectionUrl) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(url, that.url) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(requestMethod, that.requestMethod) &&
                Objects.equals(apiTokenKey, that.apiTokenKey) &&
                Objects.equals(appType, that.appType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionCategory, targetName, connectionName, serviceURL, authenticationType, clientId, clientSecret, grantType, authorizationUrl, refreshTokenUrl, resourceUrl, accessTokenUrl, scope, testConnectionUrl, username, password, url, contentType, requestMethod, apiTokenKey, appType);
    }
}
