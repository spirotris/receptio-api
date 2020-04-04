package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeRepository mockRepository;

    @Before
    public void init() {
        // Setup things!
    }

    @Test
    public void firstTestAlwaysWins() {
        // Test ALL the things!
        assert(true);
    }

    @Test
    @Ignore
    public void assertTravisCiShouldStopMe() {
        assert(false);
    }

}