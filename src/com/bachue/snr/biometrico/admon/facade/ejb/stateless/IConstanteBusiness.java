package com.bachue.snr.biometrico.admon.facade.ejb.stateless;


import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de negocio de usuarios.
 *
 */
public interface IConstanteBusiness {


  List<Constante> obtenerConstantes();
}
