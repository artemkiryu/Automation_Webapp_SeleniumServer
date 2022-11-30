package pojo;

/**
 * Created by infoobjects on 8/23/2017.
 */
public class HotelData {

    private String hotelCode;
    private String roomTypeCode;
    private String startDate;
    private String endDate;
    private String rate;
    private String inventory;
    private String contracted;
    private String hotelCountry;
    private String hotelState;
    private String occupancy;
    private String webURL;
    private String email;
    private String city;
    private String zipCode;
    private String province;
    private String phone;
    private String fax;
    private String tollFree;
    private String userNotes;
    private String sleepingRooms;
    private String regLabel;
    private String description;
    private String largestSpace;
    private String totalSpace;
    private String meetingRooms;

    public HotelData(String hotelCode, String roomTypeCode, String startDate, String endDate, String rate, String inventory, String contracted, String hotelCountry, String hotelState, String occupancy, String webURL, String email, String city, String zipCode, String province, String phone, String fax, String tollFree, String userNotes, String sleepingRooms, String regLabel, String description, String largestSpace, String totalSpace, String meetingRooms) {
        this.hotelCode = hotelCode;
        this.roomTypeCode = roomTypeCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.inventory = inventory;
        this.contracted = contracted;
        this.hotelCountry = hotelCountry;
        this.hotelState = hotelState;
        this.occupancy = occupancy;
        this.webURL = webURL;
        this.email = email;
        this.city = city;
        this.zipCode = zipCode;
        this.province = province;
        this.phone = phone;
        this.fax = fax;
        this.tollFree = tollFree;
        this.userNotes = userNotes;
        this.sleepingRooms = sleepingRooms;
        this.regLabel = regLabel;
        this.description = description;
        this.largestSpace = largestSpace;
        this.totalSpace = totalSpace;
        this.meetingRooms = meetingRooms;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getRate() {
        return rate;
    }

    public String getInventory() {
        return inventory;
    }

    public String getContracted() {
        return contracted;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public String getHotelState() {
        return hotelState;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public String getWebURL() {
        return webURL;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getProvince() {
        return province;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getTollFree() {
        return tollFree;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public String getSleepingRooms() {
        return sleepingRooms;
    }

    public String getRegLabel() {
        return regLabel;
    }

    public String getDescription() {
        return description;
    }

    public String getLargestSpace() {
        return largestSpace;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public String getMeetingRooms() {
        return meetingRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelData)) return false;

        HotelData hotelData = (HotelData) o;

        if (hotelCode != null ? !hotelCode.equals(hotelData.hotelCode) : hotelData.hotelCode != null) return false;
        if (roomTypeCode != null ? !roomTypeCode.equals(hotelData.roomTypeCode) : hotelData.roomTypeCode != null)
            return false;
        if (startDate != null ? !startDate.equals(hotelData.startDate) : hotelData.startDate != null) return false;
        if (endDate != null ? !endDate.equals(hotelData.endDate) : hotelData.endDate != null) return false;
        if (rate != null ? !rate.equals(hotelData.rate) : hotelData.rate != null) return false;
        if (inventory != null ? !inventory.equals(hotelData.inventory) : hotelData.inventory != null) return false;
        if (contracted != null ? !contracted.equals(hotelData.contracted) : hotelData.contracted != null) return false;
        if (hotelCountry != null ? !hotelCountry.equals(hotelData.hotelCountry) : hotelData.hotelCountry != null)
            return false;
        if (hotelState != null ? !hotelState.equals(hotelData.hotelState) : hotelData.hotelState != null) return false;
        if (occupancy != null ? !occupancy.equals(hotelData.occupancy) : hotelData.occupancy != null) return false;
        if (webURL != null ? !webURL.equals(hotelData.webURL) : hotelData.webURL != null) return false;
        if (email != null ? !email.equals(hotelData.email) : hotelData.email != null) return false;
        if (city != null ? !city.equals(hotelData.city) : hotelData.city != null) return false;
        if (zipCode != null ? !zipCode.equals(hotelData.zipCode) : hotelData.zipCode != null) return false;
        if (province != null ? !province.equals(hotelData.province) : hotelData.province != null) return false;
        if (phone != null ? !phone.equals(hotelData.phone) : hotelData.phone != null) return false;
        if (fax != null ? !fax.equals(hotelData.fax) : hotelData.fax != null) return false;
        if (tollFree != null ? !tollFree.equals(hotelData.tollFree) : hotelData.tollFree != null) return false;
        if (userNotes != null ? !userNotes.equals(hotelData.userNotes) : hotelData.userNotes != null) return false;
        if (sleepingRooms != null ? !sleepingRooms.equals(hotelData.sleepingRooms) : hotelData.sleepingRooms != null)
            return false;
        if (regLabel != null ? !regLabel.equals(hotelData.regLabel) : hotelData.regLabel != null) return false;
        if (description != null ? !description.equals(hotelData.description) : hotelData.description != null)
            return false;
        if (largestSpace != null ? !largestSpace.equals(hotelData.largestSpace) : hotelData.largestSpace != null)
            return false;
        if (totalSpace != null ? !totalSpace.equals(hotelData.totalSpace) : hotelData.totalSpace != null) return false;
        return !(meetingRooms != null ? !meetingRooms.equals(hotelData.meetingRooms) : hotelData.meetingRooms != null);

    }

    @Override
    public int hashCode() {
        int result = hotelCode != null ? hotelCode.hashCode() : 0;
        result = 31 * result + (roomTypeCode != null ? roomTypeCode.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        result = 31 * result + (contracted != null ? contracted.hashCode() : 0);
        result = 31 * result + (hotelCountry != null ? hotelCountry.hashCode() : 0);
        result = 31 * result + (hotelState != null ? hotelState.hashCode() : 0);
        result = 31 * result + (occupancy != null ? occupancy.hashCode() : 0);
        result = 31 * result + (webURL != null ? webURL.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (tollFree != null ? tollFree.hashCode() : 0);
        result = 31 * result + (userNotes != null ? userNotes.hashCode() : 0);
        result = 31 * result + (sleepingRooms != null ? sleepingRooms.hashCode() : 0);
        result = 31 * result + (regLabel != null ? regLabel.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (largestSpace != null ? largestSpace.hashCode() : 0);
        result = 31 * result + (totalSpace != null ? totalSpace.hashCode() : 0);
        result = 31 * result + (meetingRooms != null ? meetingRooms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HotelData{" +
                "hotelCode='" + hotelCode + '\'' +
                ", roomTypeCode='" + roomTypeCode + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rate='" + rate + '\'' +
                ", inventory='" + inventory + '\'' +
                ", contracted='" + contracted + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", hotelState='" + hotelState + '\'' +
                ", occupancy='" + occupancy + '\'' +
                ", webURL='" + webURL + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", province='" + province + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", tollFree='" + tollFree + '\'' +
                ", userNotes='" + userNotes + '\'' +
                ", sleepingRooms='" + sleepingRooms + '\'' +
                ", regLabel='" + regLabel + '\'' +
                ", description='" + description + '\'' +
                ", largestSpace='" + largestSpace + '\'' +
                ", totalSpace='" + totalSpace + '\'' +
                ", meetingRooms='" + meetingRooms + '\'' +
                '}';
    }
}
