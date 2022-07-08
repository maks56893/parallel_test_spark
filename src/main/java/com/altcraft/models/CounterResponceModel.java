package com.altcraft.models;

import com.google.gson.annotations.SerializedName;

public class CounterResponceModel {
    /**
     получаем id кампании в json
     {
     "workflow_number": int
     "reset_counter": bool
     }
     **/

    @SerializedName(value = "workflow_one_counter")
    private int workflowOneCounter;
    @SerializedName(value = "workflow_two_counter")
    private int workflowTwoCounter;

    public CounterResponceModel() {
    }

    public CounterResponceModel(int workflowOneCounter, int workflowTwoCounter) {
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
        return "CounterResponceModel{" +
                "workflowOneCounter=" + workflowOneCounter +
                ", workflowTwoCounter=" + workflowTwoCounter +
                '}';
    }
}
