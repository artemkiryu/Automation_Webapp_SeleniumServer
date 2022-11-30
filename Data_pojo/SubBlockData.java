package pojo;

/**
 * Created by infoobjects on 10/3/2017.
 */
public class SubBlockData {

    private String name;
    private String blockCode;
    private String date;
    private String allocatedValue;

    public SubBlockData(String name, String blockCode, String date, String allocatedValue) {
        this.name = name;
        this.blockCode = blockCode;
        this.date = date;
        this.allocatedValue = allocatedValue;
    }

    public String getName() {
        return name;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public String getDate() {
        return date;
    }

    public String getAllocatedValue() {
        return allocatedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubBlockData)) return false;

        SubBlockData that = (SubBlockData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (blockCode != null ? !blockCode.equals(that.blockCode) : that.blockCode != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return !(allocatedValue != null ? !allocatedValue.equals(that.allocatedValue) : that.allocatedValue != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (blockCode != null ? blockCode.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (allocatedValue != null ? allocatedValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubBlockData{" +
                "name='" + name + '\'' +
                ", blockCode='" + blockCode + '\'' +
                ", date='" + date + '\'' +
                ", allocatedValue='" + allocatedValue + '\'' +
                '}';
    }


}
