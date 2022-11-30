package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 11/3/2016.
 */
public class AddConfig {
    private String configName;
    private String appId;
    private String configType;
    private String idpName;
    private String btnLabel;
    private String btnColor;
    private String btnTextColor;
    private String btnImage;
    private String btnClass;
    private String entryPoints;
    private String profileLookup;

    public AddConfig(String configName, String appId, String configType, String idpName, String btnLabel, String btnColor, String btnTextColor, String btnImage, String btnClass, String entryPoints, String profileLookup) {
        this.configName = configName;
        this.appId = appId;
        this.configType = configType;
        this.idpName = idpName;
        this.btnLabel = btnLabel;
        this.btnColor = btnColor;
        this.btnTextColor = btnTextColor;
        this.btnImage = btnImage;
        this.btnClass = btnClass;
        this.entryPoints = entryPoints;
        this.profileLookup = profileLookup;
    }

    public String getConfigName() {
        return configName;
    }

    public String getAppId() {
        return appId;
    }

    public String getConfigType() {
        return configType;
    }

    public String getIdpName() {
        return idpName;
    }

    public String getBtnLabel() {
        return btnLabel;
    }

    public String getBtnColor() {
        return btnColor;
    }

    public String getBtnTextColor() {
        return btnTextColor;
    }

    public String getBtnImage() {
        return btnImage;
    }

    public String getBtnClass() {
        return btnClass;
    }

    public String getEntryPoints() {
        return entryPoints;
    }

    public String getProfileLookup() {
        return profileLookup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddConfig addConfig = (AddConfig) o;
        return Objects.equals(configName, addConfig.configName) &&
                Objects.equals(appId, addConfig.appId) &&
                Objects.equals(configType, addConfig.configType) &&
                Objects.equals(idpName, addConfig.idpName) &&
                Objects.equals(btnLabel, addConfig.btnLabel) &&
                Objects.equals(btnColor, addConfig.btnColor) &&
                Objects.equals(btnTextColor, addConfig.btnTextColor) &&
                Objects.equals(btnImage, addConfig.btnImage) &&
                Objects.equals(btnClass, addConfig.btnClass) &&
                Objects.equals(entryPoints, addConfig.entryPoints) &&
                Objects.equals(profileLookup, addConfig.profileLookup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(configName, appId, configType, idpName, btnLabel, btnColor, btnTextColor, btnImage, btnClass, entryPoints, profileLookup);
    }

    @Override
    public String toString() {
        return "AddConfig{" +
                "configName='" + configName + '\'' +
                ", appId='" + appId + '\'' +
                ", configType='" + configType + '\'' +
                ", idpName='" + idpName + '\'' +
                ", btnLabel='" + btnLabel + '\'' +
                ", btnColor='" + btnColor + '\'' +
                ", btnTextColor='" + btnTextColor + '\'' +
                ", btnImage='" + btnImage + '\'' +
                ", btnClass='" + btnClass + '\'' +
                ", entryPoints='" + entryPoints + '\'' +
                ", profileLookup='" + profileLookup + '\'' +
                '}';
    }
}
