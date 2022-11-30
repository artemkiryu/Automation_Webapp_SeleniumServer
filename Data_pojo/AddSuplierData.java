package pojo;

/**
 * Created by infoobjects on 9/20/2017.
 */
public class AddSuplierData {

    private String type;
    private String name;
    private String uniqueCode;
    private String country;
    private String state;

    public AddSuplierData(String type, String name, String uniqueCode, String country, String state) {
        this.type = type;
        this.name = name;
        this.uniqueCode = uniqueCode;
        this.country = country;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddSuplierData)) return false;

        AddSuplierData that = (AddSuplierData) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (uniqueCode != null ? !uniqueCode.equals(that.uniqueCode) : that.uniqueCode != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return !(state != null ? !state.equals(that.state) : that.state != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (uniqueCode != null ? uniqueCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddSuplierData{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
