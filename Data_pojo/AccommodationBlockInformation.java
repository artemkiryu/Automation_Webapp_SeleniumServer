package pojo;

/**
 * Created by infoobjects on 9/29/2017.
 */
public class AccommodationBlockInformation {

    private String hotelName;
    private String roomType;
    private String startDate;
    private String endDate;
    private String inventory;
    private String contracted;
    private String roomRate;

    public AccommodationBlockInformation(String hotelName, String roomType, String startDate, String endDate, String inventory, String contracted, String roomRate) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inventory = inventory;
        this.contracted = contracted;
        this.roomRate = roomRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInventory() {
        return inventory;
    }

    public String getContracted() {
        return contracted;
    }

    public String getRoomRate() {
        return roomRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccommodationBlockInformation)) return false;

        AccommodationBlockInformation that = (AccommodationBlockInformation) o;

        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (inventory != null ? !inventory.equals(that.inventory) : that.inventory != null) return false;
        if (contracted != null ? !contracted.equals(that.contracted) : that.contracted != null) return false;
        return !(roomRate != null ? !roomRate.equals(that.roomRate) : that.roomRate != null);

    }

    @Override
    public int hashCode() {
        int result = hotelName != null ? hotelName.hashCode() : 0;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        result = 31 * result + (contracted != null ? contracted.hashCode() : 0);
        result = 31 * result + (roomRate != null ? roomRate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccommodationBlockInformation{" +
                "hotelName='" + hotelName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", inventory='" + inventory + '\'' +
                ", contracted='" + contracted + '\'' +
                ", roomRate='" + roomRate + '\'' +
                '}';
    }
}
