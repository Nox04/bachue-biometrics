package com.bachue.snr.se.libraries.daos;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Singleton
@LocalBean
public class EntityManagerFactoryImpl implements IEntityManagerFactory{
	
	@PersistenceUnit(name="ant-project-snr")
	EntityManagerFactory factory;

	@Override
	public EntityManager getEntityManager(){
		return 	 factory.createEntityManager();
	}
}
