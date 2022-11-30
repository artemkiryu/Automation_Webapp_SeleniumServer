package pojo;

/**
 * Created by Aditi on 14-05-2015.
 */
public class ImportTravel {

    private Flight flight;
    private String fileName;
    private FlightInventory flightInventory;
    private String subject;

    public ImportTravel(Flight flight, String fileName, FlightInventory flightInventory, String subject) {
        this.flight = flight;
        this.fileName = fileName;
        this.flightInventory = flightInventory;
        this.subject = subject;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getFileName() {
        return fileName;
    }

    public FlightInventory getFlightInventory() {
        return flightInventory;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImportTravel)) return false;

        ImportTravel that = (ImportTravel) o;

        if (getFlight() != null ? !getFlight().equals(that.getFlight()) : that.getFlight() != null) return false;
        if (getFileName() != null ? !getFileName().equals(that.getFileName()) : that.getFileName() != null)
            return false;
        if (getFlightInventory() != null ? !getFlightInventory().equals(that.getFlightInventory()) : that.getFlightInventory() != null)
            return false;
        return !(getSubject() != null ? !getSubject().equals(that.getSubject()) : that.getSubject() != null);

    }

    @Override
    public int hashCode() {
        int result = getFlight() != null ? getFlight().hashCode() : 0;
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        result = 31 * result + (getFlightInventory() != null ? getFlightInventory().hashCode() : 0);
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImportTravel{" +
                "flight=" + flight +
                ", fileName='" + fileName + '\'' +
                ", flightInventory=" + flightInventory +
                ", subject='" + subject + '\'' +
                '}';
    }
}