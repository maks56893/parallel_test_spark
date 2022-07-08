package com.altcraft.utils;

public class Counter {
    private static int workflowOne = 0;
    private static int workflowTwo = 0;
    private static int workflowOneCounter = 0;
    private static int workflowTwoCounter = 0;

    private static boolean resetFlag = false;

    public static int getWorkflowOneCounter() {
        return workflowOneCounter;
    }

    public static int getWorkflowTwoCounter() {
        return workflowTwoCounter;
    }

    public static void setResetFlag(boolean resetFlag) {
        Counter.resetFlag = resetFlag;
    }

    public static void reset() {
        workflowOne = 0;
        workflowTwo = 0;
        workflowOneCounter = 0;
        workflowTwoCounter = 0;
        resetFlag = false;
    }

    public static void count(int workflow_id) {
        if (!resetFlag) {
            if (workflow_id > 0) {
                if (workflow_id == workflowOne) {
                    workflowOneCounter++;
                } else if (workflow_id == workflowTwo) {
                    workflowTwoCounter++;
                }

                if (workflowOne == 0 && workflowTwo == 0) {
                    workflowOne = workflow_id;
                    workflowOneCounter++;
                } else if (workflow_id != workflowOne && workflowTwo == 0) {
                    workflowTwo = workflow_id;
                    workflowTwoCounter++;
                }
            }
        } else {
            reset();
            count(workflow_id);
        }

    }
}
