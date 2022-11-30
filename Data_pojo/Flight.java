package pojo;

/**
 * Created by pkapoors on 19/05/15.
 */
public class Flight {

    private String inboundType;
    private String flightCode;
    private String description;
    private String airline;
    private String aircraft;
    private String departureDate;
    private String departureTime;
    private String departurePort;
    private String departureTerminal;
    private String departureGate;
    private String arrivalDate;
    private String arrivalTime;
    private String arrivalPort;
    private String arrivalTerminal;
    private String arrivalGate;
    private String duration;
    private String distance;

    public Flight(String inboundType, String flightCode, String description, String airline, String aircraft, String departureDate, String departureTime, String departurePort, String departureTerminal, String departureGate, String arrivalDate, String arrivalTime, String arrivalPort, String arrivalTerminal, String arrivalGate, String duration, String distance) {
        this.inboundType = inboundType;
        this.flightCode = flightCode;
        this.description = description;
        this.airline = airline;
        this.aircraft = aircraft;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departurePort = departurePort;
        this.departureTerminal = departureTerminal;
        this.departureGate = departureGate;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.arrivalPort = arrivalPort;
        this.arrivalTerminal = arrivalTerminal;
        this.arrivalGate = arrivalGate;
        this.duration = duration;
        this.distance = distance;
    }

    public String getInboundType() {
        return inboundType;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getDescription() {
        return description;
    }

    public String getAirline() {
        return airline;
    }

    public String getAircraft() {
        return aircraft;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public String getArrivalGate() {
        return arrivalGate;
    }

    public String getDuration() {
        return duration;
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (getInboundType() != null ? !getInboundType().equals(flight.getInboundType()) : flight.getInboundType() != null)
            return false;
        if (getFlightCode() != null ? !getFlightCode().equals(flight.getFlightCode()) : flight.getFlightCode() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(flight.getDescription()) : flight.getDescription() != null)
            return false;
        if (getAirline() != null ? !getAirline().equals(flight.getAirline()) : flight.getAirline() != null)
            return false;
        if (getAircraft() != null ? !getAircraft().equals(flight.getAircraft()) : flight.getAircraft() != null)
            return false;
        if (getDepartureDate() != null ? !getDepartureDate().equals(flight.getDepartureDate()) : flight.getDepartureDate() != null)
            return false;
        if (getDepartureTime() != null ? !getDepartureTime().equals(flight.getDepartureTime()) : flight.getDepartureTime() != null)
            return false;
        if (getDeparturePort() != null ? !getDeparturePort().equals(flight.getDeparturePort()) : flight.getDeparturePort() != null)
            return false;
        if (getDepartureTerminal() != null ? !getDepartureTerminal().equals(flight.getDepartureTerminal()) : flight.getDepartureTerminal() != null)
            return false;
        if (getDepartureGate() != null ? !getDepartureGate().equals(flight.getDepartureGate()) : flight.getDepartureGate() != null)
            return false;
        if (getArrivalDate() != null ? !getArrivalDate().equals(flight.getArrivalDate()) : flight.getArrivalDate() != null)
            return false;
        if (getArrivalTime() != null ? !getArrivalTime().equals(flight.getArrivalTime()) : flight.getArrivalTime() != null)
            return false;
        if (getArrivalPort() != null ? !getArrivalPort().equals(flight.getArrivalPort()) : flight.getArrivalPort() != null)
            return false;
        if (getArrivalTerminal() != null ? !getArrivalTerminal().equals(flight.getArrivalTerminal()) : flight.getArrivalTerminal() != null)
            return false;
        if (getArrivalGate() != null ? !getArrivalGate().equals(flight.getArrivalGate()) : flight.getArrivalGate() != null)
            return false;
        if (getDuration() != null ? !getDuration().equals(flight.getDuration()) : flight.getDuration() != null)
            return false;
        return !(getDistance() != null ? !getDistance().equals(flight.getDistance()) : flight.getDistance() != null);

    }

    @Override
    public int hashCode() {
        int result = getInboundType() != null ? getInboundType().hashCode() : 0;
        result = 31 * result + (getFlightCode() != null ? getFlightCode().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getAirline() != null ? getAirline().hashCode() : 0);
        result = 31 * result + (getAircraft() != null ? getAircraft().hashCode() : 0);
        result = 31 * result + (getDepartureDate() != null ? getDepartureDate().hashCode() : 0);
        result = 31 * result + (getDepartureTime() != null ? getDepartureTime().hashCode() : 0);
        result = 31 * result + (getDeparturePort() != null ? getDeparturePort().hashCode() : 0);
        result = 31 * result + (getDepartureTerminal() != null ? getDepartureTerminal().hashCode() : 0);
        result = 31 * result + (getDepartureGate() != null ? getDepartureGate().hashCode() : 0);
        result = 31 * result + (getArrivalDate() != null ? getArrivalDate().hashCode() : 0);
        result = 31 * result + (getArrivalTime() != null ? getArrivalTime().hashCode() : 0);
        result = 31 * result + (getArrivalPort() != null ? getArrivalPort().hashCode() : 0);
        result = 31 * result + (getArrivalTerminal() != null ? getArrivalTerminal().hashCode() : 0);
        result = 31 * result + (getArrivalGate() != null ? getArrivalGate().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + (getDistance() != null ? getDistance().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "inboundType='" + inboundType + '\'' +
                ", flightCode='" + flightCode + '\'' +
                ", description='" + description + '\'' +
                ", airline='" + airline + '\'' +
                ", aircraft='" + aircraft + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", departurePort='" + departurePort + '\'' +
                ", departureTerminal='" + departureTerminal + '\'' +
                ", departureGate='" + departureGate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", arrivalPort='" + arrivalPort + '\'' +
                ", arrivalTerminal='" + arrivalTerminal + '\'' +
                ", arrivalGate='" + arrivalGate + '\'' +
                ", duration='" + duration + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
