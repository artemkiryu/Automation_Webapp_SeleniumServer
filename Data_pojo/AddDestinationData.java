package pojo;

import java.util.Objects;

public class AddDestinationData {
    private String destination;
    private String destinationName;
    private String connectionName;
    private String action;
    private String mappingName;

    public AddDestinationData(String destination, String destinationName, String connectionName, String action, String mappingName) {
        this.destination = destination;
        this.destinationName = destinationName;
        this.connectionName = connectionName;
        this.action = action;
        this.mappingName = mappingName;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public String getAction() {
        return action;
    }

    public String getMappingName() {
        return mappingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddDestinationData that = (AddDestinationData) o;
        return Objects.equals(destination, that.destination) &&
                Objects.equals(destinationName, that.destinationName) &&
                Objects.equals(connectionName, that.connectionName) &&
                Objects.equals(action, that.action) &&
                Objects.equals(mappingName, that.mappingName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(destination, destinationName, connectionName, action, mappingName);
    }

    @Override
    public String toString() {
        return "AddDestinationData{" +
                "destination='" + destination + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", connectionName='" + connectionName + '\'' +
                ", action='" + action + '\'' +
                ", mappingName='" + mappingName + '\'' +
                '}';
    }

}
