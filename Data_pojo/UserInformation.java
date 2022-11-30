package pojo;

public class UserInformation {

    private String name;
    private String loginId;
    private String phone;
    private String email;
    private String userType;
    private String account;
    private String active;
    private String eventVisibility;
    private String userAccess;
    private String newPassword;

    public UserInformation(String name, String loginId, String phone, String email, String userType, String account, String active, String eventVisibility, String userAccess, String newPassword) {
        this.name = name;
        this.loginId = loginId;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
        this.account = account;
        this.active = active;
        this.eventVisibility = eventVisibility;
        this.userAccess = userAccess;
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInformation)) return false;

        UserInformation that = (UserInformation) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getLoginId() != null ? !getLoginId().equals(that.getLoginId()) : that.getLoginId() != null) return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getUserType() != null ? !getUserType().equals(that.getUserType()) : that.getUserType() != null)
            return false;
        if (getAccount() != null ? !getAccount().equals(that.getAccount()) : that.getAccount() != null) return false;
        if (getActive() != null ? !getActive().equals(that.getActive()) : that.getActive() != null) return false;
        if (getEventVisibility() != null ? !getEventVisibility().equals(that.getEventVisibility()) : that.getEventVisibility() != null)
            return false;
        if (getUserAccess() != null ? !getUserAccess().equals(that.getUserAccess()) : that.getUserAccess() != null)
            return false;
        return !(getNewPassword() != null ? !getNewPassword().equals(that.getNewPassword()) : that.getNewPassword() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLoginId() != null ? getLoginId().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUserType() != null ? getUserType().hashCode() : 0);
        result = 31 * result + (getAccount() != null ? getAccount().hashCode() : 0);
        result = 31 * result + (getActive() != null ? getActive().hashCode() : 0);
        result = 31 * result + (getEventVisibility() != null ? getEventVisibility().hashCode() : 0);
        result = 31 * result + (getUserAccess() != null ? getUserAccess().hashCode() : 0);
        result = 31 * result + (getNewPassword() != null ? getNewPassword().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public String getAccount() {
        return account;
    }

    public String getActive() {
        return active;
    }

    public String getEventVisibility() {
        return eventVisibility;
    }

    public String getUserAccess() {
        return userAccess;
    }

    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "name='" + name + '\'' +
                ", loginId='" + loginId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", account='" + account + '\'' +
                ", active='" + active + '\'' +
                ", eventVisibility='" + eventVisibility + '\'' +
                ", userAccess='" + userAccess + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }


}
