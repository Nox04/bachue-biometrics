package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IConstanteBusiness;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de usuario.
 *
 */
@Stateless(name="ConstanteBusiness")
@Local
public class ConstanteBusiness implements IConstanteBusiness {
  @EJB
  private IConstanteDAO iicd_constanteDao;


  @Override
  public List<Constante> obtenerConstantes() {
    return iicd_constanteDao.obtenerConstantes();
  }
}
