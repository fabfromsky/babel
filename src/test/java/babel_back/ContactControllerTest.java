package babel_back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import babel.Application;
import babel.entity.Contact;
import babel.entity.User;
import babel.repository.ContactRepository;
import babel.repository.UserRepository;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ContactControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	String username = "usernameTest";
	User user = new User();
	User contact = new User();
	Contact userContact = new Contact();
	Contact userContact2 = new Contact();
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		
		user.setFirstName("userFirstname");
		user.setLastName("userLastname");
		user.setMail("userMail");
		user.setPwd("12345");
		user.setSex("M");
		user.setUsername(username);
		
		userRepo.save(user);
		
		contact.setFirstName("contactFirstname");
		contact.setLastName("contactLastname");
		contact.setMail("contactMail");
		contact.setPwd("12345");
		contact.setSex("M");
		contact.setUsername("contactUsername");
		
		userRepo.save(contact);
		
		userContact.setContact(contact);
		userContact.setUser(user);
		
		userContact2.setContact(user);
		userContact2.setUser(contact);
		
		
	}
	
	@Test
	public void addContact_ShouldReturn_200() throws Exception {
		mockMvc.perform(post("/user/contact/add")
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.content(jsonMapper.writeValueAsString(userContact)))
			.andDo(print())
			.andExpect(status().isOk());
	}
	@Test
	public void getUsersThatAddedMe_ShouldReturn_ValidContent() throws Exception {
		
		contactRepo.save(userContact2);
				
		mockMvc.perform(get("/contact?username={username}", username))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].username").value("contactUsername"));
	}
}
