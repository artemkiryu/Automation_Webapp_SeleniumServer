package pojo;

public class AddLocationData {
    private String locationName;
    private String locationType;
    private String capacity;
    private String venue;

    public AddLocationData(String locationName, String locationType, String capacity, String venue) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.capacity = capacity;
        this.venue = venue;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddLocationData)) return false;

        AddLocationData that = (AddLocationData) o;

        if (!getLocationName().equals(that.getLocationName())) return false;
        if (!getLocationType().equals(that.getLocationType())) return false;
        if (!getCapacity().equals(that.getCapacity())) return false;
        return getVenue().equals(that.getVenue());
    }

    @Override
    public int hashCode() {
        int result = getLocationName().hashCode();
        result = 31 * result + getLocationType().hashCode();
        result = 31 * result + getCapacity().hashCode();
        result = 31 * result + getVenue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddLocationData{" +
                "locationName='" + locationName + '\'' +
                ", locationType='" + locationType + '\'' +
                ", capacity='" + capacity + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }

}
