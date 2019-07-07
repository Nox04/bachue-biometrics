package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de lógica de negocio de operaciones biométricas.
 *
 */
@Stateless(name="BiometriaBusiness", mappedName="ejb/HuellaBusiness")
@LocalBean
public class HuellaBusiness implements IHuellaBusiness {
  @EJB
  private IHuellaDAO biometriaDao;

  @Override
  public Boolean verificarHuella(HuellaDTO huella) {
    return true; //UsuarioHelper.toDto(usuarioDao.consultarUsuario(idUsuario));
  }

  @Override
  public Boolean enrolarHuella(HuellaDTO huella) {
    return true /*usuarioDao.crearUsuario(UsuarioHelper.toEntity(usuario))*/;
  }
}
