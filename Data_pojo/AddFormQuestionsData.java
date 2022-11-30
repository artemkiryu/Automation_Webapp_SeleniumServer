package pojo;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormQuestionsData {
    private String questionSectionName;

    public AddFormQuestionsData(String questionSectionName) {
        this.questionSectionName = questionSectionName;
    }

    public String getQuestionSectionName() {
        return questionSectionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddFormQuestionsData)) return false;

        AddFormQuestionsData that = (AddFormQuestionsData) o;

        return getQuestionSectionName().equals(that.getQuestionSectionName());
    }

    @Override
    public int hashCode() {
        return getQuestionSectionName().hashCode();
    }

    @Override
    public String toString() {
        return "AddFormQuestionsData{" +
                "questionSectionName='" + questionSectionName + '\'' +
                '}';
    }

}
