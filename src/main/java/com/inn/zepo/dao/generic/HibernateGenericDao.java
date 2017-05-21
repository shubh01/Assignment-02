package com.inn.zepo.dao.generic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateGenericDao<Pk, Entity> extends JPABaseDao<Pk, Entity> implements IGenericDao<Pk, Entity>
{
	Logger logger=LoggerFactory.getLogger(HibernateGenericDao.class);

	public HibernateGenericDao(Class<Entity> type) {
		super(type);
	}

	@Override
	public Entity create(Entity entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method create");
		return super.create(entity);
	}

	@Override
	public void delete(Entity entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method delete");
		super.delete(entity);
	}

	@Override
	public Entity update(Entity entity) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method update");
		return super.update(entity);
	}

	@Override
	public Entity findByPk(Pk pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method findByPk");
		return super.findByPk(pk);
	}

	@Override
	public void deleteByPk(Pk pk) throws Exception {
		logger.info(this.getClass().getCanonicalName()+" @method deleteByPk");
		super.deleteByPk(pk);
	}
}
