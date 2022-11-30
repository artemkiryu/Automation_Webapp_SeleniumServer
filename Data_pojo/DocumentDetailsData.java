package pojo;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class DocumentDetailsData {

    private String documentName;
    private String documentType;
    private String description;
    private String fileHREF;

    public DocumentDetailsData(String documentName, String documentType, String description, String fileHREF) {
        this.documentName = documentName;
        this.documentType = documentType;
        this.description = description;
        this.fileHREF = fileHREF;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDescription() {
        return description;
    }

    public String getFileHREF() {
        return fileHREF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentDetailsData)) return false;

        DocumentDetailsData that = (DocumentDetailsData) o;

        if (!getDocumentName().equals(that.getDocumentName())) return false;
        if (!getDocumentType().equals(that.getDocumentType())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        return getFileHREF().equals(that.getFileHREF());
    }

    @Override
    public int hashCode() {
        int result = getDocumentName().hashCode();
        result = 31 * result + getDocumentType().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getFileHREF().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DocumentDetailsData{" +
                "documentName='" + documentName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", description='" + description + '\'' +
                ", fileHREF='" + fileHREF + '\'' +
                '}';
    }


}
