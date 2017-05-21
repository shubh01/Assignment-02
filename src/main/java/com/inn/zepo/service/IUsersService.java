package com.inn.zepo.service;

import com.inn.zepo.modal.Users;
import com.inn.zepo.service.generic.IGenericService;

public interface IUsersService extends IGenericService<Integer, Users>{

	Users findUserForAuthentification(String userName);

}
