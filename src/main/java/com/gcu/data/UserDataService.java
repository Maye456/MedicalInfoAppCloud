package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.model.RegisterModel;

@Service
public class UserDataService implements IUserDataAccess<RegisterModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public UserDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int createUser(RegisterModel newUser) 
	{
		return jdbcTemplate.update(
				"INSERT INTO user (FirstName, LastName, Email, Username, Password) VALUES (?, ?, ?, ?, ?)",
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getUsername(),
				newUser.getPassword()
				);
	}

//	@Override
//	public boolean login(RegisterModel model) 
//	{
//		RegisterModel result = jdbcTemplate.queryForObject(
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
