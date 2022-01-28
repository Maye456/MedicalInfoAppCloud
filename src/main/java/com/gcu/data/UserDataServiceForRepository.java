package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.model.UserEntity;

@Service
public class UserDataServiceForRepository implements IUserDataAccess<UserEntity>
{
	@Autowired
	private UserRepository userRepository;
	@SuppressWarnings("unused")
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	// Non-Default Constructor
	public UserDataServiceForRepository(UserRepository userRepository, DataSource dataSource)
	{
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int createUser(UserEntity newUser) 
	{
		UserEntity result = userRepository.save(newUser);
        if (result == null)
        {
            return 0;
        }
        return (int) result.getId();
	}

//	@Override
//	public boolean login(UserEntity model) 
//	{
//		RegisterModel result = jdbcTemplateObject.queryForObject(
//				"SELECT Username, Password FROM user WHERE Username = ? AND Password =?",
//				new UserMapper(),
//				new Object[] {model.getUsername(), model.getPassword()});
//		if (result != null)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
}
