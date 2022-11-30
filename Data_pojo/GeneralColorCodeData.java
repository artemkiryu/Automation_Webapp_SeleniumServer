package pojo;

/**
 * Created by infoobjects on 9/6/2017.
 */
public class GeneralColorCodeData {
    private String navigationBackgroundColorCode;
    private String logoBackgroundColorCode;
    private String navigationBarColorCode;
    private String bodyBackgroundColorCode;
    private String bodyText;
    private String bannerUrl;

    public GeneralColorCodeData(String navigationBackgroundColorCode, String logoBackgroundColorCode, String navigationBarColorCode, String bodyBackgroundColorCode, String bodyText, String bannerUrl) {
        this.navigationBackgroundColorCode = navigationBackgroundColorCode;
        this.logoBackgroundColorCode = logoBackgroundColorCode;
        this.navigationBarColorCode = navigationBarColorCode;
        this.bodyBackgroundColorCode = bodyBackgroundColorCode;
        this.bodyText = bodyText;
        this.bannerUrl = bannerUrl;
    }

    public String getNavigationBackgroundColorCode() {
        return navigationBackgroundColorCode;
    }

    public String getLogoBackgroundColorCode() {
        return logoBackgroundColorCode;
    }

    public String getNavigationBarColorCode() {
        return navigationBarColorCode;
    }

    public String getBodyBackgroundColorCode() {
        return bodyBackgroundColorCode;
    }

    public String getBodyText() {
        return bodyText;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralColorCodeData)) return false;

        GeneralColorCodeData that = (GeneralColorCodeData) o;

        if (navigationBackgroundColorCode != null ? !navigationBackgroundColorCode.equals(that.navigationBackgroundColorCode) : that.navigationBackgroundColorCode != null)
            return false;
        if (logoBackgroundColorCode != null ? !logoBackgroundColorCode.equals(that.logoBackgroundColorCode) : that.logoBackgroundColorCode != null)
            return false;
        if (navigationBarColorCode != null ? !navigationBarColorCode.equals(that.navigationBarColorCode) : that.navigationBarColorCode != null)
            return false;
        if (bodyBackgroundColorCode != null ? !bodyBackgroundColorCode.equals(that.bodyBackgroundColorCode) : that.bodyBackgroundColorCode != null)
            return false;
        if (bodyText != null ? !bodyText.equals(that.bodyText) : that.bodyText != null) return false;
        return !(bannerUrl != null ? !bannerUrl.equals(that.bannerUrl) : that.bannerUrl != null);

    }

    @Override
    public int hashCode() {
        int result = navigationBackgroundColorCode != null ? navigationBackgroundColorCode.hashCode() : 0;
        result = 31 * result + (logoBackgroundColorCode != null ? logoBackgroundColorCode.hashCode() : 0);
        result = 31 * result + (navigationBarColorCode != null ? navigationBarColorCode.hashCode() : 0);
        result = 31 * result + (bodyBackgroundColorCode != null ? bodyBackgroundColorCode.hashCode() : 0);
        result = 31 * result + (bodyText != null ? bodyText.hashCode() : 0);
        result = 31 * result + (bannerUrl != null ? bannerUrl.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "GeneralColorCodeData{" +
                "navigationBackgroundColorCode='" + navigationBackgroundColorCode + '\'' +
                ", logoBackgroundColorCode='" + logoBackgroundColorCode + '\'' +
                ", navigationBarColorCode='" + navigationBarColorCode + '\'' +
                ", bodyBackgroundColorCode='" + bodyBackgroundColorCode + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }
}
