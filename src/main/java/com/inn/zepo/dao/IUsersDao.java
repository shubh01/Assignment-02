package com.inn.zepo.dao;

import com.inn.zepo.dao.generic.IGenericDao;
import com.inn.zepo.modal.Users;

public interface IUsersDao extends IGenericDao<Integer, Users>{

	Users findUserForAuthentification(String userName);

}
