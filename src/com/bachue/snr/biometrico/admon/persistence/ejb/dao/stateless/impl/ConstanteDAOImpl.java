package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IConstanteDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la gestion de usuarios.
 *
 */
@Stateless
@Local
public class ConstanteDAOImpl implements IConstanteDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public List<Constante> obtenerConstantes() {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();

		String query = "SELECT u.idConstante, u.caracter FROM Constante u";
		List<Constante> llc_constante = lem_entityManager.createQuery(query, Constante.class).getResultList();
		lem_entityManager.close();
		return llc_constante;
	}
}
