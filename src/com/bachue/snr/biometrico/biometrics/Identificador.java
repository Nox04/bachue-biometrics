package com.bachue.snr.biometrico.biometrics;

import com.neurotec.biometrics.NBiometricOperation;
import com.neurotec.biometrics.NBiometricTask;
import com.neurotec.biometrics.NMatchingSpeed;
import com.neurotec.biometrics.NSubject;
import com.neurotec.io.NBuffer;

import java.util.EnumSet;

public class Identificador {

  @SuppressWarnings("resource")
public boolean identificar(String as_uri) {
    NSubject lns_subject = new NSubject();
    NBiometricTask lnbt_tarea;

    try {
      NBuffer lnb_buffer = Extractor.crearTemplate(as_uri);
      if(lnb_buffer != null){
        lns_subject.setTemplateBuffer(lnb_buffer);
      } else {
        return false;
      }

    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
      return false;
    }

    MotorBiometrico.getInstance().getCliente().setFingersMatchingSpeed(NMatchingSpeed.HIGH);
    lnbt_tarea = MotorBiometrico.getInstance().getCliente().createTask(EnumSet.of(NBiometricOperation.IDENTIFY), lns_subject);
    MotorBiometrico.getInstance().getCliente().performTask(lnbt_tarea);

    if (lns_subject.getMatchingResults().size() > 0) {
      System.err.println(lns_subject.getMatchingResults().get(0).getId());
      return true;
    } else {
      return false;
    }
  }
}
