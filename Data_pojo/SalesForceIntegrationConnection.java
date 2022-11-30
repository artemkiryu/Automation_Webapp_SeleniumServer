package pojo;

/**
 * Created by infoobjects on 11/18/2015.
 */
public class SalesForceIntegrationConnection {
    private String username;
    private String password;
    private String confirmPassword;
    private String securityToken;
    private String url;
    private boolean active;

    public SalesForceIntegrationConnection(String username, String password, String confirmPassword, String securityToken, String url, boolean active) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.securityToken = securityToken;
        this.url = url;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesForceIntegrationConnection that = (SalesForceIntegrationConnection) o;

        if (active != that.active) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (confirmPassword != null ? !confirmPassword.equals(that.confirmPassword) : that.confirmPassword != null)
            return false;
        if (securityToken != null ? !securityToken.equals(that.securityToken) : that.securityToken != null)
            return false;
        return !(url != null ? !url.equals(that.url) : that.url != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
        result = 31 * result + (securityToken != null ? securityToken.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalesForceIntegrationConnection{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", securityToken='" + securityToken + '\'' +
                ", url='" + url + '\'' +
                ", active=" + active +
                '}';
    }
}
