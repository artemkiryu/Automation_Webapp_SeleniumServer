package pojo;

/**
 * Created by infoobjects on 6/24/2015.
 */
public class RecommendationStatus {

    private String name;
    private String description;
    private String emailTemplate;
    private String approvalStatusDetail;

    public RecommendationStatus(String name, String description, String emailTemplate, String approvalStatusDetail) {
        this.name = name;
        this.description = description;
        this.emailTemplate = emailTemplate;
        this.approvalStatusDetail = approvalStatusDetail;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmailTemplate() {
        return emailTemplate;
    }

    public String getApprovalStatusDetail() {
        return approvalStatusDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecommendationStatus)) return false;

        RecommendationStatus that = (RecommendationStatus) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (emailTemplate != null ? !emailTemplate.equals(that.emailTemplate) : that.emailTemplate != null)
            return false;
        return !(approvalStatusDetail != null ? !approvalStatusDetail.equals(that.approvalStatusDetail) : that.approvalStatusDetail != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (emailTemplate != null ? emailTemplate.hashCode() : 0);
        result = 31 * result + (approvalStatusDetail != null ? approvalStatusDetail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecommendationStatus{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", emailTemplate='" + emailTemplate + '\'' +
                ", approvalStatusDetail='" + approvalStatusDetail + '\'' +
                '}';
    }
}
