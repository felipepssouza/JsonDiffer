import br.com.felipe.DiffController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiffController.class)
@WebMvcTest(DiffController.class)
public class DiffControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldBeSuccessOkWhenLeftIsCalled() throws Exception {
        mvc.perform(post("/v1/diff/1290/left")
                .content(new String("ew0KICAibmFtZSI6ICJGZWxpcGUiLA0KICAiY3BmIjogIjMzNDUyODQzODMxIg0KfQ0K").getBytes()))
                .andExpect(status().isOk())
                .andExpect(content().string("Ok!"));
    }

}
