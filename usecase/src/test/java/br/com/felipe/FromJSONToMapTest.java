package br.com.felipe;

import br.com.felipe.converter.JsonConverter;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasValue;


/**
 * Test for class that transverse json to map
 */
public class FromJSONToMapTest {

    private JsonConverter jsonConverter;

    @Before
    public void setup() {
        this.jsonConverter = new JsonConverter();
    }

    @Test
    public void testSimpleJsonConvertToMap(){
        Map<String, String> map = this.jsonConverter.toMap("{\"nome\":\"Felipe\",\"age\":30}");
        assertThat(map, hasValue("Felipe"));
        assertThat(map, hasValue("30"));
    }

}
