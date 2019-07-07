package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl.IBiometriaDAO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Implementación de interface de DAO que permite la gestión de operaciones biométricas.
 *
 */
@Stateless
@LocalBean
public class BiometriaDAOImpl implements IBiometriaDAO {

	@EJB
	private IEntityManagerFactory entityFactory;

	@Override
	public Boolean consultarHuella(Integer idUsuario) {
		return true;
	}
}
