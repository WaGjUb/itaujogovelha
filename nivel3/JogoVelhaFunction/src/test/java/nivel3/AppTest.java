package nivel3;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {
  @Test
  public void Response200Char() {
    App app = new App();
    APIGatewayProxyRequestEvent inp = new APIGatewayProxyRequestEvent();
    inp.setBody("{\"jogo\": [\"XXO\", \"XOX\", \"XOX\"]}");
    APIGatewayProxyResponseEvent result = app.handleRequest(inp, null);
    assertEquals(200, result.getStatusCode().intValue());
  }

  @Test
  public void Response200Int() {
    App app = new App();
    APIGatewayProxyRequestEvent inp = new APIGatewayProxyRequestEvent();
    inp.setBody("{\"jogo\": [\"110\", \"101\", \"101\"]}");
    APIGatewayProxyResponseEvent result = app.handleRequest(inp, null);
    assertEquals(200, result.getStatusCode().intValue());
  }

  @Test
  public void Response404Char() {
    App app = new App();
    APIGatewayProxyRequestEvent inp = new APIGatewayProxyRequestEvent();
    inp.setBody("{\"jogo\": [\"0XX\", \"X00\", \"X0X\"]}");
    APIGatewayProxyResponseEvent result = app.handleRequest(inp, null);
    assertEquals(404, result.getStatusCode().intValue());
  }

  @Test
  public void Response404Int() {
    App app = new App();
    APIGatewayProxyRequestEvent inp = new APIGatewayProxyRequestEvent();
    inp.setBody("{\"jogo\": [\"011\", \"100\", \"101\"]}");
    APIGatewayProxyResponseEvent result = app.handleRequest(inp, null);
    assertEquals(404, result.getStatusCode().intValue());
  }

  @Test
  public void Response404WrongInput() {
    App app = new App();
    APIGatewayProxyRequestEvent inp = new APIGatewayProxyRequestEvent();
    inp.setBody("{\"jogo\": [\"das\", \"dsa\"]}");
    APIGatewayProxyResponseEvent result = app.handleRequest(inp, null);
    assertEquals(404, result.getStatusCode().intValue());
  }
}
