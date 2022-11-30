package pojo;

/**
 * Created by pkapoors on 03/06/15.
 */
public class AdditionalInfo {
    private String additionalName;
    private String additionalEmail;
    private String additionalPhone;

    public AdditionalInfo(String additionalName, String additionalEmail, String additionalPhone) {
        this.additionalName = additionalName;
        this.additionalEmail = additionalEmail;
        this.additionalPhone = additionalPhone;
    }

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "additionalName='" + additionalName + '\'' +
                ", additionalEmail='" + additionalEmail + '\'' +
                ", additionalPhone='" + additionalPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionalInfo)) return false;

        AdditionalInfo that = (AdditionalInfo) o;

        if (getAdditionalName() != null ? !getAdditionalName().equals(that.getAdditionalName()) : that.getAdditionalName() != null)
            return false;
        if (getAdditionalEmail() != null ? !getAdditionalEmail().equals(that.getAdditionalEmail()) : that.getAdditionalEmail() != null)
            return false;
        return !(getAdditionalPhone() != null ? !getAdditionalPhone().equals(that.getAdditionalPhone()) : that.getAdditionalPhone() != null);

    }

    @Override
    public int hashCode() {
        int result = getAdditionalName() != null ? getAdditionalName().hashCode() : 0;
        result = 31 * result + (getAdditionalEmail() != null ? getAdditionalEmail().hashCode() : 0);
        result = 31 * result + (getAdditionalPhone() != null ? getAdditionalPhone().hashCode() : 0);
        return result;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public String getAdditionalEmail() {
        return additionalEmail;
    }

    public void setAdditionalEmail(String additionalEmail) {
        this.additionalEmail = additionalEmail;
    }

    public String getAdditionalPhone() {
        return additionalPhone;
    }

    public void setAdditionalPhone(String additionalPhone) {
        this.additionalPhone = additionalPhone;
    }
}
