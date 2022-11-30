package pojo;

/**
 * Created by infoobjects on 22-09-2017.
 */
public class ExportAgenda {
    private String categoryType;
    private String fileType;
    private String fileName;

    public ExportAgenda(String categoryType, String fileType, String fileName) {
        this.categoryType = categoryType;
        this.fileType = fileType;
        this.fileName = fileName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportAgenda that = (ExportAgenda) o;

        if (categoryType != null ? !categoryType.equals(that.categoryType) : that.categoryType != null) return false;
        if (fileType != null ? !fileType.equals(that.fileType) : that.fileType != null) return false;
        return fileName != null ? fileName.equals(that.fileName) : that.fileName == null;
    }

    @Override
    public int hashCode() {
        int result = categoryType != null ? categoryType.hashCode() : 0;
        result = 31 * result + (fileType != null ? fileType.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExportAgenda{" +
                "categoryType='" + categoryType + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
