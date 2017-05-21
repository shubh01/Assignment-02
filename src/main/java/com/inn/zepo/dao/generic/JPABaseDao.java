package com.inn.zepo.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPABaseDao <Pk,Entity> implements IBaseDao<Pk, Entity>{
	
	Logger logger=LoggerFactory.getLogger(JPABaseDao.class);
	
	@PersistenceContext(name="DEFAULT",type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	private Class<Entity> type;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public JPABaseDao(Class<Entity> type)
	{
		this.type=type;
	}

	public Class<Entity> getType() {
		return type;
	}

	public void setType(Class<Entity> type) {
		this.type = type;
	}

	@Override
	public Entity create(Entity entity)  throws Exception{
		logger.info(this.getClass().getCanonicalName()+" @method create");
		if(entity!=null)
		{
			return getEntityManager().merge(entity);
		}else
		{
			throw new Exception("Null entity in create");
		}
	}

	@Override
	public void delete(Entity entity)  throws Exception{
		logger.info(this.getClass().getCanonicalName()+" @method delete");
		if(entity!=null)
		{
			getEntityManager().remove(getEntityManager().contains(entity)?entity:getEntityManager().merge(entity));
		}else
		{
			throw new Exception("Null entity in delete");
		}
		
	}

	@Override
	public Entity update(Entity entity)  throws Exception{
		logger.info(this.getClass().getCanonicalName()+" @method update");
		if(entity!=null)
		{
			return getEntityManager().merge(entity);
		}else
		{
			throw new Exception("Null entity in update");
		}
	}

	@Override
	public Entity findByPk(Pk pk)  throws Exception{
		logger.info(this.getClass().getCanonicalName()+" @method findByPk");
		if(pk!=null)
		{
			return getEntityManager().find(getType(), pk);
		}else
		{
			throw new Exception("Null pk in find");
		}
	}

	@Override
	public void deleteByPk(Pk pk)  throws Exception{
		logger.info(this.getClass().getCanonicalName()+" @method deleteByPk");
		if(pk!=null)
		{
			Entity entity=findByPk(pk);
			if(entity!=null)
				getEntityManager().remove(getEntityManager().contains(entity)?entity:getEntityManager().merge(entity));
			else
			{
				throw new Exception("entity not found with pK: "+pk);
			}
		}
	}
}
