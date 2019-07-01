package com.bachue.snr.se.libraries.daos;

import javax.persistence.EntityManager;
import javax.ejb.Local;

@Local
public interface IEntityManagerFactory {
	
	EntityManager getEntityManager();

}
