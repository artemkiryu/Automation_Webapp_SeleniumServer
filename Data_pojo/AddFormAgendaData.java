package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormAgendaData {

    private String agendaSectionName;

    public AddFormAgendaData(String agendaSectionName) {
        this.agendaSectionName = agendaSectionName;
    }

    public String getAgendaSectionName() {
        return agendaSectionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddFormAgendaData that = (AddFormAgendaData) o;

        return agendaSectionName != null ? agendaSectionName.equals(that.agendaSectionName) : that.agendaSectionName == null;
    }

    @Override
    public int hashCode() {
        return agendaSectionName != null ? agendaSectionName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AddFormAgendaData{" +
                "agendaSectionName='" + agendaSectionName + '\'' +
                '}';
    }
}
