package com.gcu.data;

public interface IUserDataAccess<T> 
{
	public int createUser(T newUser);
	//boolean login(T model);
}
