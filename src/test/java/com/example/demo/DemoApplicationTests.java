package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// Spring MockMvc handles the incoming HTTP request and sends it to controller
// so that the code is called in exactly the same way as if it were processing a real HTTP request
// but without starting the server
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

    // Test for case where no parameter is given, expect default output "----"
	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/reverse")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("----")));
	}

	// Test for case where a string is given, expect the reversed string as output
	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/reverse").param("string", "orangepeel"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("leepegnaro")));
	}

}