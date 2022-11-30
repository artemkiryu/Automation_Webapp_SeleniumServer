package pojo;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class TaskDetailsData {

    private String subject;
    private String dueDate;
    private String dueTime;
    private String startDate;
    private String status;
    private String priority;
    private String reminder;
    private String reminderDate;
    private String reminderTime;
    private String notes;
    private String name;

    public TaskDetailsData(String subject, String dueDate, String dueTime, String startDate, String status, String priority, String reminder, String reminderDate, String reminderTime, String notes, String name) {
        this.subject = subject;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.startDate = startDate;
        this.status = status;
        this.priority = priority;
        this.reminder = reminder;
        this.reminderDate = reminderDate;
        this.reminderTime = reminderTime;
        this.notes = notes;
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public String getReminder() {
        return reminder;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public String getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDetailsData)) return false;

        TaskDetailsData that = (TaskDetailsData) o;

        if (getReminder() != that.getReminder()) return false;
        if (!getSubject().equals(that.getSubject())) return false;
        if (!getDueDate().equals(that.getDueDate())) return false;
        if (!getDueTime().equals(that.getDueTime())) return false;
        if (!getStartDate().equals(that.getStartDate())) return false;
        if (!getStatus().equals(that.getStatus())) return false;
        if (!getPriority().equals(that.getPriority())) return false;
        if (!getReminderDate().equals(that.getReminderDate())) return false;
        if (!getReminderTime().equals(that.getReminderTime())) return false;
        if (!getNotes().equals(that.getNotes())) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = getSubject().hashCode();
        result = 31 * result + getDueDate().hashCode();
        result = 31 * result + getDueTime().hashCode();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getPriority().hashCode();
        result = 31 * result + getReminder().hashCode();
        result = 31 * result + getReminderDate().hashCode();
        result = 31 * result + getReminderTime().hashCode();
        result = 31 * result + getNotes().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TaskDetailsData{" +
                "subject='" + subject + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", dueTime='" + dueTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", reminder=" + reminder +
                ", reminderDate='" + reminderDate + '\'' +
                ", reminderTime='" + reminderTime + '\'' +
                ", notes='" + notes + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
