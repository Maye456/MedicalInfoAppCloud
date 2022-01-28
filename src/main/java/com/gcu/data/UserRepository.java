package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gcu.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);
	//LoginModel findByUsernameAndPassword(String username, String password);
}
