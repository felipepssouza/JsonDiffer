package br.com.felipe.json;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Tests for class that build JSON with difference insights
 */
public class JsonDifferenceInsightBuilderTest {

    private JsonDifferenceInsightBuilder builder;

    @Before
    public void setup() {
        this.builder = new JsonDifferenceInsightBuilder();
    }

    @Test
    public void buildJsonTest(){
        Map<String, String> left = new HashMap<>();
        left.put("name","Felippe");
        left.put("city","Sao Paulo");
        left.put("age","30");

        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");
        right.put("country","Brazil");
        right.put("age","31");

        String expectedJson = "{\"insight\":{\"differentKeys\":[{\"city\":\"Sao Paulo\"}],\"differenceValueOffset\":[{\"key\":\"name\",\"offset\":5,\"size\":2},{\"key\":\"age\",\"offset\":1,\"size\":1}]}}";
        String json = builder.buildJson(left, right);
        assertThat(json, is(equalTo(expectedJson)));
    }

}
