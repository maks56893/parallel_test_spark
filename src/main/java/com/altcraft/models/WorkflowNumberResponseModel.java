package com.altcraft.models;


public class WorkflowNumberResponseModel {
    /*
    Ответ от сервиса. В ответе приходит статус запроса
    {
        "status": string
    }
     */
/*    @JsonProperty("workflow_one_counter")
    private int workflowOneCounter;
    @JsonProperty("workflow_two_counter")
    private int workflowTwoCounter;

    public ResponceWriteWorkflowNumberModel(int workflowOneCounter, int workflowTwoCounter) {
        this.workflowOneCounter = workflowOneCounter;
        this.workflowTwoCounter = workflowTwoCounter;
    }

    public int getWorkflowOneCounter() {
        return workflowOneCounter;
    }

    public void setWorkflowOneCounter(int workflowOneCounter) {
        this.workflowOneCounter = workflowOneCounter;
    }

    public int getWorkflowTwoCounter() {
        return workflowTwoCounter;
    }

    public void setWorkflowTwoCounter(int workflowTwoCounter) {
        this.workflowTwoCounter = workflowTwoCounter;
    }

    @Override
    public String toString() {
        return "ResponceWriteWorkflowModel{" +
                "workflowOneCounter=" + workflowOneCounter +
                ", workflowTwoCOunter=" + workflowTwoCounter +
                '}';
    }*/

    private String status;

    public WorkflowNumberResponseModel(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
