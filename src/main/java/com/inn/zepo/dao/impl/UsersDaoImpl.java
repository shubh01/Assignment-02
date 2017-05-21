package com.inn.zepo.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.zepo.dao.IUsersDao;
import com.inn.zepo.dao.generic.HibernateGenericDao;
import com.inn.zepo.modal.Users;
import com.inn.zepo.utils.Dao;

@Dao
public class UsersDaoImpl extends HibernateGenericDao<Integer, Users> implements IUsersDao{

	Logger logger=LoggerFactory.getLogger(UsersDaoImpl.class);
	
	public UsersDaoImpl() {
		super(Users.class);
	}

	@Override
	public Users create(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method create");
		return super.create(entity);
	}

	@Override
	public void delete(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method delete");
		super.delete(entity);
	}

	@Override
	public Users update(Users entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method update");
		return super.update(entity);
	}

	@Override
	public Users findByPk(Integer pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method findByPk");
		return super.findByPk(pk);
	}

	@Override
	public void deleteByPk(Integer pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method deleteByPk");
		super.deleteByPk(pk);
	}
	
	@Override
	public Users findUserForAuthentification(String userName)
	{
		logger.info(this.getClass().getCanonicalName()+" @method findUserForAuthentification @param userName: "+userName);
		Users users=null;
		try {
			users=(Users) getEntityManager().createNativeQuery("select u.* from users u where u.username='"+userName+"'",Users.class).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getClass().getCanonicalName()+" exception occured @method findUserForAuthentification @param userName: "+userName,e);
		}
		return users;
	}

	
}
