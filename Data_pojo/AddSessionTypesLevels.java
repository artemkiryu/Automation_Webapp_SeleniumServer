package pojo;

public class AddSessionTypesLevels {


    private String typeName;
    private String levelName;
    private String colorR;
    private String colorG;
    private String colorB;

    public AddSessionTypesLevels(String typeName, String levelName, String colorR, String colorG, String colorB) {
        this.typeName = typeName;
        this.levelName = levelName;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getColorR() {
        return colorR;
    }

    public String getColorG() {
        return colorG;
    }

    public String getColorB() {
        return colorB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddSessionTypesLevels)) return false;

        AddSessionTypesLevels that = (AddSessionTypesLevels) o;

        if (getTypeName() != null ? !getTypeName().equals(that.getTypeName()) : that.getTypeName() != null)
            return false;
        if (getLevelName() != null ? !getLevelName().equals(that.getLevelName()) : that.getLevelName() != null)
            return false;
        if (getColorR() != null ? !getColorR().equals(that.getColorR()) : that.getColorR() != null) return false;
        if (getColorG() != null ? !getColorG().equals(that.getColorG()) : that.getColorG() != null) return false;
        return getColorB() != null ? getColorB().equals(that.getColorB()) : that.getColorB() == null;
    }

    @Override
    public int hashCode() {
        int result = getTypeName() != null ? getTypeName().hashCode() : 0;
        result = 31 * result + (getLevelName() != null ? getLevelName().hashCode() : 0);
        result = 31 * result + (getColorR() != null ? getColorR().hashCode() : 0);
        result = 31 * result + (getColorG() != null ? getColorG().hashCode() : 0);
        result = 31 * result + (getColorB() != null ? getColorB().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddSessionTypesLevels{" +
                "typeName='" + typeName + '\'' +
                ", levelName='" + levelName + '\'' +
                ", colorR='" + colorR + '\'' +
                ", colorG='" + colorG + '\'' +
                ", colorB='" + colorB + '\'' +
                '}';
    }


}
