package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación del EntityManagerFactory para el acceso a datos.
 *
 */
@Singleton
@LocalBean
public class EntityManagerFactoryImpl implements IEntityManagerFactory {
	
	@PersistenceUnit(name="biometria-bachue")
	EntityManagerFactory iemf_factory;

	@Override
	public EntityManager getEntityManager(){
		return 	 iemf_factory.createEntityManager();
	}
}
