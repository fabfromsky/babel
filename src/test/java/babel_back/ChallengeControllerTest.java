package babel_back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import babel.Application;
import babel.entity.Challenge;
import babel.entity.Game;
import babel.repository.ChallengeRepository;
import babel.repository.GameRepository;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ChallengeControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	Challenge challenge = new Challenge();
	Game game = new Game();
	String username = "playertest";
	
	//concrete repo
	@Autowired
	ChallengeRepository testRepo;
	
	@Autowired
	GameRepository gameRepo;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
			
		game.setGameDescription("description");
		game.setGameId("gametest");
		game.setGameImg("game img test");
		game.setGameName("game test");
		
		gameRepo.save(game);
				
	}
	
	@Test
	public void createChallengeWithValidParameters_ShouldReturn_200() throws Exception {
		
		challenge.setChallenger("challengerTest");
		challenge.setChallengerScore(4545);
		challenge.setGame(game);
		challenge.setPlayer(username);
		challenge.setPlayerScore(41454);
		
		mockMvc.perform(post("/challenges/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(challenge)))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void getChallengeById_ShouldReturn_ValidContent() throws Exception {
		testRepo.save(challenge);
		
		mockMvc.perform(get("/challenges?username={username}", username).accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
