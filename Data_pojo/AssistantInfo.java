package pojo;

/**
 * Created by pkapoors on 03/06/15.
 */
public class AssistantInfo {
    private String assistantName;
    private String assistantEmail;
    private String assistantPhone;

    public AssistantInfo(String assistantName, String assistantEmail, String assistantPhone) {
        this.assistantName = assistantName;
        this.assistantEmail = assistantEmail;
        this.assistantPhone = assistantPhone;
    }

    @Override
    public String toString() {
        return "AssistantInfo{" +
                "assistantName='" + assistantName + '\'' +
                ", assistantEmail='" + assistantEmail + '\'' +
                ", assistantPhone='" + assistantPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssistantInfo)) return false;

        AssistantInfo that = (AssistantInfo) o;

        if (getAssistantName() != null ? !getAssistantName().equals(that.getAssistantName()) : that.getAssistantName() != null)
            return false;
        if (getAssistantEmail() != null ? !getAssistantEmail().equals(that.getAssistantEmail()) : that.getAssistantEmail() != null)
            return false;
        return !(getAssistantPhone() != null ? !getAssistantPhone().equals(that.getAssistantPhone()) : that.getAssistantPhone() != null);

    }

    @Override
    public int hashCode() {
        int result = getAssistantName() != null ? getAssistantName().hashCode() : 0;
        result = 31 * result + (getAssistantEmail() != null ? getAssistantEmail().hashCode() : 0);
        result = 31 * result + (getAssistantPhone() != null ? getAssistantPhone().hashCode() : 0);
        return result;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getAssistantEmail() {
        return assistantEmail;
    }

    public void setAssistantEmail(String assistantEmail) {
        this.assistantEmail = assistantEmail;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
    }
}
