package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IUsuarioBachueDAO;
import com.bachue.snr.biometrico.admon.persistence.model.UsuarioBachue;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la gestion de usuarios.
 *
 */
@Stateless
@Local
public class UsuarioBachueDAOImpl implements IUsuarioBachueDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public String obtenerSegundoFactor(String as_usuarioId) {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
		UsuarioBachue lub_usuario = lem_entityManager.find(UsuarioBachue.class, as_usuarioId);
		lem_entityManager.close();
		return lub_usuario.getSegundoFactorAutenticacion();
	}
}
