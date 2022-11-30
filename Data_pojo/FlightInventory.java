package pojo;

/**
 * Created by pkapoors on 19/05/15.
 */
public class FlightInventory {
    private String seatBlockId;
    private String referenceNumber;
    private String inventory;
    private String totalAmount;
    private String travelTax;
    private String flightClass;
    private String travelType;
    private String actionCode;
    private String bookingStatus;
    private String note;

    public FlightInventory(String seatBlockId, String referenceNumber, String inventory, String totalAmount, String travelTax, String flightClass, String travelType, String actionCode, String bookingStatus, String note) {
        this.seatBlockId = seatBlockId;
        this.referenceNumber = referenceNumber;
        this.inventory = inventory;
        this.totalAmount = totalAmount;
        this.travelTax = travelTax;
        this.flightClass = flightClass;
        this.travelType = travelType;
        this.actionCode = actionCode;
        this.bookingStatus = bookingStatus;
        this.note = note;
    }

    public String getSeatBlockId() {
        return seatBlockId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getInventory() {
        return inventory;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public String getTravelTax() {
        return travelTax;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public String getTravelType() {
        return travelType;
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightInventory)) return false;

        FlightInventory that = (FlightInventory) o;

        if (getSeatBlockId() != null ? !getSeatBlockId().equals(that.getSeatBlockId()) : that.getSeatBlockId() != null)
            return false;
        if (getReferenceNumber() != null ? !getReferenceNumber().equals(that.getReferenceNumber()) : that.getReferenceNumber() != null)
            return false;
        if (getInventory() != null ? !getInventory().equals(that.getInventory()) : that.getInventory() != null)
            return false;
        if (getTotalAmount() != null ? !getTotalAmount().equals(that.getTotalAmount()) : that.getTotalAmount() != null)
            return false;
        if (getTravelTax() != null ? !getTravelTax().equals(that.getTravelTax()) : that.getTravelTax() != null)
            return false;
        if (getFlightClass() != null ? !getFlightClass().equals(that.getFlightClass()) : that.getFlightClass() != null)
            return false;
        if (getTravelType() != null ? !getTravelType().equals(that.getTravelType()) : that.getTravelType() != null)
            return false;
        if (getActionCode() != null ? !getActionCode().equals(that.getActionCode()) : that.getActionCode() != null)
            return false;
        if (getBookingStatus() != null ? !getBookingStatus().equals(that.getBookingStatus()) : that.getBookingStatus() != null)
            return false;
        return !(getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null);

    }

    @Override
    public int hashCode() {
        int result = getSeatBlockId() != null ? getSeatBlockId().hashCode() : 0;
        result = 31 * result + (getReferenceNumber() != null ? getReferenceNumber().hashCode() : 0);
        result = 31 * result + (getInventory() != null ? getInventory().hashCode() : 0);
        result = 31 * result + (getTotalAmount() != null ? getTotalAmount().hashCode() : 0);
        result = 31 * result + (getTravelTax() != null ? getTravelTax().hashCode() : 0);
        result = 31 * result + (getFlightClass() != null ? getFlightClass().hashCode() : 0);
        result = 31 * result + (getTravelType() != null ? getTravelType().hashCode() : 0);
        result = 31 * result + (getActionCode() != null ? getActionCode().hashCode() : 0);
        result = 31 * result + (getBookingStatus() != null ? getBookingStatus().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightInventory{" +
                "seatBlockId='" + seatBlockId + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", inventory='" + inventory + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", travelTax='" + travelTax + '\'' +
                ", flightClass='" + flightClass + '\'' +
                ", travelType='" + travelType + '\'' +
                ", actionCode='" + actionCode + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
