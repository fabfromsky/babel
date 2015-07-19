package babel_back;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import babel.Application;
import babel.entity.Message;
import babel.entity.User;
import babel.repository.MessageRepository;
import babel.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class MessageControllerTest {
	
	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	MessageRepository messageRepo;
	
	@Autowired
	UserRepository userRepo;

	Message message = new Message();
	
	User sender = new User();
	
	User receiver = new User();
	
	String username = "userNameTest";
	
	@Before
	public void SetUp() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		
		sender.setFirstName("senderFirstname");
		sender.setLastName("senderLastname");
		sender.setMail("senderMail");
		sender.setPwd("12345");
		sender.setSex("M");
		sender.setUsername(username);
		
		userRepo.save(sender);
		
		receiver.setFirstName("receiverFristname");
		receiver.setLastName("receiverLastname");
		receiver.setMail("receiverMail");
		receiver.setPwd("12345");
		receiver.setSex("M");
		receiver.setUsername("receiverName");
		
		userRepo.save(receiver);
		
		message.setContent("Lorem ipsum dolor sit amet...");
		message.setDate("123548748");
		message.setReceiver(receiver);
		message.setSender(sender);

	}
	
	@Test
	public void getMessageWithValidParameters_ShoulReturn_ValidContent() throws Exception {
		messageRepo.save(message);
		
		mockMvc.perform(get("/messages?username={username}", username))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].content").value("Lorem ipsum dolor sit amet..."))
			.andExpect(jsonPath("$[0].date").value("123548748"))
			.andExpect(jsonPath("$[0].senderName").value(username))
			.andExpect(jsonPath("$[0].receiverName").value("receiverName"));
		
	}
	
	public void postMessageWithValidParameters_ShouldReturn_200() throws Exception {
		mockMvc.perform(post("/messages/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(message)))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
