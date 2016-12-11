package br.com.felipe.json;

import br.com.felipe.vo.Insight;
import br.com.felipe.vo.NullInsight;
import br.com.felipe.vo.Response;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

/**
 * Class responsible to build Json response
 */
@Component
public class JsonResponse {

    public String buildSuccessJsonResponse(){
        Response response = new Response(Boolean.TRUE, Boolean.FALSE, new NullInsight());
        return buildJsonFromResponse(response);
    }

    public String buildErrorJsonResponseDifferentSize() {
        Response response = new Response(Boolean.FALSE, Boolean.TRUE, new NullInsight());
        return buildJsonFromResponse(response);
    }

    public String buildErrorJsonResponseWithInsight(Insight insight) {
        Response response = new Response(Boolean.FALSE, Boolean.FALSE, insight);
        return buildJsonFromResponse(response);
    }

    private String buildJsonFromResponse(Response response) {
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
