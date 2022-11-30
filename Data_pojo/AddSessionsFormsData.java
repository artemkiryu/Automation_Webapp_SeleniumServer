package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddSessionsFormsData {
    private String sessionSectionName;
    private String sessionSectionType;
    private String sessionSectionGroupBy;
    private String sessionSectionGroupByStyle;
    private String sessionTemplate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddSessionsFormsData that = (AddSessionsFormsData) o;

        if (sessionSectionName != null ? !sessionSectionName.equals(that.sessionSectionName) : that.sessionSectionName != null)
            return false;
        if (sessionSectionType != null ? !sessionSectionType.equals(that.sessionSectionType) : that.sessionSectionType != null)
            return false;
        if (sessionSectionGroupBy != null ? !sessionSectionGroupBy.equals(that.sessionSectionGroupBy) : that.sessionSectionGroupBy != null)
            return false;
        if (sessionSectionGroupByStyle != null ? !sessionSectionGroupByStyle.equals(that.sessionSectionGroupByStyle) : that.sessionSectionGroupByStyle != null)
            return false;
        return sessionTemplate != null ? sessionTemplate.equals(that.sessionTemplate) : that.sessionTemplate == null;
    }

    @Override
    public int hashCode() {
        int result = sessionSectionName != null ? sessionSectionName.hashCode() : 0;
        result = 31 * result + (sessionSectionType != null ? sessionSectionType.hashCode() : 0);
        result = 31 * result + (sessionSectionGroupBy != null ? sessionSectionGroupBy.hashCode() : 0);
        result = 31 * result + (sessionSectionGroupByStyle != null ? sessionSectionGroupByStyle.hashCode() : 0);
        result = 31 * result + (sessionTemplate != null ? sessionTemplate.hashCode() : 0);
        return result;
    }

    public AddSessionsFormsData(String sessionSectionName, String sessionSectionType, String sessionSectionGroupBy, String sessionSectionGroupByStyle, String sessionTemplate) {
        this.sessionSectionName = sessionSectionName;
        this.sessionSectionType = sessionSectionType;
        this.sessionSectionGroupBy = sessionSectionGroupBy;
        this.sessionSectionGroupByStyle = sessionSectionGroupByStyle;
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public String toString() {
        return "AddSessionsFormsData{" +
                "sessionSectionName='" + sessionSectionName + '\'' +
                ", sessionSectionType='" + sessionSectionType + '\'' +
                ", sessionSectionGroupBy='" + sessionSectionGroupBy + '\'' +
                ", sessionSectionGroupByStyle='" + sessionSectionGroupByStyle + '\'' +
                ", sessionTemplate='" + sessionTemplate + '\'' +
                '}';
    }


    public String getSessionSectionName() {
        return sessionSectionName;
    }

    public String getSessionSectionType() {
        return sessionSectionType;
    }

    public String getSessionSectionGroupBy() {
        return sessionSectionGroupBy;
    }

    public String getSessionSectionGroupByStyle() {
        return sessionSectionGroupByStyle;
    }

    public String getSessionTemplate() {
        return sessionTemplate;
    }

}
