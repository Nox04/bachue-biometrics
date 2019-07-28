package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.neurotec.biometrics.NBiometricStatus;
import com.neurotec.biometrics.NSubject;
import com.neurotec.io.NBuffer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Enrolador {
  private NSubject ins_subject;
  private NBuffer inb_buffer;
  private HuellaDTO ihd_huellaDTO;

  public Enrolador(HuellaDTO ahd_huellaDTO) {
    this.ihd_huellaDTO = ahd_huellaDTO;
  }

  /**
   * Enrola el usuario en la base de datos
   * @return Resultado de la operacion de enrolamiento
   */
  public boolean enrolarUsuario() {
    boolean lb_estado = false;
    try {
      crearCarpeta();
      byte[] data = Base64.decodeBase64(this.ihd_huellaDTO.getTemplate());
      FileUtils.writeByteArrayToFile(new File("biometria/cache/" + this.ihd_huellaDTO.getUsuarioId()+ ".bmp"), data);
      if(new Identificador().identificar("biometria/cache/" + this.ihd_huellaDTO.getUsuarioId()+ ".bmp")){
        return false;
      }
      FileUtils.writeByteArrayToFile(new File("biometria/huellas/" + this.ihd_huellaDTO.getUsuarioId()+ ".bmp"), data);
      inb_buffer = Extractor.crearTemplate("biometria/huellas/" + this.ihd_huellaDTO.getUsuarioId() + ".bmp");
      if (inb_buffer != null) {
        crearSubject();
        lb_estado = enrolarTemplate();
      }
    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
    } finally {
      limpiar();
    }
    return lb_estado;
  }

  private void crearSubject() {
    ins_subject = new NSubject();
    ins_subject.setTemplateBuffer(inb_buffer);
    ins_subject.setId(this.ihd_huellaDTO.getUsuarioId());
  }

  private boolean enrolarTemplate() throws Exception {
    NBiometricStatus lnbs_estado = MotorBiometrico.getInstance().getCliente().enroll(ins_subject);
    if (lnbs_estado != NBiometricStatus.OK) {
      if (lnbs_estado == NBiometricStatus.DUPLICATE_ID || lnbs_estado == NBiometricStatus.DUPLICATE_FOUND) {
        MotorBiometrico.getInstance().getCliente().delete(this.ihd_huellaDTO.getUsuarioId());
        lnbs_estado = MotorBiometrico.getInstance().getCliente().enroll(ins_subject);
        return lnbs_estado == NBiometricStatus.OK;
      } else {
        throw new Exception("Enrollment was unsuccessful. Status: " + lnbs_estado.toString());
      }
    } else {
      return true;
    }
  }

  private void crearCarpeta() {
    File lf_carpeta = new File("biometria/huellas");
    if (!lf_carpeta.exists()) lf_carpeta.mkdirs();
  }

  private void limpiar() {
    if (ins_subject != null) {
      ins_subject.dispose();
    }
  }
}
