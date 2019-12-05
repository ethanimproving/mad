package org.improving.mad.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class AppAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void movies_should_return_status_200() throws Exception {
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk());
    }
}