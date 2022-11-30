package pojo;

/**
 * Created by Aditi on 11-05-2015.
 */
public class EmailTemplates {
    private String name;
    private String appendType;
    private String subject;
    private String message;
    private String code;
    private String scheduled;
    private String dateValue;
    private String timeValue;
    private String columnFilters;
    private String operatorFilters;
    private String valueFilters;
    private String password;
    private String errorMsg;

    public EmailTemplates(String name, String appendType, String subject, String message, String code, String scheduled, String dateValue, String timeValue, String columnFilters, String operatorFilters, String valueFilters, String password, String errorMsg) {
        this.name = name;
        this.appendType = appendType;
        this.subject = subject;
        this.message = message;
        this.code = code;
        this.scheduled = scheduled;
        this.dateValue = dateValue;
        this.timeValue = timeValue;
        this.columnFilters = columnFilters;
        this.operatorFilters = operatorFilters;
        this.valueFilters = valueFilters;
        this.password = password;
        this.errorMsg = errorMsg;
    }

    public String getName() {
        return name;
    }

    public String getAppendType() {
        return appendType;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getScheduled() {
        return scheduled;
    }

    public String getDateValue() {
        return dateValue;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public String getColumnFilters() {
        return columnFilters;
    }

    public String getOperatorFilters() {
        return operatorFilters;
    }

    public String getValueFilters() {
        return valueFilters;
    }

    public String getPassword() {
        return password;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailTemplates)) return false;

        EmailTemplates that = (EmailTemplates) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getAppendType() != null ? !getAppendType().equals(that.getAppendType()) : that.getAppendType() != null)
            return false;
        if (getSubject() != null ? !getSubject().equals(that.getSubject()) : that.getSubject() != null) return false;
        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        if (getScheduled() != null ? !getScheduled().equals(that.getScheduled()) : that.getScheduled() != null)
            return false;
        if (getDateValue() != null ? !getDateValue().equals(that.getDateValue()) : that.getDateValue() != null)
            return false;
        if (getTimeValue() != null ? !getTimeValue().equals(that.getTimeValue()) : that.getTimeValue() != null)
            return false;
        if (getColumnFilters() != null ? !getColumnFilters().equals(that.getColumnFilters()) : that.getColumnFilters() != null)
            return false;
        if (getOperatorFilters() != null ? !getOperatorFilters().equals(that.getOperatorFilters()) : that.getOperatorFilters() != null)
            return false;
        if (getValueFilters() != null ? !getValueFilters().equals(that.getValueFilters()) : that.getValueFilters() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
            return false;
        return !(getErrorMsg() != null ? !getErrorMsg().equals(that.getErrorMsg()) : that.getErrorMsg() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAppendType() != null ? getAppendType().hashCode() : 0);
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getScheduled() != null ? getScheduled().hashCode() : 0);
        result = 31 * result + (getDateValue() != null ? getDateValue().hashCode() : 0);
        result = 31 * result + (getTimeValue() != null ? getTimeValue().hashCode() : 0);
        result = 31 * result + (getColumnFilters() != null ? getColumnFilters().hashCode() : 0);
        result = 31 * result + (getOperatorFilters() != null ? getOperatorFilters().hashCode() : 0);
        result = 31 * result + (getValueFilters() != null ? getValueFilters().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getErrorMsg() != null ? getErrorMsg().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmailTemplates{" +
                "name='" + name + '\'' +
                ", appendType='" + appendType + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", scheduled='" + scheduled + '\'' +
                ", dateValue='" + dateValue + '\'' +
                ", timeValue='" + timeValue + '\'' +
                ", columnFilters='" + columnFilters + '\'' +
                ", operatorFilters='" + operatorFilters + '\'' +
                ", valueFilters='" + valueFilters + '\'' +
                ", password='" + password + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}