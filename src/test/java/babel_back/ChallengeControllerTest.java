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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		game.setGameTitle("gametest");
		game.setGameImg("game img test");
		game.setGameName("game test");
		
		gameRepo.save(game);
		
		challenge.setChallenger("challengerTest");
		challenge.setGame(game);
		challenge.setPlayer(username);
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
			.andExpect(jsonPath("$[0].player").value("playertest"))
			.andExpect(jsonPath("$[0].playerScore").value(41454))
			.andExpect(jsonPath("$[0].challenger").value("challengerTest"))
			.andExpect(jsonPath("$[0].challengerScore").value(IsNull.nullValue()));
	}
	
	@Test
	public void test_4_answerChallenge_ShouldUpdateChallegeAndReturn_200() throws Exception {
						
		mockMvc.perform(post("/challenges/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(challenge)))
				.andDo(print())
				.andExpect(status().isOk());
		
		mockMvc.perform(get("/challenges?challengeid=3")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.player").value("playertest"))
				.andExpect(jsonPath("$.playerScore").value(41454))
				.andExpect(jsonPath("$.challenger").value("challengerTest"))
				.andExpect(jsonPath("$.challengerScore").value(IsNull.nullValue()));
		
		challenge.setChallengeId(3);
		challenge.setChallengerScore(14575);
		
		mockMvc.perform(post("/challenges/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(challenge)))
				.andDo(print())
				.andExpect(status().isOk());
		
		mockMvc.perform(get("/challenges?challengeid=3")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.challengerScore").value(14575));
	}
}
