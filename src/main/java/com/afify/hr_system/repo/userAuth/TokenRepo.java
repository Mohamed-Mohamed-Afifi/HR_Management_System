package com.afify.hr_system.repo.userAuth;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afify.hr_system.model.appUser.Token;

public interface TokenRepo extends JpaRepository<Token, Integer>{
	
//	@NativeQuery(value="select t.* from users u join token t on u.id=t.user_id where(u.id =:id and t.is_expired = 0 and t.is_revocked =0))")
	@Query("select t from Token t join fetch t.user where t.user.id=:id and t.is_expired=false and t.is_revocked=false")
	List<Token> findValidTokenUserId(int id);

	@EntityGraph(attributePaths = {"user"})
	Token findByToken(String token);
}
