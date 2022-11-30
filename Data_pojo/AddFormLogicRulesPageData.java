package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddFormLogicRulesPageData {


    private String logicName;
    private String actionType;
    private String question;
    private String condition;

    public AddFormLogicRulesPageData(String logicName, String actionType, String question, String condition) {
        this.logicName = logicName;
        this.actionType = actionType;
        this.question = question;
        this.condition = condition;
    }

    public String getLogicName() {
        return logicName;
    }

    public String getActionType() {
        return actionType;
    }

    public String getQuestion() {
        return question;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFormLogicRulesPageData that = (AddFormLogicRulesPageData) o;
        return Objects.equals(logicName, that.logicName) &&
                Objects.equals(actionType, that.actionType) &&
                Objects.equals(question, that.question) &&
                Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logicName, actionType, question, condition);
    }

    @Override
    public String toString() {
        return "AddFormLogicRulesPageData{" +
                "logicName='" + logicName + '\'' +
                ", actionType='" + actionType + '\'' +
                ", question='" + question + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
