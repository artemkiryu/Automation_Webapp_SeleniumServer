package pojo;

/**
 * Created by infoobjects on 8/29/2017.
 */
public class RegistrationAgendaData {
    private String agendaItem;
    private String quantity;
    private String status;

    public RegistrationAgendaData(String agendaItem, String quantity, String status) {

        this.agendaItem = agendaItem;
        this.quantity = quantity;
        this.status = status;
    }



    public String getAgendaItem() {
        return agendaItem;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationAgendaData)) return false;

        RegistrationAgendaData that = (RegistrationAgendaData) o;

        if (agendaItem != null ? !agendaItem.equals(that.agendaItem) : that.agendaItem != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        return !(status != null ? !status.equals(that.status) : that.status != null);

    }

    @Override
    public int hashCode() {
        int result = agendaItem != null ? agendaItem.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationAgendaData{" +
                "agendaItem='" + agendaItem + '\'' +
                ", quantity='" + quantity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
