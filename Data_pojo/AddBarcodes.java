package pojo;

/**
 * Created by infoobjects on 5/30/2016.
 */
public class AddBarcodes {
    private String barcodeName;
    private String barcodeFormat;
    private String fieldName;
    private String fieldOptions;
    private String barcodeDelimiter;

    public AddBarcodes(String barcodeName, String barcodeFormat, String fieldName, String fieldOptions, String barcodeDelimiter) {
        this.barcodeName = barcodeName;
        this.barcodeFormat = barcodeFormat;
        this.fieldName = fieldName;
        this.fieldOptions = fieldOptions;
        this.barcodeDelimiter = barcodeDelimiter;
    }

    public String getBarcodeName() {
        return barcodeName;
    }

    public String getBarcodeFormat() {
        return barcodeFormat;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldOptions() {
        return fieldOptions;
    }

    public String getBarcodeDelimiter() {
        return barcodeDelimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddBarcodes that = (AddBarcodes) o;

        if (barcodeName != null ? !barcodeName.equals(that.barcodeName) : that.barcodeName != null) return false;
        if (barcodeFormat != null ? !barcodeFormat.equals(that.barcodeFormat) : that.barcodeFormat != null)
            return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (fieldOptions != null ? !fieldOptions.equals(that.fieldOptions) : that.fieldOptions != null) return false;
        return barcodeDelimiter != null ? barcodeDelimiter.equals(that.barcodeDelimiter) : that.barcodeDelimiter == null;
    }

    @Override
    public int hashCode() {
        int result = barcodeName != null ? barcodeName.hashCode() : 0;
        result = 31 * result + (barcodeFormat != null ? barcodeFormat.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (fieldOptions != null ? fieldOptions.hashCode() : 0);
        result = 31 * result + (barcodeDelimiter != null ? barcodeDelimiter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddBarcodes{" +
                "barcodeName='" + barcodeName + '\'' +
                ", barcodeFormat='" + barcodeFormat + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldOptions='" + fieldOptions + '\'' +
                ", barcodeDelimiter='" + barcodeDelimiter + '\'' +
                '}';
    }
}
