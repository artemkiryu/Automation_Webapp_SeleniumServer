package pojo;

/**
 * Created by infoobjects on 30-08-2017.
 */
public class EventQuestionData {

    private String questionType;
    private String name;
    private String code;
    private String display;
    private String errorMessage;
    private String answerOptions;
    private String defaultAnswer;
    private String inputSize;
    private String minChar;
    private String maxChar;
    private String showOnline;
    private String questionAnswer;
    private String questionFont;
    private String answerFont;
    private String horizontalQuestion;
    private String horizontalAnswers;
    private String verticalQuestion;
    private String verticalAnswer;

    public EventQuestionData(String questionType, String name, String code, String display, String errorMessage, String answerOptions, String defaultAnswer, String inputSize, String minChar, String maxChar, String showOnline, String questionAnswer, String questionFont, String answerFont, String horizontalQuestion, String horizontalAnswers, String verticalQuestion, String verticalAnswer) {
        this.questionType = questionType;
        this.name = name;
        this.code = code;
        this.display = display;
        this.errorMessage = errorMessage;
        this.answerOptions = answerOptions;
        this.defaultAnswer = defaultAnswer;
        this.inputSize = inputSize;
        this.minChar = minChar;
        this.maxChar = maxChar;
        this.showOnline = showOnline;
        this.questionAnswer = questionAnswer;
        this.questionFont = questionFont;
        this.answerFont = answerFont;
        this.horizontalQuestion = horizontalQuestion;
        this.horizontalAnswers = horizontalAnswers;
        this.verticalQuestion = verticalQuestion;
        this.verticalAnswer = verticalAnswer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAnswerOptions() {
        return answerOptions;
    }

    public String getDefaultAnswer() {
        return defaultAnswer;
    }

    public String getInputSize() {
        return inputSize;
    }

    public String getMinChar() {
        return minChar;
    }

    public String getMaxChar() {
        return maxChar;
    }

    public String getShowOnline() {
        return showOnline;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public String getQuestionFont() {
        return questionFont;
    }

    public String getAnswerFont() {
        return answerFont;
    }

    public String getHorizontalQuestion() {
        return horizontalQuestion;
    }

    public String getHorizontalAnswers() {
        return horizontalAnswers;
    }

    public String getVerticalQuestion() {
        return verticalQuestion;
    }

    public String getVerticalAnswer() {
        return verticalAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventQuestionData)) return false;

        EventQuestionData that = (EventQuestionData) o;

        if (!getQuestionType().equals(that.getQuestionType())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getCode().equals(that.getCode())) return false;
        if (!getDisplay().equals(that.getDisplay())) return false;
        if (!getErrorMessage().equals(that.getErrorMessage())) return false;
        if (!getAnswerOptions().equals(that.getAnswerOptions())) return false;
        if (!getDefaultAnswer().equals(that.getDefaultAnswer())) return false;
        if (!getInputSize().equals(that.getInputSize())) return false;
        if (!getMinChar().equals(that.getMinChar())) return false;
        if (!getMaxChar().equals(that.getMaxChar())) return false;
        if (!getShowOnline().equals(that.getShowOnline())) return false;
        if (!getQuestionAnswer().equals(that.getQuestionAnswer())) return false;
        if (!getQuestionFont().equals(that.getQuestionFont())) return false;
        if (!getAnswerFont().equals(that.getAnswerFont())) return false;
        if (!getHorizontalQuestion().equals(that.getHorizontalQuestion())) return false;
        if (!getHorizontalAnswers().equals(that.getHorizontalAnswers())) return false;
        if (!getVerticalQuestion().equals(that.getVerticalQuestion())) return false;
        return getVerticalAnswer().equals(that.getVerticalAnswer());
    }

    @Override
    public int hashCode() {
        int result = getQuestionType().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + getDisplay().hashCode();
        result = 31 * result + getErrorMessage().hashCode();
        result = 31 * result + getAnswerOptions().hashCode();
        result = 31 * result + getDefaultAnswer().hashCode();
        result = 31 * result + getInputSize().hashCode();
        result = 31 * result + getMinChar().hashCode();
        result = 31 * result + getMaxChar().hashCode();
        result = 31 * result + getShowOnline().hashCode();
        result = 31 * result + getQuestionAnswer().hashCode();
        result = 31 * result + getQuestionFont().hashCode();
        result = 31 * result + getAnswerFont().hashCode();
        result = 31 * result + getHorizontalQuestion().hashCode();
        result = 31 * result + getHorizontalAnswers().hashCode();
        result = 31 * result + getVerticalQuestion().hashCode();
        result = 31 * result + getVerticalAnswer().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EventQuestionData{" +
                "questionType='" + questionType + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", display='" + display + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", answerOptions='" + answerOptions + '\'' +
                ", defaultAnswer='" + defaultAnswer + '\'' +
                ", inputSize='" + inputSize + '\'' +
                ", minChar='" + minChar + '\'' +
                ", maxChar='" + maxChar + '\'' +
                ", showOnline='" + showOnline + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionFont='" + questionFont + '\'' +
                ", answerFont='" + answerFont + '\'' +
                ", horizontalQuestion='" + horizontalQuestion + '\'' +
                ", horizontalAnswers='" + horizontalAnswers + '\'' +
                ", verticalQuestion='" + verticalQuestion + '\'' +
                ", verticalAnswer='" + verticalAnswer + '\'' +
                '}';
    }


}
