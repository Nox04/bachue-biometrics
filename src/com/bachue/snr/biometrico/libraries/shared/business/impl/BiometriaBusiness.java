package com.bachue.snr.biometrico.libraries.shared.business.impl;

import com.bachue.snr.biometrico.libraries.daos.interfaces.IBiometriaDAO;
import com.bachue.snr.biometrico.libraries.shared.business.interfaces.IBiometriaBusiness;
import com.bachue.snr.biometrico.libraries.shared.dtos.HuellaDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Implementación de lógica de negocio de operaciones biométricas.
 *
 */
@Stateless(name="BiometriaBusiness", mappedName="ejb/BiometriaBusiness")
@LocalBean
public class BiometriaBusiness implements IBiometriaBusiness {
  @EJB
  private IBiometriaDAO biometriaDao;

  @Override
  public Boolean verificarHuella(HuellaDTO huella) {
    return true; //UsuarioHelper.toDto(usuarioDao.consultarUsuario(idUsuario));
  }

  @Override
  public Boolean enrolarHuella(HuellaDTO huella) {
    return true /*usuarioDao.crearUsuario(UsuarioHelper.toEntity(usuario))*/;
  }
}
