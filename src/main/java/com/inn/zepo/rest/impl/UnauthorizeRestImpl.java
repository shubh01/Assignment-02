package com.inn.zepo.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.zepo.modal.Users;
import com.inn.zepo.service.IUsersService;

@Path("Unauthorize")
@Service("UnauthorizeRestImpl")
@Consumes("application/json")
@Produces("application/json")
public class UnauthorizeRestImpl {

	@Autowired
	private IUsersService usersService;
	
	@GET
	@Path("createUser")
	public void createUser() throws Exception
	{
		Users user=new Users();
		user.setFirstName("chunnilal");
		user.setLastName("desai");
		user.setPassword("letmein");
		user.setCompany("chunni&dupatta.co.in");
		usersService.create(user);
	}
	
	@POST
	@Path("createEntry")
	public void createEntry(Users user) throws Exception
	{
		System.out.println("inside createEntry");
		usersService.create(user);
	}
	
}
