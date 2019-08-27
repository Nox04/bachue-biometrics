package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Huella;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de operaciones biometricas.
 *
 */
@Local
public interface IHuellaDAO {

  /**
   * Metodo que agrega los campos de huella que son obtenibles desde el request.
   * @param ah_huella Request con la informacion HTTP de la peticion recibida.
   * @return true si la huella es creada con exito.
   */
  Boolean crearHuella(Huella ah_huella);

  /**
   * Metodo que borra las huellas de la base de datos.
   * @param as_idUsuario String con el id del usuario.
   * @return true si la huella es eliminada con exito.
   */
  Boolean borrarHuellas(String as_idUsuario);

  /**
   * Metodo que cuenta las huellas de un usuario en la base de datos.
   * @param as_idUsuario String con el id del usuario.
   * @return numero de huellas del usuario en el sistema.
   */
  int contarHuellas(String as_idUsuario);

  /**
   * Metodo que obtiene las huellas de un usuario de la base de datos.
   * @param as_idUsuario String con el id del usuario.
   * @return huellas del usuario en el sistema.
   */
  List<Huella> obtenerHuellas(String as_idUsuario);
}
