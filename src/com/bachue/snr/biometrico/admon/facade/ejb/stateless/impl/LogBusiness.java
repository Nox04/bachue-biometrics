package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de lógica de negocio de logs.
 *
 */
@Stateless(name="BiometriaLogBusiness", mappedName="ejb/LogBusiness")
@LocalBean
public class LogBusiness implements ILogBusiness {
  @EJB
  private ILogDAO biometriaLogDao;

  @Override
  public Boolean registrarEvento(LogDTO log) {
    return biometriaLogDao.registrarEvento(LogHelper.toEntity(log));
  }
}
