package pojo;

/**
 * Created by bludshot on 17/6/15.
 */
public class FlightPackage {
    private String packageName;

    public FlightPackage(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightPackage that = (FlightPackage) o;

        return !(packageName != null ? !packageName.equals(that.packageName) : that.packageName != null);

    }

    @Override
    public int hashCode() {
        return packageName != null ? packageName.hashCode() : 0;
    }
}
