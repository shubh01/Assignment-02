package com.inn.zepo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inn.zepo.dao.IUsersDao;
import com.inn.zepo.modal.Users;
import com.inn.zepo.service.IUsersService;

@Service
@Transactional
public class UsersServiceImpl implements IUsersService{

	private IUsersDao usersDao;
	
	Logger logger=LoggerFactory.getLogger(UsersServiceImpl.class);
	
	@Autowired
	public void setDao(IUsersDao dao)
	{
		usersDao=dao;
	}

	@Override
	public Users create(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method create");
		return usersDao.create(entity);
	}

	@Override
	public void delete(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method delete");
		 usersDao.delete(entity);
	}

	@Override
	public Users update(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method update");
		return usersDao.update(entity);
	}

	@Override
	public Users findByPk(Integer pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method findByPk");
		return usersDao.findByPk(pk);
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method deleteByPk");
		 usersDao.deleteByPk(pk);
	}
	
	@Override
	public Users findUserForAuthentification(String userName)
	{
		logger.info(this.getClass().getCanonicalName()+" @method findUserForAuthentification @param userName: "+userName);
		return usersDao.findUserForAuthentification(userName);
	}
	
}
