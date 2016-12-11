package br.com.felipe;

import br.com.felipe.json.JsonResponse;
import br.com.felipe.vo.Insight;
import br.com.felipe.vo.JsonObjectDifference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
public class DiffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldBeSuccessOkWhenRightIsCalled() throws Exception {
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity("/diff/124/right",
                        new String("ew0KICAibmFtZSI6ICJGZWxpcGUiLA0KICAiYWdlIjogMzANCn0="), String.class);
        assertThat(responseEntity.getBody(), is(equalTo("Ok!")));
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));

    }

    @Test
    public void shouldBeSuccessOkWhenLeftIsCalled() throws Exception {
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity("/diff/124/left", new String("ew0KICAibmFtZSI6ICJKb3NlIiwNCiAgImFnZSI6IDMxDQp9"), String.class);
        assertThat(responseEntity.getBody(), is(equalTo("Ok!")));
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }

    @Test
    public void shouldBeSuccessWhenGetDiffIsCalled() throws Exception {
        String expected = new JsonResponse().buildErrorJsonResponseWithInsight(buildInsight());
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("/diff/124", String.class);
        assertThat(responseEntity.getBody(), is(equalTo(expected)));
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }

    private Insight buildInsight(){
        Insight insight = new Insight();
        insight.addDifferenceValueOffset(new JsonObjectDifference("name", 0, 0));
        insight.addDifferenceValueOffset(new JsonObjectDifference("age", 1, 1));
        return insight;
    }




}
