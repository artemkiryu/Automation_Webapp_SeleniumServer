package pojo;

/**
 * Created by infoobjects on 6/24/2015.
 */
public class RuleData {
    private String name;
    private String description;
    private String userName;
    private String ruleName;
    private String ruleoperator;
    private String ruleValue;
    private String numberOfTiers;
    private String reviewerName;
    private String entityType;


    public RuleData(String name, String description, String userName, String ruleName, String ruleOperator, String ruleValue, String numberOfTiers, String reviewerName, String entityType) {
        this.name = name;
        this.description = description;
        this.userName = userName;
        this.ruleName = ruleName;
        this.ruleoperator = ruleOperator;
        this.ruleValue = ruleValue;
        this.numberOfTiers = numberOfTiers;
        this.reviewerName = reviewerName;
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getRuleoperator() {
        return ruleoperator;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public String getNumberOfTiers() {
        return numberOfTiers;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RuleData)) return false;

        RuleData ruleData = (RuleData) o;

        if (name != null ? !name.equals(ruleData.name) : ruleData.name != null) return false;
        if (description != null ? !description.equals(ruleData.description) : ruleData.description != null)
            return false;
        if (userName != null ? !userName.equals(ruleData.userName) : ruleData.userName != null) return false;
        if (ruleName != null ? !ruleName.equals(ruleData.ruleName) : ruleData.ruleName != null) return false;
        if (ruleoperator != null ? !ruleoperator.equals(ruleData.ruleoperator) : ruleData.ruleoperator != null)
            return false;
        if (ruleValue != null ? !ruleValue.equals(ruleData.ruleValue) : ruleData.ruleValue != null) return false;
        if (numberOfTiers != null ? !numberOfTiers.equals(ruleData.numberOfTiers) : ruleData.numberOfTiers != null)
            return false;
        if (entityType != null ? !entityType.equals(ruleData.entityType) : ruleData.entityType != null) return false;
        return !(reviewerName != null ? !reviewerName.equals(ruleData.reviewerName) : ruleData.reviewerName != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (ruleoperator != null ? ruleoperator.hashCode() : 0);
        result = 31 * result + (ruleValue != null ? ruleValue.hashCode() : 0);
        result = 31 * result + (numberOfTiers != null ? numberOfTiers.hashCode() : 0);
        result = 31 * result + (reviewerName != null ? reviewerName.hashCode() : 0);
        result = 31 * result + (entityType != null ? entityType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RuleData{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", ruleOperator='" + ruleoperator + '\'' +
                ", ruleValue='" + ruleValue + '\'' +
                ", numberOfTiers='" + numberOfTiers + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", entityType='" + entityType + '\'' +
                '}';
    }
}
