package com.inn.zepo.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.inn.zepo.modal.Users;
import com.inn.zepo.service.IUsersService;

@Path("Users")
@Service("UsersRestImpl")
@Consumes("application/json")
@Produces("application/json")
public class UsersRestImpl {	

	@Autowired
	private IUsersService usersService;
	
	@GET
	@Path("checkMethod")
	public void checkMethod() throws Exception
	{
		Users users=new Users();
		usersService.create(users);
	}
	
	@GET
	@Path("getUserDetail")
	public Users getUserDetail()
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		Users users=(Users)authentication.getPrincipal();
		
		return users;
	}
	
	
}
