package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormAddlRegsPageData {

    private String instructionText;

    public AddFormAddlRegsPageData(String instructionText) {
        this.instructionText = instructionText;
    }

    public String getInstructionText() {
        return instructionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddFormAddlRegsPageData)) return false;

        AddFormAddlRegsPageData that = (AddFormAddlRegsPageData) o;

        return getInstructionText().equals(that.getInstructionText());
    }

    @Override
    public int hashCode() {
        return getInstructionText().hashCode();
    }

    @Override
    public String toString() {
        return "AddFormAddlRegsPageData{" +
                "instructionText='" + instructionText + '\'' +
                '}';
    }

   }
