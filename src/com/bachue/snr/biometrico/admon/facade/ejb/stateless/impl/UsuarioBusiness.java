package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.ClaveDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ISesionDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IUsuarioDAO;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.SesionHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.UsuarioHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.ValidadorHelper;
import com.bachue.snr.biometrico.admon.persistence.model.Usuario;
import com.bachue.snr.biometrico.biometrics.Criptografia;

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

  @EJB
  private ISesionDAO iisd_sesionDao;

  @EJB
  private ILogDAO iild_logDao;

  @Override
  public String crearUsuario(UsuarioDTO aud_usuario) {
    String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave());
    if(ls_resultado.equals("Validado exitosamente")) {
      return String.valueOf(iiud_usuarioDao.crearUsuario(UsuarioHelper.toEntity(aud_usuario)));
    } else {
      return ls_resultado;
    }
  }

  @Override
  public String actualizarClave(UsuarioDTO aud_usuario) {
    String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave());
    if(ls_resultado.equals("Validado exitosamente")) {
      iild_logDao.crearEvento(LogHelper.crearLogDeActualizacionDeClave(aud_usuario));
      return String.valueOf(iiud_usuarioDao.actualizarClave(UsuarioHelper.usuarioConClave(aud_usuario)));
    } else {
      return ls_resultado;
    }
  }

  @Override
  public Boolean obtenerUsuario(String as_id) {
    return iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(as_id)) != null;
  }

  @Override
  public Boolean verificarUsuario(ClaveDTO acd_clave) {
    Usuario lu_usuario = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(acd_clave.getIdUsuario()));
    boolean lb_resultado = lu_usuario.getClaveHash().equals(Criptografia.encrypt(acd_clave.getClave()));
    iisd_sesionDao.crearSesion(SesionHelper.crearSesionConClave(acd_clave, lb_resultado));
    iild_logDao.crearEvento(LogHelper.crearLogDeVerificacionConClave(acd_clave, lb_resultado));
    return true;
  }
}
