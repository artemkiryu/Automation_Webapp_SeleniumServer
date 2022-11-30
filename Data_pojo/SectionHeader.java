package pojo;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class SectionHeader {

    private String textAboveHeader;
    private String headerText;
    private String textBelowHeader;

    public SectionHeader(String textAboveHeader, String headerText, String textBelowHeader) {
        this.textAboveHeader = textAboveHeader;
        this.headerText = headerText;
        this.textBelowHeader = textBelowHeader;
    }

    public String getTextAboveHeader() {
        return textAboveHeader;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getTextBelowHeader() {
        return textBelowHeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionHeader that = (SectionHeader) o;

        if (!textAboveHeader.equals(that.textAboveHeader)) return false;
        if (!headerText.equals(that.headerText)) return false;
        return textBelowHeader.equals(that.textBelowHeader);
    }

    @Override
    public int hashCode() {
        int result = textAboveHeader.hashCode();
        result = 31 * result + headerText.hashCode();
        result = 31 * result + textBelowHeader.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SectionHeader{" +
                "textAboveHeader='" + textAboveHeader + '\'' +
                ", headerText='" + headerText + '\'' +
                ", textBelowHeader='" + textBelowHeader + '\'' +
                '}';
    }

}
