package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl.IBiometriaLogDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IBiometriaLogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.helper.BiometriaLogHelper;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Implementación de lógica de negocio de logs.
 *
 */
@Stateless(name="BiometriaLogBusiness", mappedName="ejb/BiometriaLogBusiness")
@LocalBean
public class BiometriaLogBusiness implements IBiometriaLogBusiness {
  @EJB
  private IBiometriaLogDAO biometriaLogDao;

  @Override
  public Boolean registrarEvento(LogDTO log) {
    return biometriaLogDao.registrarEvento(BiometriaLogHelper.toEntity(log));
  }
}
