package pojo;

/**
 * Created by infoobjects on 12/8/2015.
 */
public class ReportDisplayFormat {
    private String reportFormat;
    private String dataFormat;
    private String startRow;
    private String perPage;
    private String maxRows;

    public ReportDisplayFormat(String reportFormat, String dataFormat, String startRow, String perPage, String maxRows) {
        this.reportFormat = reportFormat;
        this.dataFormat = dataFormat;
        this.startRow = startRow;
        this.perPage = perPage;
        this.maxRows = maxRows;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public String getStartRow() {
        return startRow;
    }

    public String getPerPage() {
        return perPage;
    }

    public String getMaxRows() {
        return maxRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportDisplayFormat that = (ReportDisplayFormat) o;

        if (reportFormat != null ? !reportFormat.equals(that.reportFormat) : that.reportFormat != null) return false;
        if (dataFormat != null ? !dataFormat.equals(that.dataFormat) : that.dataFormat != null) return false;
        if (startRow != null ? !startRow.equals(that.startRow) : that.startRow != null) return false;
        if (perPage != null ? !perPage.equals(that.perPage) : that.perPage != null) return false;
        return !(maxRows != null ? !maxRows.equals(that.maxRows) : that.maxRows != null);

    }

    @Override
    public int hashCode() {
        int result = reportFormat != null ? reportFormat.hashCode() : 0;
        result = 31 * result + (dataFormat != null ? dataFormat.hashCode() : 0);
        result = 31 * result + (startRow != null ? startRow.hashCode() : 0);
        result = 31 * result + (perPage != null ? perPage.hashCode() : 0);
        result = 31 * result + (maxRows != null ? maxRows.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReportDisplayFormat{" +
                "reportFormat='" + reportFormat + '\'' +
                ", dataFormat='" + dataFormat + '\'' +
                ", startRow='" + startRow + '\'' +
                ", perPage='" + perPage + '\'' +
                ", maxRows='" + maxRows + '\'' +
                '}';
    }
}
