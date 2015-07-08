package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import babel.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

	@Query("SELECT u FROM User u WHERE u.username LIKE'%'||:search||'%'")
	public List<User> searchByUsernameLike(@Param("search") String search);
	
}
