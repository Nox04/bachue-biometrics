package com.bachue.snr.se.primeFacets;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bachue.snr.se.libraries.shared.business.interfaces.IUsuarioBusiness;
import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Bean JSF para gestionar ciclo de vida del componente usuario
 */
@ManagedBean(name="usuarios")
@ViewScoped
public class BeanUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	IUsuarioBusiness usuarioBusiness;

	private List<UsuarioDTO> usuarios;
	private UsuarioDTO usuario;
	private UsuarioDTO usuarioNuevo;
	private Integer idSeleccionado;
	private Boolean estado;

	@PostConstruct
	public void init() {
		usuarios = usuarioBusiness.consultarUsuarios();
		usuario = usuarios.get(0);
		idSeleccionado = usuario.getId();
		usuarioNuevo = new UsuarioDTO();
	}

	public void crearUsuario() {
		estado = usuarioBusiness.crearUsuario(usuarioNuevo);
		usuarios = usuarioBusiness.consultarUsuarios();
		usuario = usuarios.get(0);
		idSeleccionado = usuario.getId();
		usuarioNuevo = new UsuarioDTO();
	}

	public void consultarUsuario(Integer idUsuario) {
		this.usuario = usuarioBusiness.consultarUsuario(idUsuario);
	}

	public Boolean getEstado() {
		return estado;
	}

	public Integer getIdSeleccionado() {
		return idSeleccionado;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public UsuarioDTO getUsuarioNuevo() {
		return usuarioNuevo;
	}
	
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public void setIdSeleccionado(Integer idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioNuevo(UsuarioDTO usuarioNuevo) {
		this.usuarioNuevo = usuarioNuevo;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}



}
