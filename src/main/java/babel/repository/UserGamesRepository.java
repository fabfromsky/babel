package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.UserGames;

public interface UserGamesRepository extends JpaRepository<UserGames, Long>{

	public List<UserGames> findByUser(String user);

}
