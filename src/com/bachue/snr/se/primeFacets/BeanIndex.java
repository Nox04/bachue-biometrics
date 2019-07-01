package com.bachue.snr.se.primeFacets;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bachue.snr.se.libraries.enums.RolesEnum;
import com.bachue.snr.se.libraries.utils.UsuarioUtilidades;

@ManagedBean(name="index")
@ViewScoped
public class BeanIndex {
	
	private Boolean estado;
	private String usuario;
	
	@PostConstruct
	public void init() {
		UserDetails usuarioDetail = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String role = UsuarioUtilidades.consultarRole(usuarioDetail);
		usuario = usuarioDetail.getUsername();
		if (role.equals(RolesEnum.ADMIN.getRole())) {
			estado = true;
		} else {
			estado = false;
		}
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
