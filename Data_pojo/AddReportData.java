package pojo;

/**
 * Created by infoobjects on 5/26/2015.
 */
public class AddReportData {

    private String reportName;
    private String description;
    private String reportGroup;
    private boolean showSelectedUser;
    private boolean allowAccessWebService;
    private String report;
    private String subReport;
    private String columnHeader;

    public AddReportData(String reportName, String description, String reportGroup, boolean showSelectedUser, boolean allowAccessWebService, String report, String subReport, String columnHeader) {
        this.reportName = reportName;
        this.description = description;
        this.reportGroup = reportGroup;
        this.showSelectedUser = showSelectedUser;
        this.allowAccessWebService = allowAccessWebService;
        this.report = report;
        this.subReport = subReport;
        this.columnHeader = columnHeader;
    }

    public AddReportData(String reportName, String description) {
        this.reportName = reportName;
        this.description = description;
    }

    public String getReportName() {
        return reportName;
    }

    public String getDescription() {
        return description;
    }

    public String getReportGroup() {
        return reportGroup;
    }

    public boolean isShowSelectedUser() {
        return showSelectedUser;
    }

    public boolean isAllowAccessWebService() {
        return allowAccessWebService;
    }

    public String getReport() {
        return report;
    }

    public String getSubReport() {
        return subReport;
    }

    public String getColumnHeader() {
        return columnHeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddReportData that = (AddReportData) o;

        if (showSelectedUser != that.showSelectedUser) return false;
        if (allowAccessWebService != that.allowAccessWebService) return false;
        if (reportName != null ? !reportName.equals(that.reportName) : that.reportName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (reportGroup != null ? !reportGroup.equals(that.reportGroup) : that.reportGroup != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;
        if (subReport != null ? !subReport.equals(that.subReport) : that.subReport != null) return false;
        return !(columnHeader != null ? !columnHeader.equals(that.columnHeader) : that.columnHeader != null);

    }

    @Override
    public int hashCode() {
        int result = reportName != null ? reportName.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (reportGroup != null ? reportGroup.hashCode() : 0);
        result = 31 * result + (showSelectedUser ? 1 : 0);
        result = 31 * result + (allowAccessWebService ? 1 : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (subReport != null ? subReport.hashCode() : 0);
        result = 31 * result + (columnHeader != null ? columnHeader.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddReportData{" +
                "reportName='" + reportName + '\'' +
                ", description='" + description + '\'' +
                ", reportGroup='" + reportGroup + '\'' +
                ", showSelectedUser=" + showSelectedUser +
                ", allowAccessWebService=" + allowAccessWebService +
                ", report='" + report + '\'' +
                ", subReport='" + subReport + '\'' +
                ", columnHeader='" + columnHeader + '\'' +
                '}';
    }
}
