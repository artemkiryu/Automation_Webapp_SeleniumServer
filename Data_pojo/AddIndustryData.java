package pojo;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class AddIndustryData {

    private String industryName;

    public AddIndustryData(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustryName() {
        return industryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddIndustryData)) return false;

        AddIndustryData that = (AddIndustryData) o;

        return getIndustryName().equals(that.getIndustryName());
    }

    @Override
    public int hashCode() {
        return getIndustryName().hashCode();
    }

    @Override
    public String toString() {
        return "AddIndustryData{" +
                "industryName='" + industryName + '\'' +
                '}';
    }

}
