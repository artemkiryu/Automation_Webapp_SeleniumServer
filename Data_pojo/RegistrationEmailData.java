package pojo;

/**
 * Created by infoobjects on 9/22/2017.
 */
public class RegistrationEmailData {
    private String emailTempelate;
    private String from;
    private String to;
    private String replyTo;
    private String cc;
    private String bcc;
    private String append;
    private String subject;
    private String message;
    private String attachement;


    public RegistrationEmailData(String emailTempelate, String from, String to, String replyTo, String cc, String bcc, String append, String subject, String message, String attachement) {
        this.emailTempelate = emailTempelate;
        this.from = from;
        this.to = to;
        this.replyTo = replyTo;
        this.cc = cc;
        this.bcc = bcc;
        this.append = append;
        this.subject = subject;
        this.message = message;
        this.attachement = attachement;
    }

    public String getEmailTempelate() {
        return emailTempelate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public String getAppend() {
        return append;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachement() {
        return attachement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationEmailData)) return false;

        RegistrationEmailData that = (RegistrationEmailData) o;

        if (emailTempelate != null ? !emailTempelate.equals(that.emailTempelate) : that.emailTempelate != null)
            return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (replyTo != null ? !replyTo.equals(that.replyTo) : that.replyTo != null) return false;
        if (cc != null ? !cc.equals(that.cc) : that.cc != null) return false;
        if (bcc != null ? !bcc.equals(that.bcc) : that.bcc != null) return false;
        if (append != null ? !append.equals(that.append) : that.append != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return !(attachement != null ? !attachement.equals(that.attachement) : that.attachement != null);

    }

    @Override
    public int hashCode() {
        int result = emailTempelate != null ? emailTempelate.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (replyTo != null ? replyTo.hashCode() : 0);
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        result = 31 * result + (bcc != null ? bcc.hashCode() : 0);
        result = 31 * result + (append != null ? append.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (attachement != null ? attachement.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationEmailData{" +
                "emailTempelate='" + emailTempelate + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", replyTo='" + replyTo + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", append='" + append + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", attachement='" + attachement + '\'' +
                '}';
    }
}
