package example;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.lambda.thirdparty.com.google.gson.GsonBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

// Handler value: example.Handler
public class Handler implements RequestHandler<Map<String, String>, String> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String response = "200 OK";
        var separator = System.lineSeparator();
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()) + separator);
        logger.log("CONTEXT: " + gson.toJson(context) + separator);
        // process event
        logger.log("EVENT: " + gson.toJson(event) + separator);
        logger.log("EVENT TYPE: " + event.getClass().toString() + separator);

        // verify we can use java 15
        logger.log(separator + "============= start: verify we can use java 15 =============" + separator);
        var d = 1;
        switch (d) {
            case 1 -> logger.log("1: we can use java 15");
            case 2 -> logger.log("2: we can use java 15");
            default -> logger.log("default: we can use java 15");
        }
        logger.log(separator + "============= end: verify we can use java 15 =============");

        return response;
    }
}
