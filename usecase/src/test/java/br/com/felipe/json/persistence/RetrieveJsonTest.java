package br.com.felipe.json.persistence;

import br.com.felipe.vo.JsonPosition;
import br.com.felipe.vo.JsonStructureVO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test for the implementation of the class RetrieveJson
 */
public class RetrieveJsonTest {

    private RetrieveJson retrieveJson;
    private String defaulfId;
    private String firstEncoded = "eyJuYW1lIjoiRmVsaXBlIn0=";
    private String secondEncoded = "eyJuYW1lIjoiT3RoZXIifQ==";

    /**
     * Setup for the test
     * - Two base64 jsons, each one for a JsonPosition
     * - Behavior to retrieve by Id (UUID)
     */
    @Before
    public void setup(){
        this.defaulfId = UUID.randomUUID().toString();
        this.retrieveJson = mock(RetrieveJsonImplementation.class);
        List<JsonStructureVO> jsonStructures = new ArrayList<>();
        jsonStructures.add(new JsonStructureVO(defaulfId, firstEncoded, JsonPosition.LEFT));
        jsonStructures.add(new JsonStructureVO(defaulfId, secondEncoded, JsonPosition.RIGHT));
        when(retrieveJson.retrieveJsonById(defaulfId)).thenReturn(jsonStructures);
    }

    @Test
    public void shouldRetrieveJsonsById(){
        List<JsonStructureVO> jsonStructureVOS = this.retrieveJson.retrieveJsonById(defaulfId);
        assertThat(jsonStructureVOS.get(0).getPosition(), is(equalTo(JsonPosition.LEFT)));
        assertThat(jsonStructureVOS.get(0).getEncodedJson(), is(equalTo(firstEncoded)));
        assertThat(jsonStructureVOS.get(1).getPosition(), is(equalTo(JsonPosition.RIGHT)));
        assertThat(jsonStructureVOS.get(1).getEncodedJson(), is(equalTo(secondEncoded)));
    }

}
