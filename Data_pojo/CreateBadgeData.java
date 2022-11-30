package pojo;

/**
 * Created by infoobjects on 5/12/2015.
 */
public class CreateBadgeData {
    private String badgeName;
    private String selectField;
    private String fieldOptions;
    private String template;
    private String fontType;
    private String fontSize;
    private String logo;
    private String pic;

    public CreateBadgeData(String badgeName, String selectField, String fieldOptions, String template, String fontType, String fontSize, String logo, String pic) {
        this.badgeName = badgeName;
        this.selectField = selectField;
        this.fieldOptions = fieldOptions;
        this.template = template;
        this.fontType = fontType;
        this.fontSize = fontSize;
        this.logo = logo;
        this.pic = pic;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getSelectField() {
        return selectField;
    }

    public String getFieldOptions() {
        return fieldOptions;
    }

    public String getTemplate() {
        return template;
    }

    public String getFontType() {
        return fontType;
    }

    public String getFontSize() {
        return fontSize;
    }

    public String getLogo() {
        return logo;
    }

    public String getPic() {
        return pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateBadgeData that = (CreateBadgeData) o;

        if (badgeName != null ? !badgeName.equals(that.badgeName) : that.badgeName != null) return false;
        if (selectField != null ? !selectField.equals(that.selectField) : that.selectField != null) return false;
        if (fieldOptions != null ? !fieldOptions.equals(that.fieldOptions) : that.fieldOptions != null) return false;
        if (template != null ? !template.equals(that.template) : that.template != null) return false;
        if (fontType != null ? !fontType.equals(that.fontType) : that.fontType != null) return false;
        if (fontSize != null ? !fontSize.equals(that.fontSize) : that.fontSize != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        return pic != null ? pic.equals(that.pic) : that.pic == null;
    }

    @Override
    public int hashCode() {
        int result = badgeName != null ? badgeName.hashCode() : 0;
        result = 31 * result + (selectField != null ? selectField.hashCode() : 0);
        result = 31 * result + (fieldOptions != null ? fieldOptions.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (fontType != null ? fontType.hashCode() : 0);
        result = 31 * result + (fontSize != null ? fontSize.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateBadgeData{" +
                "badgeName='" + badgeName + '\'' +
                ", selectField='" + selectField + '\'' +
                ", fieldOptions='" + fieldOptions + '\'' +
                ", template='" + template + '\'' +
                ", fontType='" + fontType + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", logo='" + logo + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}