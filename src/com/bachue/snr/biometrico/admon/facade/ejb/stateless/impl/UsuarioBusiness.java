package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.enums.RespuestaUsuarioEnum;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.ClaveDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.helper.*;
import com.bachue.snr.biometrico.admon.persistence.model.Historico;
import com.bachue.snr.biometrico.admon.persistence.model.Usuario;
import com.bachue.snr.biometrico.biometrics.Criptografia;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
  private IHistoricoDAO iihd_historicoDao;

  @EJB
  private IHuellaDAO iihd_huellaDao;

  @EJB
  private ISesionDAO iisd_sesionDao;

  @EJB
  private ILogDAO iild_logDao;

  @Override
  public String crearUsuario(UsuarioDTO aud_usuario) {
    String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave());
    if(ls_resultado.equals("Validado exitosamente")) {
      iiud_usuarioDao.crearUsuario(UsuarioHelper.toEntity(aud_usuario));
      return String.valueOf(iihd_historicoDao.crearHistorico(HistoricoHelper.userToHistorico(aud_usuario)));
    } else {
      return ls_resultado;
    }
  }

  @Override
  public String actualizarClave(UsuarioDTO aud_usuario) {
    String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave());
    if(ls_resultado.equals("Validado exitosamente")) {
      Usuario lu_usuarioActual = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(aud_usuario.getIdUsuario()));
      if(lu_usuarioActual.getClaveHash().equals(Criptografia.encrypt(aud_usuario.getClave()))) {
        return "La clave ingresada debe ser diferente a la actual";
      } else {
        List<Historico> llh_historico = iihd_historicoDao.consultarUltimasCincoClaves(Criptografia.encrypt(aud_usuario.getIdUsuario()));
        boolean lb_claveUsada = false;

        for(Historico claveActual : llh_historico) {
          if(Objects.equals(Criptografia.encrypt(aud_usuario.getClave()), claveActual.getClaveHash())) {
            lb_claveUsada = true;
          }
        }

        if(lb_claveUsada) {
          return "La clave ingresada debe ser diferente a las últimas cinco utilizadas";
        } else {
          iild_logDao.crearEvento(LogHelper.crearLogDeActualizacionDeClave(aud_usuario));
          iihd_historicoDao.crearHistorico(HistoricoHelper.userToHistorico(aud_usuario));
          return String.valueOf(iiud_usuarioDao.actualizarClave(UsuarioHelper.usuarioConClave(aud_usuario)));
        }
      }
    } else {
      return ls_resultado;
    }
  }

  @Override
  public String obtenerUsuario(String as_id) {
    boolean lb_usuarioExiste = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(as_id)) != null;
    if(lb_usuarioExiste) {
      int li_cuenta = iihd_huellaDao.contarHuellas(Criptografia.encrypt(as_id));
      if(li_cuenta > 0) {
        return RespuestaUsuarioEnum.USUARIO_EXISTE.toString();
      } else {
        return RespuestaUsuarioEnum.USUARIO_NO_TIENE_HUELLAS.toString();
      }
    } else {
      return RespuestaUsuarioEnum.USUARIO_NO_EXISTE.toString();
    }
  }

  @Override
  public Boolean verificarUsuario(ClaveDTO acd_clave) {
    Usuario lu_usuario = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(acd_clave.getIdUsuario()));
    boolean lb_resultado = (lu_usuario.getClaveHash().equals(Criptografia.encrypt(acd_clave.getClave())) && lu_usuario.getFechaVencimiento().after(new Date()));
    iisd_sesionDao.crearSesion(SesionHelper.crearSesionConClave(acd_clave, lb_resultado));
    iild_logDao.crearEvento(LogHelper.crearLogDeVerificacionConClave(acd_clave, lb_resultado));
    return true;
  }
}
