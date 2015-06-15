package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	public List<Game> findAll();
}
