package pojo;

import java.util.Objects;

public class AddInboundFlowData {


    private String flowTitle;
    private String flowSource;
    private String flowvarName;


    public AddInboundFlowData(String flowTitle, String flowSource,String flowvarName) {
        this.flowTitle = flowTitle;
        this.flowSource = flowSource;
        this.flowvarName= flowvarName;

    }



    public String getFlowTitle() {
        return flowTitle;
    }

    public String getFlowSource() {
        return flowSource;
    }

    public String getFlowvarName(){ return  flowvarName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddInboundFlowData that = (AddInboundFlowData) o;
        return Objects.equals(flowTitle, that.flowTitle) &&
                Objects.equals(flowSource, that.flowSource)&&
                Objects.equals(flowvarName, that.flowvarName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowTitle, flowSource,flowvarName);
    }

    @Override
    public String toString() {
        return "AddFlowData{" +
                "flowTitle='" + flowTitle + '\'' +
                ", flowSource='" + flowSource + '\'' +
                ", flowSource='" + flowvarName + '\'' +
                '}';
    }

}
