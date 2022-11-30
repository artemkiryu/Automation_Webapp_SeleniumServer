package pojo;

/**
 * Created by infoobjects on 6/5/2017.
 */
public class IntegrationLinks {
    private String name;
    private String label;

    public IntegrationLinks(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegrationLinks that = (IntegrationLinks) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return label != null ? label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IntegrationLinks{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
