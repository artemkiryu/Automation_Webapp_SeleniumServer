package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class CustomQuestionData {

    private String questionFor;
    private String questionType;
    private String name;
    private String code;
    private String displayRegForm;
    private String errorMessage;
    private String inputSize;
    private String minimumCharacter;
    private String maximumCharacter;
    private String defaultAnswer;
    private String showOnline;
    private String questionAnswer;
    private String questionFont;
    private String questionHorizontalFont;
    private String questionVerticalFont;
    private String answerFont;
    private String answerHorizontalFont;
    private String answerVerticalFont;
    private String className;

    public CustomQuestionData(String questionType, String name, String code, String displayRegForm, String errorMessage, String inputSize, String minimumCharacter, String maximumCharacter, String defaultAnswer, String showOnline, String questionAnswer, String questionFont, String questionHorizontalFont, String questionVerticalFont, String answerFont, String answerHorizontalFont, String answerVerticalFont, String className) {

        this.questionType = questionType;
        this.name = name;
        this.code = code;
        this.displayRegForm = displayRegForm;
        this.errorMessage = errorMessage;
        this.inputSize = inputSize;
        this.minimumCharacter = minimumCharacter;
        this.maximumCharacter = maximumCharacter;
        this.defaultAnswer = defaultAnswer;
        this.showOnline = showOnline;
        this.questionAnswer = questionAnswer;
        this.questionFont = questionFont;
        this.questionHorizontalFont = questionHorizontalFont;
        this.questionVerticalFont = questionVerticalFont;
        this.answerFont = answerFont;
        this.answerHorizontalFont = answerHorizontalFont;
        this.answerVerticalFont = answerVerticalFont;
        this.className = className;
    }

    public CustomQuestionData(String questionFor, String questionType, String name, String code, String displayRegForm, String errorMessage, String inputSize, String minimumCharacter, String maximumCharacter, String defaultAnswer, String showOnline, String questionAnswer, String questionFont, String questionHorizontalFont, String questionVerticalFont, String answerFont, String answerHorizontalFont, String answerVerticalFont, String className) {
        this.questionFor = questionFor;
        this.questionType = questionType;
        this.name = name;
        this.code = code;
        this.displayRegForm = displayRegForm;
        this.errorMessage = errorMessage;
        this.inputSize = inputSize;
        this.minimumCharacter = minimumCharacter;
        this.maximumCharacter = maximumCharacter;
        this.defaultAnswer = defaultAnswer;
        this.showOnline = showOnline;
        this.questionAnswer = questionAnswer;
        this.questionFont = questionFont;
        this.questionHorizontalFont = questionHorizontalFont;
        this.questionVerticalFont = questionVerticalFont;
        this.answerFont = answerFont;
        this.answerHorizontalFont = answerHorizontalFont;
        this.answerVerticalFont = answerVerticalFont;
        this.className = className;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomQuestionData that = (CustomQuestionData) o;
        return Objects.equals(questionFor, that.questionFor) &&
                Objects.equals(questionType, that.questionType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(displayRegForm, that.displayRegForm) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(inputSize, that.inputSize) &&
                Objects.equals(minimumCharacter, that.minimumCharacter) &&
                Objects.equals(maximumCharacter, that.maximumCharacter) &&
                Objects.equals(defaultAnswer, that.defaultAnswer) &&
                Objects.equals(showOnline, that.showOnline) &&
                Objects.equals(questionAnswer, that.questionAnswer) &&
                Objects.equals(questionFont, that.questionFont) &&
                Objects.equals(questionHorizontalFont, that.questionHorizontalFont) &&
                Objects.equals(questionVerticalFont, that.questionVerticalFont) &&
                Objects.equals(answerFont, that.answerFont) &&
                Objects.equals(answerHorizontalFont, that.answerHorizontalFont) &&
                Objects.equals(answerVerticalFont, that.answerVerticalFont) &&
                Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionFor, questionType, name, code, displayRegForm, errorMessage, inputSize, minimumCharacter, maximumCharacter, defaultAnswer, showOnline, questionAnswer, questionFont, questionHorizontalFont, questionVerticalFont, answerFont, answerHorizontalFont, answerVerticalFont, className);
    }

    @Override
    public String toString() {
        return "CustomQuestionData{" +
                "questionFor='" + questionFor + '\'' +
                ", questionType='" + questionType + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", displayRegForm='" + displayRegForm + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", inputSize='" + inputSize + '\'' +
                ", minimumCharacter='" + minimumCharacter + '\'' +
                ", maximumCharacter='" + maximumCharacter + '\'' +
                ", defaultAnswer='" + defaultAnswer + '\'' +
                ", showOnline='" + showOnline + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionFont='" + questionFont + '\'' +
                ", questionHorizontalFont='" + questionHorizontalFont + '\'' +
                ", questionVerticalFont='" + questionVerticalFont + '\'' +
                ", answerFont='" + answerFont + '\'' +
                ", answerHorizontalFont='" + answerHorizontalFont + '\'' +
                ", answerVerticalFont='" + answerVerticalFont + '\'' +
                ", className='" + className + '\'' +
                '}';
    }


    public String getQuestionFor() {
        return questionFor;
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

    public String getDisplayRegForm() {
        return displayRegForm;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getInputSize() {
        return inputSize;
    }

    public String getMinimumCharacter() {
        return minimumCharacter;
    }

    public String getMaximumCharacter() {
        return maximumCharacter;
    }

    public String getDefaultAnswer() {
        return defaultAnswer;
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

    public String getQuestionHorizontalFont() {
        return questionHorizontalFont;
    }

    public String getQuestionVerticalFont() {
        return questionVerticalFont;
    }

    public String getAnswerFont() {
        return answerFont;
    }

    public String getAnswerHorizontalFont() {
        return answerHorizontalFont;
    }

    public String getAnswerVerticalFont() {
        return answerVerticalFont;
    }

    public String getClassName() {
        return className;
    }


}
