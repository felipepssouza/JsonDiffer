package br.com.felipe.insight;

import br.com.felipe.vo.Insight;
import br.com.felipe.vo.JsonObjectDifference;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Tests for class that build Insight object with differences
 */
public class DifferenceInsightBuilderTest {

    private DifferenceInsightBuilder builder;

    @Before
    public void setup() {
        this.builder = new DifferenceInsightBuilder();
    }

    @Test
    public void shouldGetInsightObjectOfDifferences(){
        Map<String, String> left = new HashMap<>();
        left.put("name","Felippe");
        left.put("city","Sao Paulo");
        left.put("age","30");

        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");
        right.put("country","Brazil");
        right.put("age","31");

        Insight insight = builder.buildInsight(left, right);
        Insight expectedInsight = buildExpectedInsight();

        assertThat(insight.getDifferentKeys(), is(equalTo(expectedInsight.getDifferentKeys())));
        assertThat(insight.getDifferenceValueOffset(), is(equalTo(expectedInsight.getDifferenceValueOffset())));
    }

    @Test
    public void shouldGetInsightWithNoOffset(){
        Map<String, String> left = new HashMap<>();
        left.put("name","Felipe");

        Map<String, String> right = new HashMap<>();
        right.put("name","Jose");

        Insight insight = builder.buildInsight(left, right);
        Insight expectedInsight = buildExpectedZeroInsight();

        assertThat(insight.getDifferentKeys(), is(equalTo(expectedInsight.getDifferentKeys())));
        assertThat(insight.getDifferenceValueOffset(), is(equalTo(expectedInsight.getDifferenceValueOffset())));
    }

    private Insight buildExpectedZeroInsight() {
        Insight insight = new Insight();
        insight.addDifferenceValueOffset(new JsonObjectDifference("name", 0, 0));
        return insight;
    }


    private Insight buildExpectedInsight() {
        Insight insight = new Insight();
        insight.addDifferentKey("city");
        insight.addDifferenceValueOffset(new JsonObjectDifference("name", 5, 2));
        insight.addDifferenceValueOffset(new JsonObjectDifference("age", 1, 1));
        return insight;
    }

}
