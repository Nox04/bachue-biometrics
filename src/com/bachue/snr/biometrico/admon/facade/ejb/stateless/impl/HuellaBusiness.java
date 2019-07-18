package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de lógica de negocio de operaciones biométricas.
 *
 */
@Stateless(name="HuellaBusiness")
@Local
public class HuellaBusiness implements IHuellaBusiness {
  @EJB
  private IHuellaDAO iihd_huellaDao;

  @Override
  public Boolean enrolarHuella(HuellaDTO ahd_huella) {
    return true /*usuarioDao.crearUsuario(UsuarioHelper.toEntity(usuario))*/;
  }

  @Override
  public Boolean verificarHuella(HuellaDTO ahd_huella) {
    return true; //UsuarioHelper.toDto(usuarioDao.consultarUsuario(idUsuario));
  }
}
