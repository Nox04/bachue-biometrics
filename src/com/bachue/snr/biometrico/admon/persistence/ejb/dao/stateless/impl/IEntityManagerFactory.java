package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import javax.persistence.EntityManager;
import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Interface con los métodos del singleton del EntityManagerFactory.
 *
 */
@Local
public interface IEntityManagerFactory {
	
	EntityManager getEntityManager();

}
