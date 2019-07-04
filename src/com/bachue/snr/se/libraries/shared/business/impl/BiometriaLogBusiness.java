package com.bachue.snr.se.libraries.shared.business.impl;

import com.bachue.snr.se.libraries.daos.interfaces.IBiometriaLogDAO;
import com.bachue.snr.se.libraries.shared.business.interfaces.IBiometriaLogBusiness;
import com.bachue.snr.se.libraries.shared.dtos.LogDTO;
import com.bachue.snr.se.libraries.shared.dtos.helper.BiometriaLogHelper;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
