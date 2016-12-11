package br.com.felipe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO(Felipe) Create integration tests
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DiffController.class)
//public class DiffControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void shouldBeSuccessOkWhenLeftIsCalled() throws Exception {
//        mvc.perform(post("/v1/diff/1290/left")
//                .content(new String("ew0KICAibmFtZSI6ICJGZWxpcGUiLA0KICAiY3BmIjogIjMzNDUyODQzODMxIg0KfQ0K").getBytes()))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Ok!"));
//    }
//
//}
