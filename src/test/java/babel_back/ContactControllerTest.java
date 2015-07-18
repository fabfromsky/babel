package babel_back;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ContactControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		
	}
	
	@Test
	public void createContact_ShouldReturn_200() {
		
	}
}
