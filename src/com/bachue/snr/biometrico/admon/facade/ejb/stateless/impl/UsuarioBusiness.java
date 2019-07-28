package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IUsuarioDAO;
import com.bachue.snr.biometrico.admon.persistence.helper.UsuarioHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.ValidadorHelper;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de usuario.
 *
 */
@Stateless(name="UsuarioBusiness")
@Local
public class UsuarioBusiness implements IUsuarioBusiness {
  @EJB
  private IUsuarioDAO iiud_usuarioDao;

  @Override
  public String crearUsuario(UsuarioDTO aud_usuario) {
    String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave());
    if(ls_resultado.equals("Validado exitosamente")) {
      return String.valueOf(iiud_usuarioDao.crearUsuario(UsuarioHelper.toEntity(aud_usuario)));
    } else {
      return ls_resultado;
    }
  }
}
