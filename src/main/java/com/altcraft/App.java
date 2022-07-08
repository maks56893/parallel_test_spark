package com.altcraft;

import com.altcraft.models.CounterResponceModel;
import com.altcraft.models.WorkflowNumberRequestModel;
import com.altcraft.models.WorkflowNumberResponseModel;
import com.altcraft.utils.Config;
import com.altcraft.utils.Counter;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.Option;
import spark.Spark;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

import static spark.Spark.*;


public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Config config = Configuration.parseConfig();

        port(config.getPort());
        Spark.ipAddress(config.getHost());

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

    private static class Configuration {
        private static final Logger LOGGER = Logger.getLogger(Configuration.class);
        @Option(name = "--config", aliases = "--conf", usage="Print verbose status.")
        private static String param;

        protected static Config parseConfig() throws UnsupportedEncodingException, FileNotFoundException {
            Config configObj = null;

            if (param == null) {
                configObj = new Config();
            } else {
                String pathToBinary = URLDecoder.decode(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(".")).getPath(), "UTF-8");
                LOGGER.debug("Path to binary: " + pathToBinary);

                JsonReader reader = new JsonReader(new FileReader(pathToBinary + param));
                configObj = new Gson().fromJson(reader, Config.class);
            }

            LOGGER.debug("config: " + configObj.toString());
            return configObj;
        }
    }
}
