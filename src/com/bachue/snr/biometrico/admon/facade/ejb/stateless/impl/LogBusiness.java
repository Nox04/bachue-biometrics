package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de lógica de negocio de logs.
 *
 */
@Stateless(name="LogBusiness")
@Local
public class LogBusiness implements ILogBusiness {
  @EJB
  private ILogDAO iild_logDao;

  @Override
  public Boolean registrarEvento(LogDTO ald_log) {
    return iild_logDao.crearEvento(LogHelper.toEntity(ald_log));
  }

  @Override
  public int consultarStats(String as_tipo, String as_id) {
    return iild_logDao.consultarStats(as_tipo, as_id);
  }
}
