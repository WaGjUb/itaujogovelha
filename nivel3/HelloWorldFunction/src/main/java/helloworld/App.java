package helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);

        try {

            //Convert input to arraylist
            Gson gson = new Gson();
            Map<String, Object> mappedInput = gson.fromJson(input.getBody(), Map.class);
            ArrayList jogoAsObjectArray = (ArrayList) mappedInput.get("jogo");
            JogoVelha jogoVelha = new JogoVelha(jogoAsObjectArray);


            boolean isVelha = jogoVelha.isVelha();

            // have an winner ?
            if(! isVelha){
                return response
                        .withStatusCode(200);
            } else {
                return response
                        .withStatusCode(404);
            }

        } catch (Exception e) {
            return response
                    .withStatusCode(404);
        }
    }
}
