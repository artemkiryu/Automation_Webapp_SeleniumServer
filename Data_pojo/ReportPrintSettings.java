package pojo;

/**
 * Created by infoobjects on 12/8/2015.
 */
public class ReportPrintSettings {
    private String reportWidth;
    private String fontFace;
    private String fontSize;
    private String reportAlignment;
    private String groupAlignment;
    private String columnAlignment;
    private boolean insertExtraLine;
    private boolean addBoldLine;
    private boolean insertPageBreak;
    private boolean showGridlines;

    public ReportPrintSettings(String reportWidth, String fontFace, String fontSize, String reportAlignment, String groupAlignment, String columnAlignment, boolean insertExtraLine, boolean addBoldLine, boolean insertPageBreak, boolean showGridlines) {
        this.reportWidth = reportWidth;
        this.fontFace = fontFace;
        this.fontSize = fontSize;
        this.reportAlignment = reportAlignment;
        this.groupAlignment = groupAlignment;
        this.columnAlignment = columnAlignment;
        this.insertExtraLine = insertExtraLine;
        this.addBoldLine = addBoldLine;
        this.insertPageBreak = insertPageBreak;
        this.showGridlines = showGridlines;
    }

    public String getReportWidth() {
        return reportWidth;
    }

    public String getFontFace() {
        return fontFace;
    }

    public String getFontSize() {
        return fontSize;
    }

    public String getReportAlignment() {
        return reportAlignment;
    }

    public String getGroupAlignment() {
        return groupAlignment;
    }

    public String getColumnAlignment() {
        return columnAlignment;
    }

    public boolean isInsertExtraLine() {
        return insertExtraLine;
    }

    public boolean isAddBoldLine() {
        return addBoldLine;
    }

    public boolean isInsertPageBreak() {
        return insertPageBreak;
    }

    public boolean isShowGridlines() {
        return showGridlines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportPrintSettings that = (ReportPrintSettings) o;

        if (insertExtraLine != that.insertExtraLine) return false;
        if (addBoldLine != that.addBoldLine) return false;
        if (insertPageBreak != that.insertPageBreak) return false;
        if (showGridlines != that.showGridlines) return false;
        if (reportWidth != null ? !reportWidth.equals(that.reportWidth) : that.reportWidth != null) return false;
        if (fontFace != null ? !fontFace.equals(that.fontFace) : that.fontFace != null) return false;
        if (fontSize != null ? !fontSize.equals(that.fontSize) : that.fontSize != null) return false;
        if (reportAlignment != null ? !reportAlignment.equals(that.reportAlignment) : that.reportAlignment != null)
            return false;
        if (groupAlignment != null ? !groupAlignment.equals(that.groupAlignment) : that.groupAlignment != null)
            return false;
        return !(columnAlignment != null ? !columnAlignment.equals(that.columnAlignment) : that.columnAlignment != null);

    }

    @Override
    public int hashCode() {
        int result = reportWidth != null ? reportWidth.hashCode() : 0;
        result = 31 * result + (fontFace != null ? fontFace.hashCode() : 0);
        result = 31 * result + (fontSize != null ? fontSize.hashCode() : 0);
        result = 31 * result + (reportAlignment != null ? reportAlignment.hashCode() : 0);
        result = 31 * result + (groupAlignment != null ? groupAlignment.hashCode() : 0);
        result = 31 * result + (columnAlignment != null ? columnAlignment.hashCode() : 0);
        result = 31 * result + (insertExtraLine ? 1 : 0);
        result = 31 * result + (addBoldLine ? 1 : 0);
        result = 31 * result + (insertPageBreak ? 1 : 0);
        result = 31 * result + (showGridlines ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReportPrintSettings{" +
                "reportWidth='" + reportWidth + '\'' +
                ", fontFace='" + fontFace + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", reportAlignment='" + reportAlignment + '\'' +
                ", groupAlignment='" + groupAlignment + '\'' +
                ", columnAlignment='" + columnAlignment + '\'' +
                ", insertExtraLine=" + insertExtraLine +
                ", addBoldLine=" + addBoldLine +
                ", insertPageBreak=" + insertPageBreak +
                ", showGridlines=" + showGridlines +
                '}';
    }
}
