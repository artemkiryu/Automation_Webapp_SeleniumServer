package pojo;

/**
 * Created by bludshot on 16/6/15.
 */
public class FlightPackageFormDetail {
    private String departureDate;
    private String departurePort;
    private String arrivalDate;
    private String arrivalPort;
    private String airline;
    private String flightCode;

    public FlightPackageFormDetail(String departureDate, String departurePort, String arrivalDate, String arrivalPort, String airline, String flightCode) {
        this.departureDate = departureDate;
        this.departurePort = departurePort;
        this.arrivalDate = arrivalDate;
        this.arrivalPort = arrivalPort;
        this.airline = airline;
        this.flightCode = flightCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightPackageFormDetail that = (FlightPackageFormDetail) o;

        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        if (departurePort != null ? !departurePort.equals(that.departurePort) : that.departurePort != null)
            return false;
        if (arrivalDate != null ? !arrivalDate.equals(that.arrivalDate) : that.arrivalDate != null) return false;
        if (arrivalPort != null ? !arrivalPort.equals(that.arrivalPort) : that.arrivalPort != null) return false;
        if (airline != null ? !airline.equals(that.airline) : that.airline != null) return false;
        return !(flightCode != null ? !flightCode.equals(that.flightCode) : that.flightCode != null);

    }

    @Override
    public int hashCode() {
        int result = departureDate != null ? departureDate.hashCode() : 0;
        result = 31 * result + (departurePort != null ? departurePort.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (arrivalPort != null ? arrivalPort.hashCode() : 0);
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (flightCode != null ? flightCode.hashCode() : 0);
        return result;
    }

    public String getAirline() {
        return airline;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public String getFlightCode() {
        return flightCode;
    }
}
