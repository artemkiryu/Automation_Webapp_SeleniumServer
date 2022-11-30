package pojo;

/**
 * Created by infoobjects on 9/6/2017.
 */
public class MobileSettingsData {
    private String name;
    private String dateDisplayFormat;
    private String timeDisplayFormat;
    private String homeScreenLabel;
    private String loginTimeOut;
    private String loginTimeOutUnit;
    private String webUrl;

    public MobileSettingsData(String name, String dateDisplayFormat, String timeDisplayFormat, String homeScreenLabel, String loginTimeOut, String loginTimeOutUnit, String webUrl) {
        this.name = name;
        this.dateDisplayFormat = dateDisplayFormat;
        this.timeDisplayFormat = timeDisplayFormat;
        this.homeScreenLabel = homeScreenLabel;
        this.loginTimeOut = loginTimeOut;
        this.loginTimeOutUnit = loginTimeOutUnit;
        this.webUrl = webUrl;
    }

    public String getName() {
        return name;
    }

    public String getDateDisplayFormat() {
        return dateDisplayFormat;
    }

    public String getTimeDisplayFormat() {
        return timeDisplayFormat;
    }

    public String getHomeScreenLabel() {
        return homeScreenLabel;
    }

    public String getLoginTimeOut() {
        return loginTimeOut;
    }

    public String getLoginTimeOutUnit() {
        return loginTimeOutUnit;
    }

    public String getWebUrl() {
        return webUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileSettingsData)) return false;

        MobileSettingsData that = (MobileSettingsData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateDisplayFormat != null ? !dateDisplayFormat.equals(that.dateDisplayFormat) : that.dateDisplayFormat != null)
            return false;
        if (timeDisplayFormat != null ? !timeDisplayFormat.equals(that.timeDisplayFormat) : that.timeDisplayFormat != null)
            return false;
        if (homeScreenLabel != null ? !homeScreenLabel.equals(that.homeScreenLabel) : that.homeScreenLabel != null)
            return false;
        if (loginTimeOut != null ? !loginTimeOut.equals(that.loginTimeOut) : that.loginTimeOut != null) return false;
        if (loginTimeOutUnit != null ? !loginTimeOutUnit.equals(that.loginTimeOutUnit) : that.loginTimeOutUnit != null)
            return false;
        return !(webUrl != null ? !webUrl.equals(that.webUrl) : that.webUrl != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dateDisplayFormat != null ? dateDisplayFormat.hashCode() : 0);
        result = 31 * result + (timeDisplayFormat != null ? timeDisplayFormat.hashCode() : 0);
        result = 31 * result + (homeScreenLabel != null ? homeScreenLabel.hashCode() : 0);
        result = 31 * result + (loginTimeOut != null ? loginTimeOut.hashCode() : 0);
        result = 31 * result + (loginTimeOutUnit != null ? loginTimeOutUnit.hashCode() : 0);
        result = 31 * result + (webUrl != null ? webUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MobileSettingsData{" +
                "name='" + name + '\'' +
                ", dateDisplayFormat='" + dateDisplayFormat + '\'' +
                ", timeDisplayFormat='" + timeDisplayFormat + '\'' +
                ", homeScreenLabel='" + homeScreenLabel + '\'' +
                ", loginTimeOut='" + loginTimeOut + '\'' +
                ", loginTimeOutUnit='" + loginTimeOutUnit + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
