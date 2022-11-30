package pojo;

import java.util.Objects;

public class AddPlugins {
    private String pluginName;
    private String userId;
    private String password;
    private String restUrl;

    public AddPlugins(String pluginName, String userId, String password, String restUrl) {
        this.pluginName = pluginName;
        this.userId = userId;
        this.password = password;
        this.restUrl = restUrl;
    }

    public String getPluginName() {
        return pluginName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRestUrl() {
        return restUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddPlugins that = (AddPlugins) o;
        return Objects.equals(pluginName, that.pluginName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(restUrl, that.restUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pluginName, userId, password, restUrl);
    }

    @Override
    public String toString() {
        return "AddPlugins{" +
                "pluginName='" + pluginName + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", restUrl='" + restUrl + '\'' +
                '}';
    }
}
