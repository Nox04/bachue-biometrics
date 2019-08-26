package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface con los metodos del singleton del EntityManagerFactory.
 *
 */
@Local
public interface IEntityManagerFactory {

  /**
   * Metodo que accede al singleton del entity manager.
   */
	EntityManager getEntityManager();

}
