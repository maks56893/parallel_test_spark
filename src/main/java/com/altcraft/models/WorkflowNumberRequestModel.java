package com.altcraft.models;

import com.google.gson.annotations.SerializedName;

public class WorkflowNumberRequestModel {
    /**
     получаем id кампании в json
     {
     "workflow_number": int
     "reset_counter": bool
     }
     **/
    @SerializedName(value = "workflow_number")
    private int workflowNumber;

    @SerializedName(value = "reset_counter")
    private boolean resetCounter;

    public WorkflowNumberRequestModel() {
    }

    public WorkflowNumberRequestModel(int workflowNumber, boolean resetCounter) {
        this.workflowNumber = workflowNumber;
        this.resetCounter = resetCounter;
    }

    public int getWorkflowNumber() {
        return workflowNumber;
    }

    public boolean getResetCounter() {
        return resetCounter;
    }

    @Override
    public String toString() {
        return "RequestWriteWorkflowModel{" +
                "workflowNumber=" + workflowNumber +
                ", resetCounter=" + resetCounter +
                '}';
    }
}
