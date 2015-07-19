package babel_back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import babel.entity.Challenge;
import babel.entity.Game;
import babel.entity.User;
import babel.repository.ChallengeRepository;
import babel.repository.GameRepository;
import babel.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChallengeControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	Challenge challenge = new Challenge();
	Game game = new Game();
	User player = new User();
	User challenger = new User();
	String username = "playerUsername";
	
	//concrete repo
	@Autowired
	ChallengeRepository testRepo;
	
	@Autowired
	GameRepository gameRepo;
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
			
		game.setGameDescription("description");
		game.setGameTitle("gametest");
		game.setGameImg("game img test");
		game.setGameName("game test");
		
		gameRepo.save(game);
		
		player.setFirstName("playerFirstname");
		player.setLastName("playerLastname");
		player.setMail("playerMail");
		player.setPwd("12345");
		player.setSex("M");
		player.setUsername(username);
		
		userRepo.save(player);
		
		challenger.setFirstName("challengerFristname");
		challenger.setLastName("challengerLastname");
		challenger.setMail("challengerMail");
		challenger.setPwd("12345");
		challenger.setSex("M");
		challenger.setUsername("challengerUsername");
		
		userRepo.save(challenger);
		
		challenge.setChallenger(challenger);
		challenge.setGame(game);
		challenge.setPlayer(player);
		challenge.setPlayerScore(41454);
				
	}
	
	@Test
	public void test_1_postOnWrongUri_ShouldReturn_MethodNotAllowed() throws Exception {
		
		mockMvc.perform(post("/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(challenge)))
				.andDo(print())
				.andExpect(status().isMethodNotAllowed());
	}
	
	@Test
	public void test_2_createChallengeWithValidParameters_ShouldReturn_200() throws Exception {
			
		mockMvc.perform(post("/challenges/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(challenge)))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void test_3_getChallengeById_ShouldReturn_ValidContent() throws Exception {
		testRepo.save(challenge);
		
		mockMvc.perform(get("/challenges?username={username}", username)
			.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].playerName").value("playerUsername"))
			.andExpect(jsonPath("$[0].playerScore").value(41454))
			.andExpect(jsonPath("$[0].challengerName").value("challengerUsername"))
			.andExpect(jsonPath("$[0].challengerScore").value(IsNull.nullValue()));
	}
}
