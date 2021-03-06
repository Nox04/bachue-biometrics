package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Huella;
import com.neurotec.biometrics.*;
import com.neurotec.io.NBuffer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class Enrolador {
  private NSubject ins_subject;
  private NBuffer inb_buffer;
  private NFTemplate inft_nfTemplate;
  private HuellaDTO ihd_huellaDTO;

  public Enrolador(HuellaDTO ahd_huellaDTO) {
    this.ihd_huellaDTO = ahd_huellaDTO;
  }

  /**
   * Enrola el usuario en la base de datos
   * @return Resultado de la operacion de enrolamiento
   */
  @SuppressWarnings("resource")
public boolean enrolarUsuario(List<Huella> alh_huellas) {
    boolean lb_estado = false;
    try {
      crearCarpeta(ihd_huellaDTO.getIdUsuario());
      inft_nfTemplate = new NFTemplate();

      for (Huella lh_huella: alh_huellas) {
        FileUtils.writeByteArrayToFile(new File("biometria/cache/" + Criptografia.decrypt(ihd_huellaDTO.getIdUsuario())+ "/cache.bmp"), lh_huella.getTemplate());
        inb_buffer = Extractor.crearTemplate("biometria/cache/" + Criptografia.decrypt(ihd_huellaDTO.getIdUsuario())+ "/cache.bmp");
        NTemplate template = new NTemplate(inb_buffer);
        if (template.getFingers() != null) {
          for (NFRecord record : template.getFingers().getRecords()) {
            inft_nfTemplate.getRecords().add(record);
          }
        }
        template.dispose();
        inb_buffer.dispose();
      }

      crearSubject();
      lb_estado = enrolarTemplate();

    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
    } finally {
      limpiar();
    }
    return lb_estado;
  }

  public boolean eliminarHuellas(String as_id) {
    NBiometricStatus lnbs_estado = MotorBiometrico.getInstance().getCliente().delete(as_id);
    return lnbs_estado != NBiometricStatus.OK;
  }

  private void crearSubject() {
    ins_subject = new NSubject();
    if (inft_nfTemplate != null) {
      ins_subject.setTemplate(new NTemplate(inft_nfTemplate.save()));
      ins_subject.setId(this.ihd_huellaDTO.getIdUsuario());
    }
  }

  private boolean enrolarTemplate() throws Exception {
    NBiometricStatus lnbs_estado = MotorBiometrico.getInstance().getCliente().enroll(ins_subject);
    if (lnbs_estado != NBiometricStatus.OK) {
      if (lnbs_estado == NBiometricStatus.DUPLICATE_ID || lnbs_estado == NBiometricStatus.DUPLICATE_FOUND) {
        MotorBiometrico.getInstance().getCliente().delete(this.ihd_huellaDTO.getIdUsuario());
        lnbs_estado = MotorBiometrico.getInstance().getCliente().enroll(ins_subject);
        return lnbs_estado == NBiometricStatus.OK;
      } else {
        throw new Exception("Enrollment was unsuccessful. Status: " + lnbs_estado.toString());
      }
    } else {
      return true;
    }
  }

  private void crearCarpeta(String as_idUsuario) {
    File lf_carpetaUsuario = new File("biometria/cache/" + Criptografia.decrypt(as_idUsuario));
    if (!lf_carpetaUsuario.exists()) lf_carpetaUsuario.mkdirs();
  }

  private void limpiar() {
    if (ins_subject != null) {
      ins_subject.dispose();
    }
  }
}
