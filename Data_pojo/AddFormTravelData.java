package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormTravelData {

    private String travelQuestionName;

    public AddFormTravelData(String travelQuestionName) {
        this.travelQuestionName = travelQuestionName;
    }

    public String getTravelQuestionName() {
        return travelQuestionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddFormTravelData that = (AddFormTravelData) o;

        return travelQuestionName != null ? travelQuestionName.equals(that.travelQuestionName) : that.travelQuestionName == null;
    }

    @Override
    public int hashCode() {
        return travelQuestionName != null ? travelQuestionName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AddFormTravelData{" +
                "travelQuestionName='" + travelQuestionName + '\'' +
                '}';
    }
}
