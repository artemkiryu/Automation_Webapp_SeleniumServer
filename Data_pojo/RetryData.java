package pojo;

import java.util.Objects;

public class RetryData {


    private String regStatus;
    private String regCustomTags;


    public RetryData(String regStatus, String regCustomTags) {

        this.regStatus = regStatus;
        this.regCustomTags = regCustomTags;

    }


    public String getRegStatus() {
        return regStatus;
    }

    public String getRegCustomTags() {
        return regCustomTags;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetryData that = (RetryData) o;
        return Objects.equals(regStatus, that.regStatus) &&
                Objects.equals(regCustomTags, that.regCustomTags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(regStatus, regCustomTags);
    }

    @Override
    public String toString() {
        return "AddFlowData{" +
                " regStatus='" + regStatus + '\'' +
                ", regCustomTags='" + regCustomTags + '\'' +


                '}';
    }


}
