package pojo;

import java.util.Objects;

public class CustomQuestionDataSelect {
    private String questionType;
    private String name;
    private String code;
    private String displayRegForm;
    private String errorMessage;
    private String answerOptions;
    private String showOnline;
    private String questionAnswer;
    private String questionFont;
    private String questionHorizontalFont;
    private String questionVerticalFont;
    private String answerFont;
    private String answerHorizontalFont;
    private String answerVerticalFont;
    private String className;

    public CustomQuestionDataSelect(String questionType, String name, String code, String displayRegForm, String errorMessage, String answerOptions, String showOnline, String questionAnswer, String questionFont, String questionHorizontalFont, String questionVerticalFont, String answerFont, String answerHorizontalFont, String answerVerticalFont, String className) {
        this.questionType = questionType;
        this.name = name;
        this.code = code;
        this.displayRegForm = displayRegForm;
        this.errorMessage = errorMessage;
        this.answerOptions = answerOptions;
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

    public String getAnswerOptions() {
        return answerOptions;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomQuestionDataSelect that = (CustomQuestionDataSelect) o;
        return Objects.equals(questionType, that.questionType) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(displayRegForm, that.displayRegForm) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(answerOptions, that.answerOptions) &&
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
        return Objects.hash(questionType, name, code, displayRegForm, errorMessage, answerOptions, showOnline, questionAnswer, questionFont, questionHorizontalFont, questionVerticalFont, answerFont, answerHorizontalFont, answerVerticalFont, className);
    }
}
