package babel_back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import babel.Application;
import babel.entity.Game;
import babel.repository.GameRepository;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class GameControllerTest {
	
	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private GameRepository gameRepo;
	
	Game game = new Game();


	@Before
	public void SetUp() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
	
		game.setGameId("gametest");
		game.setGameDescription("description test");
		game.setGameImg("imagetest.jpeg");
		game.setGameName("game test");

	}
	
	@Test
	public void getGames_ShouldReturn_200() throws Exception {
		gameRepo.save(game);	
			
		mockMvc.perform(get("/games"))
				.andExpect(status().isOk());
	}
}
