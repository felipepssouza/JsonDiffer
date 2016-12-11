package br.com.felipe.json;

import br.com.felipe.vo.Insight;
import br.com.felipe.vo.JsonObjectDifference;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Test for class Json Response
 */
public class JsonResponseTest {

    private JsonResponse jsonResponse;

    @Before
    public void setup() {
        this.jsonResponse = new JsonResponse();
    }

    @Test
    public void shouldReturnSuccessJson(){
        String response = this.jsonResponse.buildSuccessJsonResponse();
        assertThat(StringUtils.trimAllWhitespace(response), containsString("\"equal\":true"));
    }

    @Test
    public void shouldReturnErrorJsonWithInsight(){
        String response = this.jsonResponse.buildErrorJsonResponseWithInsight(buildInsight());
        assertThat(StringUtils.trimAllWhitespace(response), containsString("\"equal\":false"));

    }

    @Test
    public void shouldReturnErrorJsonWithoutInsight(){
        assertThat(StringUtils.trimAllWhitespace(response), containsString("\"equal\":false"));
    }

    private Insight buildInsight(){
        Insight insight = new Insight();
        insight.addDifferentKey("other");
        insight.addDifferenceValueOffset(new JsonObjectDifference("name", 5, 2));
        return insight;
    }

}
