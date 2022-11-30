package pojo;

import java.util.Objects;

public class Metrics {


    private String regCode;
    private String timeInterval;


    public Metrics(String regCode, String timeInterval) {

        this.regCode = regCode;
        this.timeInterval = timeInterval;

    }


    public String getRegCode() {
        return regCode;
    }

    public String getTimeInterval() {
        return timeInterval;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metrics that = (Metrics) o;
        return Objects.equals(regCode, that.regCode) &&
                Objects.equals(timeInterval, that.timeInterval);
    }

    @Override
    public int hashCode() {

        return Objects.hash(regCode, timeInterval);
    }

    @Override
    public String toString() {
        return "AddFlowData{" +
                " regCode='" + regCode + '\'' +
                ", timeInterval='" + timeInterval + '\'' +


                '}';
    }


}
