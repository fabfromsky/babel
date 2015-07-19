package babel_back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import babel.Application;
import babel.entity.Trophy;
import babel.repository.TrophyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class TrophyControllerTest {
	
private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private TrophyRepository trophyRepo;
	
	private Trophy trophy = new Trophy();
	
	@Before
	public void SetUp() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		
		trophy.setTrophyTitle("titleTest");
		trophy.setTrophyName("nameTest");
		trophy.setDescription("description de test");
		trophy.setTrophyCategory("categoryTest");
		trophy.setPoints(123);

	}
	
	@Test
	public void getTrophyWidthValidParameters_ShouldReturn_ValidContent() throws Exception {
		
		trophyRepo.save(trophy);
		
		mockMvc.perform(get("/trophies"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].trophyTitle").value("titleTest"))
			.andExpect(jsonPath("$[0].trophyName").value("nameTest"))
			.andExpect(jsonPath("$[0].description").value("description de test"))
			.andExpect(jsonPath("$[0].trophyCategory").value("categoryTest"))
			.andExpect(jsonPath("$[0].points").value(123));
	}

}
