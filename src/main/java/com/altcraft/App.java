package com.altcraft;

import com.altcraft.utils.Counter;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import static spark.Spark.*;


public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        port(8888);

        post("/workflow_write ", (req, res) -> {
            LOGGER.info("Get request to " + req.pathInfo() +
                    "with body:\n " + req.body());

            res.type("application/json");
            WorkflowNumberRequestModel workflowNumber = new Gson().fromJson(req.body(), WorkflowNumberRequestModel.class);

            LOGGER.debug("workflowNumber is: " + workflowNumber.toString());
            
            Counter.setResetFlag(workflowNumber.getResetCounter());
            Counter.count(workflowNumber.getWorkflowNumber());

            LOGGER.debug("Counter 1: " + Counter.getWorkflowOneCounter() +
                    " counter 2: " + Counter.getWorkflowTwoCounter());

            return new Gson().toJson(new WorkflowNumberResponseModel("OK"));
        });
        
        get("/get_counter", (req, res) -> {
            LOGGER.info("Get request to " + req.pathInfo());
            res.type("application/json");

            LOGGER.debug("Counter 1: " + Counter.getWorkflowOneCounter() +
                    " counter 2: " + Counter.getWorkflowTwoCounter());

            return new Gson().toJson(new CounterResponceModel(Counter.getWorkflowOneCounter(), Counter.getWorkflowTwoCounter()));
        });
    }
}
