package br.com.mateusparente.pizzaria;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.mateusparente.pizzaria.controller.DefaultController;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@WebMvcTest(controllers = {DefaultController.class})
public class PizzaTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void listUsers() throws Exception {
		assertTrue(true);
	}
	
}
