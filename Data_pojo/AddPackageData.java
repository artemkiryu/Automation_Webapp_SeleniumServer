package pojo;

/**
 * Created by infoobjects on 9/19/2017.
 */
public class AddPackageData {
    private String packageName;
    private String packageCode;
    private String packageMultiplier;

    public AddPackageData(String packageName, String packageCode, String packageMultiplier) {
        this.packageName = packageName;
        this.packageCode = packageCode;
        this.packageMultiplier = packageMultiplier;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public String getPackageMultiplier() {
        return packageMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddPackageData)) return false;

        AddPackageData that = (AddPackageData) o;

        if (packageName != null ? !packageName.equals(that.packageName) : that.packageName != null) return false;
        if (packageCode != null ? !packageCode.equals(that.packageCode) : that.packageCode != null) return false;
        return !(packageMultiplier != null ? !packageMultiplier.equals(that.packageMultiplier) : that.packageMultiplier != null);

    }

    @Override
    public int hashCode() {
        int result = packageName != null ? packageName.hashCode() : 0;
        result = 31 * result + (packageCode != null ? packageCode.hashCode() : 0);
        result = 31 * result + (packageMultiplier != null ? packageMultiplier.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddPackageData{" +
                "packageName='" + packageName + '\'' +
                ", packageCode='" + packageCode + '\'' +
                ", packageMultiplier='" + packageMultiplier + '\'' +
                '}';
    }
}
