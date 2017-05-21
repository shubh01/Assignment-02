package com.inn.zepo.dao.generic;

public interface IBaseDao<Pk,Entity> {
	
	public Entity create(Entity entity) throws Exception;
	public void delete(Entity entity) throws Exception;
	public Entity update(Entity entity) throws Exception;
	public Entity findByPk(Pk pk) throws Exception;
	public void deleteByPk(Pk pk) throws Exception;

}
