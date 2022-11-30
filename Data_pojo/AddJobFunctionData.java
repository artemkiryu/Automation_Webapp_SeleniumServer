package pojo;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class AddJobFunctionData {

    private String jobFunctionName;

    public AddJobFunctionData(String jobFunctionName) {
        this.jobFunctionName = jobFunctionName;
    }

    public String getJobFunctionName() {
        return jobFunctionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddJobFunctionData)) return false;

        AddJobFunctionData that = (AddJobFunctionData) o;

        return getJobFunctionName().equals(that.getJobFunctionName());
    }

    @Override
    public int hashCode() {
        return getJobFunctionName().hashCode();
    }

    @Override
    public String toString() {
        return "AddJobFunctionData{" +
                "jobFunctionName='" + jobFunctionName + '\'' +
                '}';
    }

}
