package com.inn.zepo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.inn.zepo.modal.Users;
import com.inn.zepo.service.IUsersService;

@Service
public class MyCustomAuthentificationService implements AuthenticationProvider{

	private static final String CREDENCIALES_INCORRECTAS = "Username Password incorrect";
	private static final String ENTER_CREDENCIALES = "Please enter credentials";
	
	@Autowired
	private IUsersService usersService;
	
	@Override
	public Authentication authenticate(Authentication paramAuthentication) throws AuthenticationException {
		String userName=paramAuthentication.getName();
		String password=(String)paramAuthentication.getCredentials();
		if(userName!=null && password!=null && !password.isEmpty() && !userName.isEmpty())
		{
			Users users=usersService.findUserForAuthentification(userName);
			if(users!=null)
			{
				if(password.equals(users.getPassword()))
				{
					return new UsernamePasswordAuthenticationToken(users, password);
				}
			}else
			{
				throw new BadCredentialsException(CREDENCIALES_INCORRECTAS);
			}
		}else
		{
			throw new BadCredentialsException(ENTER_CREDENCIALES);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> paramClass) {
		return true;
	}
	



}
