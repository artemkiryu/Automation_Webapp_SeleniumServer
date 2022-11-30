package pojo;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Objects;

public class AddDestinationDataInbound {
    private String destination;
    private String destinationName;
    private String connectionName;
    private String action;
    private String mappingName;
    private String url;
    private String contentType;
    private String requestedMethod;
    private String mappingNameCustom;
    private String mappingNameReg;
    private String mappingNameAttend;
    private String authenticationType;
    private String testConnectionUrl;
    private String username;
    private String password;
    private String apiTokenKey;
    private String resourceUrl;
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String accessTokenUrl;
    private String refreshTokenUrl;
    private String scope;
    private String authorizationUrl;
    public AddDestinationDataInbound(String destination, String destinationName, String connectionName, String action, String mappingName,String url,String contentType,String requestedMethod,String mappingNameCustom,String mappingNameReg,String mappingNameAttend,String authenticationType,String testConnectionUrl,String username,String password,String apiTokenKey,String resourceUrl,String grantType,String clientId,String clientSecret,String accessTokenUrl,String refreshTokenUrl,String scope,String authorizationUrl) {
        this.destination = destination;
        this.destinationName = destinationName;
        this.connectionName = connectionName;
        this.action = action;
        this.mappingName = mappingName;
        this.url=url;
        this.contentType=contentType;
        this.requestedMethod=requestedMethod;
        this.mappingNameCustom=mappingNameCustom;
        this.mappingNameReg=mappingNameReg;
        this.mappingNameAttend=mappingNameAttend;
        this.authenticationType=authenticationType;
        this.testConnectionUrl=testConnectionUrl;
        this.username=username;
        this.password=password;
        this.apiTokenKey=apiTokenKey;
        this.resourceUrl=resourceUrl;
        this.grantType=grantType;
        this.clientId=clientId;
        this.clientSecret=clientSecret;
        this.accessTokenUrl=accessTokenUrl;
        this.refreshTokenUrl=refreshTokenUrl;
        this.scope=scope;
        this.authorizationUrl=authorizationUrl;

    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public String getAction() {
        return action;
    }

    public String getMappingName() {
        return mappingName;
    }

    public String getUrl(){ return url;}

    public String getContentType(){ return  contentType;}

    public String getRequestedMethod(){return requestedMethod;}

    public String getMappingNameCustom(){return mappingNameCustom;}

    public String getMappingNameReg(){return mappingNameReg;}

    public String getMappingNameAttend(){return mappingNameAttend;}

    public String getAuthenticationType(){return authenticationType;}

    public String getTestConnectionUrl(){return testConnectionUrl;}

    public String getUsername(){return username;}

    public String getPassword(){return password;}

    public String getApiTokenKey(){return apiTokenKey;}

    public String getResourceUrl(){return resourceUrl;}

    public String getGrantType(){return grantType;}

    public String getClientId(){return clientId;}

    public String getClientSecret(){return clientSecret;}

    public String getAccessTokenUrl(){return accessTokenUrl;}

    public String getRefreshTokenUrl(){return refreshTokenUrl;}

    public String getScope(){return scope;}

    public String getAuthorizationUrl(){return authorizationUrl;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddDestinationDataInbound that = (AddDestinationDataInbound) o;
        return Objects.equals(destination, that.destination) &&
                Objects.equals(destinationName, that.destinationName) &&
                Objects.equals(connectionName, that.connectionName) &&
                Objects.equals(action, that.action) &&
                Objects.equals(mappingName, that.mappingName) &&
                Objects.equals(url, that.url)&&
                Objects.equals(connectionName, that.contentType)&&
                Objects.equals(requestedMethod, that.requestedMethod)&&
                Objects.equals(mappingNameCustom, that.mappingNameCustom)&&
                Objects.equals(mappingNameReg, that.mappingNameReg)&&
                Objects.equals(mappingNameAttend, that.mappingNameAttend)&&
                Objects.equals(authenticationType, that.authenticationType)&&
                Objects.equals(testConnectionUrl, that.testConnectionUrl)&&
                Objects.equals(username, that.username)&&
                Objects.equals(password, that.password)&&
                Objects.equals(apiTokenKey, that.apiTokenKey)&&
                Objects.equals(resourceUrl, that.resourceUrl)&&
                Objects.equals(grantType, that.grantType)&&
                Objects.equals(clientId, that.clientId)&&
                Objects.equals(clientSecret, that.clientSecret)&&
                Objects.equals(accessTokenUrl, that.accessTokenUrl)&&
                Objects.equals(refreshTokenUrl, that.refreshTokenUrl)&&
                Objects.equals(scope, that.scope)&&
                Objects.equals(authorizationUrl, that.authorizationUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(destination, destinationName, connectionName, action, mappingName,url,contentType,requestedMethod,mappingNameCustom,mappingNameReg,mappingNameAttend,authenticationType,testConnectionUrl,username,password,apiTokenKey,resourceUrl,grantType,clientId,clientSecret,accessTokenUrl,refreshTokenUrl,scope,authorizationUrl);
    }

    @Override
    public String toString() {
        return "AddDestinationData{" +
                "destination='" + destination + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", connectionName='" + connectionName + '\'' +
                ", action='" + action + '\'' +
                ", mappingName='" + mappingName + '\'' +
                ", url='" + url + '\'' +
                ", contentType='" + contentType + '\'' +
                ", requestedMethod='" + requestedMethod + '\'' +
                ", mappingNameCustom='" + mappingNameCustom + '\'' +
                ", mappingNameReg='" + mappingNameReg + '\'' +
                ",mappingNameAttend='" + mappingNameAttend + '\'' +
                ",authenticationType='" + authenticationType + '\'' +
                ",testConnectionUrl='" + testConnectionUrl + '\'' +
                ",username='" + username + '\'' +
                ",password='" + password + '\'' +
                ",apiTokenKey='" + apiTokenKey + '\'' +
                ",resourceUrl='" + resourceUrl + '\'' +
                ",resourceUrl='" + grantType + '\'' +
                ",clientId='" + clientId + '\'' +
                ",clientSecret='" + clientSecret + '\'' +
                ",accessTokenUrl='" + accessTokenUrl + '\'' +
                ",refreshTokenUrl='" + refreshTokenUrl + '\'' +
                ",scope='" + scope + '\'' +
                ",authorizationUrl='" + authorizationUrl + '\'' +
                '}';
    }

}
