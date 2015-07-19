package babel_back;

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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import babel.Application;
import babel.entity.Game;
import babel.entity.User;
import babel.entity.UserGames;
import babel.repository.GameRepository;
import babel.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class UserGamesControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	GameRepository gameRepo;
	
	@Autowired
	UserRepository userRepo;

	Game game = new Game();
	
	User user = new User();
	
	UserGames userGame = new UserGames();
	
	String username = "userNameTest";
	
	@Before
	public void SetUp() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		jsonMapper.setSerializationInclusion(Include.NON_NULL);
		
		game.setGameTitle("titleTest");
		game.setGameDescription("description de test");
		game.setGameImg("imageTest");
		game.setGameName("name de test");
		
		gameRepo.save(game);
		
		user.setFirstName("userFirstname");
		user.setLastName("userLastname");
		user.setMail("userMail");
		user.setPwd("12345");
		user.setSex("M");
		user.setUsername(username);
		
		userRepo.save(user);
		
		userGame.setGame(game);
		userGame.setScore(1547);
		userGame.setUser(user);
		
	}
	
	@Test
	public void saveGameWithValidParameters_ShouldReturn_200() throws Exception {
		
		mockMvc.perform(post("/user/games/new")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(userGame)))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
